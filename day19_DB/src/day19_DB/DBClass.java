package day19_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


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
			//2.
			con = DriverManager.getConnection(url,id,pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*1.����̺� �ε�(����Ŭ ��� ���)
	2.����� ��ü�� ����.
	3.����� ��ü�� �̿��ؼ� ��ɾ�(������)�� ������ �� �ִ� ���� ��ä�� ���´�.
	4.���� ��ü�� �̿��ؼ� �����ͺ��̽��� ������ ����� ���´�.
	5.���� ����� int �Ǵ� ResultSet���� �޴´�.
	 */
	public ArrayList<StudentDTO> getUsers(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		//sql ��ɾ�.
		String sql = "select * from newst";

		//3��
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//��ɾ �����ض�.
			/*
			 * bof - ������ - eof
			 */
			ResultSet rs = ps.executeQuery();
			//rs�� ���� �������� ���̳��ö����� �Ʒ� ������ �۾��� �����Ѵ�.(sql���ִ� 
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStNum(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public int saveData(String stNum, String name, int age) {
		//insert into newst values(stNum, name, age);
		String sql = "insert into newst values('"+stNum+"','" +name+"','" +age+"')";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ResultSet rs = ps.executeQuery();
			//���� ������ 1�� ��ȯ, ���н� catch�̵��̳� 0�� ��ȯ
			//excuteUpdate �ش� ��ɾ DB���� ��������ش�.
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("���忡 �����߽��ϴ�.");
			e.printStackTrace();
		}
		return result;
	}
	
	//�׽�Ʈ�� query �� ���� ������ ���� �ڵ�
	public int saveData02(String stNum, String name, int age) {
		//insert into newst values(stNum, name, age);
		String sql = "insert into newst values(?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ResultSet rs = ps.executeQuery();
			//���� ������ 1�� ��ȯ, ���н� catch�̵��̳� 0�� ��ȯ
			//excuteUpdate �ش� ��ɾ DB���� ��������ش�.
			ps.setString(1, stNum);
			ps.setString(2, name);
			ps.setInt(3, age);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("���忡 �����߽��ϴ�.");
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(String userNum) {
		int result = 0;
		//delete from newst where id = 'userNum';
		String sql = "delete from newst where id = ?";
		try {
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userNum);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int modify(String StNum1, String name1, int age1) {
		int result = 0;
		String sql = "update newst set name = ? , age = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name1);
			ps.setInt(2, age1);
			ps.setString(3, StNum1);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
