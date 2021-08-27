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
			//자바에서 오라클에 연결할 수 있게끔 도와주는 라이브러리 등록.
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
	/*1.드라이브 로드(오라클 기능 사용)
	2.연결된 객체를 얻어옴.
	3.연결된 객체를 이용해서 명령어(쿼리문)을 전송할 수 있는 전송 객채를 얻어온다.
	4.전송 객체를 이용해서 데이터베이스에 전송후 결과를 얻어온다.
	5.얻어온 결과는 int 또는 ResultSet으로 받는다.
	 */
	public ArrayList<StudentDTO> getUsers(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		//sql 명령어.
		String sql = "select * from newst";

		//3번
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//명령어를 실행해라.
			/*
			 * bof - 데이터 - eof
			 */
			ResultSet rs = ps.executeQuery();
			//rs를 통해 데이터의 끝이나올때까지 아래 형태의 작업을 진행한다.(sql에있는 
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
			//저장 성공시 1을 반환, 실패시 catch이동이나 0을 반환
			//excuteUpdate 해당 명령어를 DB에서 실행시켜준다.
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("저장에 실패했습니다.");
			e.printStackTrace();
		}
		return result;
	}
	
	//테스트용 query 문 오류 방지를 위한 코딩
	public int saveData02(String stNum, String name, int age) {
		//insert into newst values(stNum, name, age);
		String sql = "insert into newst values(?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ResultSet rs = ps.executeQuery();
			//저장 성공시 1을 반환, 실패시 catch이동이나 0을 반환
			//excuteUpdate 해당 명령어를 DB에서 실행시켜준다.
			ps.setString(1, stNum);
			ps.setString(2, name);
			ps.setInt(3, age);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("저장에 실패했습니다.");
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
