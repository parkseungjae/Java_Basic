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
			//�ڹٿ��� ����Ŭ�� ������ �� �ְԲ� �����ִ� ���̺귯�� ���.
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
