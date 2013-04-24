package com.kt.b2c.osm.midz.sample.wibro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//import org.jdom2.Document;
//import org.jdom2.Element;
//import org.jdom2.JDOMException;
//import org.jdom2.input.SAXBuilder;

/**
 * ibatis xml 파일을 찾아 
 * 입력되는 테이블, 수정되는 테이블, 삭제되는 테이블
 * 프로시져 등의 정보를 검색하는 프로그램
 * 
 * -------------------------------------------------------------------
 * xml명  ; 프로시저 명 ; tablename ; select ; insert ; update ; delete 
 * -------------------------------------------------------------------
 * @author sejin
 *
 */
public class ConverterTest {
	private String path = "";
	private static final String v_separator = ";";
	private static final String v_userId = "WS_HAK.";

	///////////////////////
	//  DB setting
	//  CREATE TABLE TEST_CRUD_METRIX ( File_name   varchar2(100), DATA_TYPE varchar2(3), tb_name varchar2(100) );
	//
	//
	//	SELECT FILE_NAME
	//    , TB_NAME
	//    , MAX ( DECODE(  DATA_TYPE , 'S','Y') ) AS S
	//    , MAX ( DECODE(  DATA_TYPE , 'I','Y') ) AS I
	//    , MAX ( DECODE(  DATA_TYPE , 'U','Y') ) AS U
	//    , MAX ( DECODE(  DATA_TYPE , 'D','Y') ) AS D
	//    , MAX ( DECODE(  DATA_TYPE , 'P','Y') ) AS P
	//FROM TEST_CRUD_METRIX
	//GROUP BY FILE_NAME, TB_NAME
	//ORDER BY FILE_NAME;
	///////////////////////
	Connection conn = null;
	private PreparedStatement project_insert_ps = null;
	String project_insert_sql =
		"INSERT INTO TEST_CRUD_METRIX VALUES ( ? , ? , ? )";

	private void dbConnection() throws ClassNotFoundException, SQLException {
		String _driver = "oracle.jdbc.driver.OracleDriver",
		_url = "jdbc:oracle:thin:@210.93.6.191:1521:WSDB",
		_user = "ws_cmm",
		_password = "gkrtkelql";

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

	private void insert(String fileName, String dataType, String tbName){
		int rc = 1;
		try {
			project_insert_ps.setString(1,fileName);
			project_insert_ps.setString(2,dataType);
			project_insert_ps.setString(3,tbName);
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
		this.path = path;
	}

	/**
	 * 출력
	 * @param fileName
	 * @param list
	 * @param type
	 */
	public void print( String fileName, ArrayList<String> list, String type ) {

		Iterator<String> iter = list.iterator();
		String tableName;
		while ( iter.hasNext() ) {
			tableName = iter.next();

			if ( tableName.endsWith("(") ) {
				tableName = tableName.substring(0,tableName.length()-1);
			}

			if ( fileName.endsWith(".xml") ) {
				fileName = fileName.substring(0, fileName.length()-4 );
			}
			insert(fileName, type,  tableName );
			System.out.println(fileName + v_separator + type + v_separator + tableName );

			if ( type.equals("I") || type.equals("U") || type.equals("D") || type.equals("P") ) {
				break;
			}
		}
	}

	/**
	 * Data Parsing
	 * @param data
	 * @return
	 */
	public ArrayList<String> parsing( String data ) {
		ArrayList<String> list = new ArrayList();

		Scanner sc = new Scanner(data).useDelimiter( v_userId);
		String temp;
		while(sc.hasNext()) {
			temp = sc.next().trim();

			if ( !temp.equals(data)) {
				if ( temp.indexOf(' ') > 0 ) {
					temp = temp.substring(0, temp.indexOf(' ')).trim();
				}
				if ( temp.indexOf('\t') > 0 ) {
					temp = temp.substring(0, temp.indexOf('\t')).trim();
				}

				if ( ! ( temp.equals("") || 
						temp.toUpperCase().startsWith("SELECT") || 
						temp.toUpperCase().startsWith("INSERT") || 
						temp.toUpperCase().startsWith("UPDATE") || 
						temp.toUpperCase().startsWith("DELETE") || 
						temp.toUpperCase().startsWith("MERGE") ||  
						temp.toUpperCase().startsWith("DECLARE") ||
						temp.toUpperCase().startsWith("{") ) ) {
					list.add( temp );
				}
			}
		}
		return list;
	}

	/**
	 * Xml Parsing
	 * type : S:select , I:insert , U:update , D:delete , P:procedure , u:unknown
	 * @param file
	 */
	public void convert(File file) {

		try {
			FileInputStream in = new FileInputStream(file);
			SAXReader builder = new SAXReader();
			Document doc = builder.read(in);
			Element root = doc.getRootElement();
			String type = "S";

			List<Element> elements = root.elements();
			for( Element element:elements ) {
				if ( element.getName().equals("select") ) {
					type = "S";
				} else if ( element.getName().equals("insert") ) {
					type = "I";
				} else if ( element.getName().equals("update") ) {
					type = "U";
				} else if ( element.getName().equals("delete") ) {
					type = "D";
				} else if ( element.getName().equals("procedure") ) {
					type = "P";
				} else {
					type = "u";
				}
				print( file.getName(), parsing( element.getText()) , type ); 
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void start( File file ) {

		File[] files = file.listFiles();

		for( int i=0; i<files.length; i++ ) {
			if ( files[i].isDirectory() ) {
				start(files[i]);
			} else if ( files[i].getName().endsWith(".xml") ) {
				convert( files[i] );
			}
		}

	}

	public void run() {
		try {
			if ( conn == null ) dbConnection();

			File startFile = new File( this.path );
			if ( startFile.isDirectory() ) {
				start( startFile );
			} else if ( startFile.isFile() ) {
				convert( startFile );
			}
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
		ConverterTest test = new ConverterTest();
		test.setPath("D:\\ws_project\\workspace\\WS_Main_Application\\java_src\\HAK");
//		test.setPath("D:\\HAK_JANG_0730.xml");
		test.run();
	}
}
