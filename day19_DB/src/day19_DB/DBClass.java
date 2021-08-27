package day19_DB;

public class DBClass {
	public DBClass() {
		try {
			//자바에서 오라클에 연결할 수 있게끔 도와주는 라이브러리 등록.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
