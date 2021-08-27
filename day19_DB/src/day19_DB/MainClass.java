package day19_DB;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		DBClass db = new DBClass();
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println("1.등록 2.전체보기 3.삭제 4.수정");
			num = sc.nextInt();
			switch(num)	{
			case 1 : 
				System.out.println("학번 입력");
				String stNum = sc.next();
				
				System.out.println("이름 입력");
				String name = sc.next();
				
				System.out.println("나이 입력");
				int age = sc.nextInt();
				
				//int result = db.saveData(stNum,name,age);
				int result = db.saveData02(stNum,name,age);
				if(result == 1) {
					System.out.println("성공적으로 저장");
				}else {
					System.out.println("동일한 아이디가 존재합니다.");
				}
				break;
				
			case 2 : 
				ArrayList<StudentDTO> list = db.getUsers();
				if(list.size() == 0) {
					//데이터가 없을경우
					System.out.println("저장된 데이터 없음");
				}else {
					//데이터가 있을경우 for문으로 모든 데이터를 꺼내줌
					for(int i = 0; i<list.size(); i++) {
						System.out.println("학번 : " + list.get(i).getStNum());
						System.out.println("이름 : " + list.get(i).getName());
						System.out.println("나이 : " + list.get(i).getAge());
						System.out.println("-----------------------------");
					}
				}
				break;
			case 3 :
				System.out.println("삭제 학번 입력");
				String userNum = sc.next();
				int re = db.delete(userNum);
				if(re == 1) {
					System.out.println("삭제되었습니다.");
				}else {
					System.out.println("해당 학번은 존재하지 않습니다.");
				}
				break;
			
			case 4 : 
				System.out.println("수정하실 아이디를 입력(존재하는 아이디)");
				String stNum1= sc.next();
				System.out.println("수정할 이름 입력");
				String name1 = sc.next();
				
				System.out.println("수정할 나이 입력");
				int age1 = sc.nextInt();
				if(db.modify(stNum1, name1, age1)==1) {
					System.out.println("수정이 완료 되었습니다.");
				}else {
					System.out.println("해당 아이디가 존재하지 않습니다.");
				}
				break;
			}
		}
	}
}
