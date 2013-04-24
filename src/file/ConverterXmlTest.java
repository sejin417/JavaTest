package file;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import oracle.jdbc.driver.OracleResultSet;

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
public class ConverterXmlTest {
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
	private PreparedStatement testXpathDelete = null;
	private Statement stmt = null;

	//데이타는 Xml에서 자동으로 조회 함
	String objectType = "WiBro";		//WiFi

	String project_insert_sql =
			"INSERT INTO TEST_SEJIN_XPATH ( EBMID, EBMName, CreationDateTime, SEQ, ORD_NO, SA_ID, PATH, Data, TYPE )" +
					"VALUES ( ?,?,?,?,?,?,?,?,? )";

	String select_sql = " SELECT EBMXML_SBST FROM TB_EBM_RCV_TXN " +
			"	where ebm_id in (  " +
			"	        '997a9d2e-0999-4e40-b6b3-b47617712360' " +
//			"	        , '9ad58f77-31c9-48b4-9623-c12a97a04b15' " +
//			"	        , '79ba6557-b441-43ba-b26a-a427b8ffe3f3' " +
//			"	        , 'd2500ca7-bfa9-423d-82ab-3749e6b898d9' " +
//			"	        , '6cf923c1-3bcd-4a85-a4fe-19a45a09d0da' " +
//			"	        , '2365dce0-49ab-4d2a-8832-15c0f183e81f' " +
			" )";

	String deleteSql = " DELETE FROM TEST_SEJIN_XPATH WHERE EBMID = ? ";

	private void dbConnection() throws ClassNotFoundException, SQLException {
		String _driver = "oracle.jdbc.driver.OracleDriver",
				_url = "jdbc:oracle:thin:@10.217.214.56:1524:CDW1MDL",
				_user = "midz_dev",
				_password = "midz_dev!";

		Properties props = new Properties();
		props.put("user", _user );
		props.put("password", _password);
		props.put("SetBigStringTryClob", "true");

		//		Class.forName(_driver);
		DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
		conn = DriverManager.getConnection(_url,props);

		project_insert_ps = conn.prepareStatement(project_insert_sql);
		testXpathDelete = conn.prepareStatement(deleteSql);
	}

	public void close(){
		try{
			if (project_insert_ps!=null) try { project_insert_ps.close (); } catch (Exception ee)	{}
			if (testXpathDelete!=null) try { testXpathDelete.close (); } catch (Exception ee)	{}
			if (stmt != null) {stmt.close(); stmt = null;}
			if (conn != null) {conn.close(); conn = null;}

		}catch(Exception e){}
	}

	public void deleteTestXpath() {
		try {
			testXpathDelete.setString(1,this.ebmId);
			int a = testXpathDelete.executeUpdate();
			print( String.valueOf( a ) );
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			} else if ( (rootPath + "/" + element.getName()).equals("/ProcessProvisioningOrderEBM/DataArea/ProcessProvisioningOrder/ProvisioningOrderLine/ItemReference/Name") ){
				if ( element.getValue().equals("WiFi") ) {
					objectType = element.getValue();
				} else if ( element.getValue().equals("WiBro") ) {
					objectType = element.getValue();
				}

				name = element.getValue();
				if ( name != null && element.getName().equals("Value") ) {
					temp = new DataSchema(rootPath + "[Name=\"" + name +"\"]/" + element.getName(), element.getValue(), seq++, type);
					datas.add( temp );
				}

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

		//xml 출력
//		print( total.toString());

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

			if ( datas.size() > 0 ) {
				print( this.ebmId ) ;
				deleteTestXpath();
				conn.commit();
				for( int i=0;i<datas.size();i++){
					insert( (DataSchema) datas.get(i) );
					//				print( datas.get(i).toString() ) ;
				}
				conn.commit();
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

			start();

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
		ConverterXmlTest test = new ConverterXmlTest();

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

			msg.append("ebmId:"+ConverterXmlTest.this.ebmId+'\n');
			msg.append("ebmName:"+ConverterXmlTest.this.ebmName+'\n');
			msg.append("creationDateTime:"+ConverterXmlTest.this.creationDateTime+'\n');
			msg.append("ORD_NO:"+ConverterXmlTest.this.ordNo+'\n');
			msg.append("SA_ID:"+ConverterXmlTest.this.saId+'\n');

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
