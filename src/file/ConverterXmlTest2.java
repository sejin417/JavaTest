package file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * Xml 파일의 모드들을 Text 형태로 변경 
 * 1. EBMHeader 안에 EBMID, EBMName, CreationDateTime 정보와  
 * 		DataArea 안에 오더번호, 서비스 계약ID 를 중요 Key 값으로 세팅
 * 2. 각각의 노드들을 Path 값과 Key 값으로 세팅
 * 		(중복 가능하여 SEQ 추가생성)
 * 3. 테이블 입력
 * 4. 입력된 테이블과 Mst 테이블을 COM_PROVISION_EBM(Path)값과 Join 해서 보고서 생성 
 * 
 * @author sejin
 *
 */
public class ConverterXmlTest2 {
	private String rootPath = "D:\\201301_KT-MiddleZone\\11_mapping\\05.orderEBM\\sample\\Cancel_sample.xml";
	private static final String v_separator = ";";

	String ebmId;
	String ebmName;
	String creationDateTime;
	String ordNo;
	String saId;
	int seq = 0;

	///////////////////////
	//  DB setting
	//  CREATE TABLE TEST_SEJIN_XPATH ( 
	//		EBMID   			varchar2(100),  
	//		EBMName   			varchar2(100),  
	//		CreationDateTime	varchar2(100),
	//		SEQ					NUMBER(3),
	//		ORD_NO   			varchar2(100),  
	//		SA_ID   			varchar2(100),  
	//		PATH   				varchar2(100),  
	//		Data   				varchar2(100), 
	//		type				varchar2(20)
	//	);
	//
	///////////////////////
	Connection conn = null;
	private PreparedStatement project_insert_ps = null;
	private Statement stmt = null;
	String project_insert_sql =
			"INSERT INTO TEST_SEJIN_XPATH ( EBMID, EBMName, CreationDateTime, SEQ, ORD_NO, SA_ID, PATH, Data, TYPE )" +
					"VALUES ( ?,?,?,?,?,?,?,?,? )";
	String select_sql = " SELECT EBMXML_SBST FROM TB_EBM_RCV_TXN "+
			" WHERE LOB_NM = 'WiFi' "+
			" and  EBM_ID = '89c90d52-34b4-4194-a2c4-e883aa00459f'";

	private void dbConnection() throws ClassNotFoundException, SQLException {
				String _driver = "oracle.jdbc.driver.OracleDriver",
				_url = "jdbc:oracle:thin:@10.217.214.56:1524:CDW1MDL",
				_user = "midz_dev",
				_password = "midz_dev!";
		
				Class.forName(_driver);
				conn = DriverManager.getConnection(_url,_user,_password);
				project_insert_ps = conn.prepareStatement(project_insert_sql);
	}

	public void close(){
				try{
					if (project_insert_ps!=null) try { project_insert_ps.close (); } catch (Exception ee)	{}
					if (conn != null) {conn.close(); conn = null;}
				}catch(Exception e){}
	}

	private void insert(DataSchema insertData){

		// INSERT INTO TEST_SEJIN_XPATH 
		//	( EBMID, EBMName, CreationDateTime, SEQ, ORD_NO, 
		//	  SA_ID, PATH, Data )
		// VALUES ( ?,?,?,?,?,
		//          ?,?,? );
		int rc = 1;
		try {
			project_insert_ps.setString(1,this.ebmId);
			project_insert_ps.setString(2,this.ebmName);
			project_insert_ps.setString(3,this.creationDateTime);
			project_insert_ps.setInt   (4,this.seq);
			project_insert_ps.setString(5,this.ordNo);
			project_insert_ps.setString(6,this.saId);

			project_insert_ps.setString(7,insertData.getPath());
			project_insert_ps.setString(8,insertData.getData());
			if ( insertData.getType() == null || insertData.getType().equals("Order Line Data") ) {
				project_insert_ps.setString(9,"-");
			} else {
				project_insert_ps.setString(9,insertData.getType());
			}

			rc = project_insert_ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	/**
	 * 검색 Paht 설정
	 * @param path
	 */
	public void setPath( String path ) {
		this.rootPath = path;
	}

	/**
	 * 출력
	 * @param fileName
	 * @param list
	 * @param type
	 */
	public void print( String msg) {
		System.out.println( msg );
	}
	
	public String getProvisioningOrderLineType( Element node ) {
		String type = null;

		List<Element> elements = node.getChildren();

		DataSchema temp;
		for( Element element:elements ) {
			if ( element.getName().equals("ItemReference") ){
				List<Element> refNode = element.getChildren();

				for( Element tmp:refNode ) {
					if ( tmp.getName().equals("ClassificationCode") ){
						org.jdom2.Attribute att = tmp.getAttribute("listID");
						if ( att.getValue().equals("FulfillmentItemCode") ) {
							type = tmp.getValue();
							break;
						}
					}
				}
			}
		}
		
		if ( type != null ) {
			if ( type.indexOf("Line of Business") > -1 ) {
				type = "Order Line Data";
			} else if ( type.indexOf("Price Plan") > -1 ) {
				type = "Price Plan";
			} else if ( type.indexOf("Device") > -1 ) {
				type = "Device";
			} else if ( type.indexOf("VAS") > -1 ) {
				type = "VAS";
			}
		}
		return type;
	}

	/**
	 * Data Parsing
	 * @param data
	 * @return
	 */
	public Vector parsing( String rootPath, Element node, String type ) {
		Vector datas = new Vector(); 
		List<Element> elements = node.getChildren();

		DataSchema temp;
		String name =null;
		boolean isOrdLine = false;
		for( Element element:elements ) {

			if ( type == null && isOrdLine) {
				print("DDD");
			}
			//ProvisioningOrderLineType 일경우 Type 검색
			if ( element.getName().equals("ProvisioningOrderLine") ) {
				type = getProvisioningOrderLineType( element );
				if ( type != null ) {
					isOrdLine = true;
				}
			}
			
			if ( element.getChildren().size() > 0  ) {
				datas.addAll( parsing( rootPath + "/" + element.getName(), element, type ) );
			} else if ( (rootPath + "/" + element.getName()).equals("/ProcessProvisioningOrderEBM/DataArea/ProcessProvisioningOrder/Identification/ID") ){
				this.ordNo = element.getValue(); 
				temp = new DataSchema(rootPath + "/" + element.getName(), element.getValue(), seq++, type);
				datas.add( temp );
			} else if ( (rootPath + "/" + element.getName()).equals("/ProcessProvisioningOrderEBM/DataArea/ProcessProvisioningOrder/ProvisioningOrderLine/Custom/KTSubscriptionID") ){
				this.saId = element.getValue(); 
				temp = new DataSchema(rootPath + "/" + element.getName(), element.getValue(), seq++, type);
				datas.add( temp );
			} else {
				
				if ( element.getName().equals("Name") ) {
					name = element.getValue();
				}
				
				if ( name != null && element.getName().equals("Value") ) {
					temp = new DataSchema(rootPath + "[Name=\"" + name +"\"]/" + element.getName(), element.getValue(), seq++, type);
					datas.add( temp );
				}

				temp = new DataSchema(rootPath + "/" + element.getName(), element.getValue(), seq++, type);
				datas.add( temp );

			}
		}

		return datas;
	}

	public void setHeader( List<Element> elements ) {
		for( Element element:elements ) {
			if ( element.getName().equals("EBMID")) {
				this.ebmId = element.getValue();
			} else if ( element.getName().equals("EBMName")) {
				this.ebmName = element.getValue();
			} else if ( element.getName().equals("CreationDateTime")) {
				this.creationDateTime = element.getValue();
			}
		}
	}

	/**
	 * Xml Parsing
	 * type : S:select , I:insert , U:update , D:delete , P:procedure , u:unknown
	 * @param file
	 */
	public void convert(File file) {
		print( file.getName() + " File start ---------------");

		Vector datas = new Vector();
		try {
			FileInputStream in = new FileInputStream(file);
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(in);
			Element root = doc.getRootElement();

			List<Element> elements = root.getChildren();
			for( Element element:elements ) {
				if ( element.getName().equals("EBMHeader")) {
					setHeader( element.getChildren() );
					Vector temp =parsing( "/ProcessProvisioningOrderEBM/EBMHeader", element, null );
					if ( temp != null ) 
						datas.addAll(temp);
				} else if ( element.getName().equals("DataArea" ) ) {
					datas.addAll(parsing( "/ProcessProvisioningOrderEBM/DataArea", element, null ));
				}
			}

			for( int i=0;i<datas.size();i++){
				insert( (DataSchema) datas.get(i) );
//				print( datas.get(i).toString() ) ;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		print( file.getName() + " File End ---------------");
	}

	public void start( File file ) {

		File[] files = file.listFiles();

		if ( files != null ) {
			for( int i=0; i<files.length; i++ ) {
				start(files[i]);
			}
		} else {
			convert( file );
		}
	}
	
	public void convert(Clob clob) throws SQLException {

		long start = 1;
		int bufferSize = 1024*40;
		StringBuffer total = new StringBuffer();
		String tstr = "";
		for (  ; ;  ) {
			tstr = clob.getSubString(start, bufferSize);
			if ((tstr != null) && !(tstr.equals(""))){
				total.append(tstr);
				start += bufferSize;
			}
			else break;
		}
		print( total.toString());
		
		try {
			SAXBuilder saxBuilder = new SAXBuilder();
			Document doc = saxBuilder.build(new ByteArrayInputStream( total.toString().getBytes()));
			
			Element root = doc.getRootElement();
			Vector datas = new Vector();
			seq = 0;
			List<Element> elements = root.getChildren();
			for( Element element:elements ) {
				if ( element.getName().equals("EBMHeader")) {
					setHeader( element.getChildren() );
					datas.addAll(parsing( "/ProcessProvisioningOrderEBM/EBMHeader", element, null ));
				} else if ( element.getName().equals("DataArea" ) ) {
					datas.addAll(parsing( "/ProcessProvisioningOrderEBM/DataArea", element, null ));
				}
			}

			for( int i=0;i<datas.size();i++){
				insert( (DataSchema) datas.get(i) );
//				print( datas.get(i).toString() ) ;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void start() {
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( select_sql );

			Clob tmpClob;
			while ( rs.next() ){
				tmpClob  = rs.getClob(1);
	            
				convert( tmpClob );
	            
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			if ( conn == null ) dbConnection();

			start( new File( this.rootPath ) );
//			start();

			close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println (" START---------------------");
		ConverterXmlTest2 test = new ConverterXmlTest2();

		test.run();

		System.out.println (" END ---------------------");
	}

	class DataSchema {
		String path;
		String data;
		int seq;
		String type;

		public DataSchema( String path, String data, int seq, String type ) {
			//			this.ebmId = ConverterXmlTest.this.ebmId;

			this.path = path;
			this.data = data;
			this.seq = seq;
			this.type = type;
		}



		public String toString() {
			StringBuffer msg = new StringBuffer();

			msg.append("ebmId:"+ConverterXmlTest2.this.ebmId+'\n');
			msg.append("ebmName:"+ConverterXmlTest2.this.ebmName+'\n');
			msg.append("creationDateTime:"+ConverterXmlTest2.this.creationDateTime+'\n');
			msg.append("ORD_NO:"+ConverterXmlTest2.this.ordNo+'\n');
			msg.append("SA_ID:"+ConverterXmlTest2.this.saId+'\n');

			msg.append("seq:"+this.seq+'\n');
			msg.append("path:"+this.path+'\n');
			msg.append("data:"+this.data+'\n');
			msg.append("type:"+this.type+'\n');
			return msg.toString();
		}



		/**
		 * @return the path
		 */
		public String getPath() {
			return path;
		}



		/**
		 * @param path the path to set
		 */
		public void setPath(String path) {
			this.path = path;
		}



		/**
		 * @return the data
		 */
		public String getData() {
			return data;
		}



		/**
		 * @param data the data to set
		 */
		public void setData(String data) {
			this.data = data;
		}



		/**
		 * @return the seq
		 */
		public int getSeq() {
			return seq;
		}



		/**
		 * @param seq the seq to set
		 */
		public void setSeq(int seq) {
			this.seq = seq;
		}

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}



		/**
		 * @param seq the seq to set
		 */
		public void setType(String type) {
			this.type = type;
		}
	}
}
