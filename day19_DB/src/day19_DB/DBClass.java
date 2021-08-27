package day19_DB;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBClass {
	
	private String url;
	private String id;
	private String pwd;
	private Connection con;
	
	public DBClass() {
		try {
			//자바에서 오라클에 연결할 수 있게끔 도와주는 라이브러리 등록.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url =  "jdbc:oracle:thin:@localhost:1521:xe";
			id = "tmd0915mp";
			pwd = "0915";
			con = DriverManager.getConnection(url,id,pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
