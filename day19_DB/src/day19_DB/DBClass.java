package day19_DB;

public class DBClass {
	public DBClass() {
		try {
			//�ڹٿ��� ����Ŭ�� ������ �� �ְԲ� �����ִ� ���̺귯�� ���.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
