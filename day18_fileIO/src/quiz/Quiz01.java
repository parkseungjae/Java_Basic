package quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import file.FileInOut;
import file.Member;

class StudentClass implements Serializable{
	private String name, addr;
	private int age;
	private int kor, eng, math;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

	public boolean chkStName(ArrayList<StudentClass> arr) {
		for(StudentClass s:arr ) {
			if(s.getName().equals(this.name)==true)
				return true;
		}
		return false;
	}

	public boolean selSt(ArrayList<StudentClass> arr, String stName	) {
		for(StudentClass s:arr) {
			if(s.getName().equals(stName)==true) {
				setName(stName);
				setAddr(s.getAddr());
				setAge(s.getAge());
				setKor(s.getKor());
				setEng(s.getEng());
				setMath(s.getMath());
				return true;
			}

		}
		return false;
	}


	public void print() {
		System.out.println("==================");
		System.out.println("이름 : " + getName());
		System.out.println("이름 : " + getAddr());
		System.out.println("이름 : " + getAge());
		System.out.println("이름 : " + getKor());
		System.out.println("이름 : " + getEng());
		System.out.println("이름 : " + getMath());
		System.out.println("===================");
	}

}

class FileClass {
	StudentClass si = new StudentClass();

	Scanner sc = new Scanner(System.in);
	public void MkFile(StudentClass outSt) throws Exception{
		System.out.println("학생 정보를 입력해주세요...");
		File filePath = new File("C:/park's java/quiz210826/"+outSt.getName()+".txt");
		FileOutputStream fos = new FileOutputStream(filePath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		System.out.println(outSt.getName()+"님 의 정보가 추가되었습니다");
		oos.writeObject((Object)outSt);
		oos.close();
	}
	public StudentClass fileRead(String stName) throws IOException, ClassNotFoundException{
		StudentClass st = null;
		File dir = new File("C:/park's java");
		File f3 = new File(dir, stName+".txt");
		try {
			FileInputStream fis = new FileInputStream(f3);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			st = (StudentClass)ois.readObject();
			ois.close();
		}catch(FileNotFoundException e){
			return null;
		}
		return st;
	}
	public boolean chkFile(String stName) throws IOException{
		File dir = new File("C:/park's java");
		File f3 = new File(dir, stName+".txt");
		if(f3.createNewFile()) {return false;}
		return true;
	}
	/*
	public void regist() {
		System.out.println("학생 등록 ");
		System.out.print("이름 : ");
		si.setName(sc.next()); 
		System.out.print("주소 : ");
		si.setAddr(sc.next()); 
		System.out.print("나이 : ");
		si.setAge(sc.nextInt());
		System.out.print("국어 : ");
		si.setKor(sc.nextInt());
		System.out.print("영어 : ");
		si.setEng(sc.nextInt());
		System.out.print("수학 : ");
		si.setMath(sc.nextInt()); 
		System.out.println("학생 정보가 등록되었습니다.\n");

	}

	public void selectSt() throws Exception {
		while(true) {
			System.out.println("찾으려는 학생의 이름을 입력해 주세요 : ");
			String selName = sc.next();
			File filePath = new File("C:/park's java/abcd1234/"+selName+".txt");

			if(filePath.createNewFile()) {
				FileInputStream fis = new FileInputStream(filePath);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);

				si = (StudentClass)ois.readObject();
				si.print();
				break;
			}else {
				System.out.println("입력하신 정보가 없습니다.");
				break;
			}
		}
	}
	 */
}


public class Quiz01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileClass outMember = new FileClass(); // 추가내용

		Scanner input = new Scanner(System.in);
		ArrayList<StudentClass> arr = new ArrayList<StudentClass>();
		String stName,stAddr;
		int kor,eng,math;
		int num;
		boolean bl;
		while(true){
			System.out.println("1.학생 검색");
			System.out.println("2.등록");
			System.out.println("3.종료");
			System.out.print(">>> ");
			num = input.nextInt();
			StudentClass st = new StudentClass();
			switch(num){
			case 1:
				System.out.print("찾을 학생 학번 입력 : ");
				stName = input.next();
				bl=st.selSt(arr,stName);
				st = outMember.fileRead(stName); // 추가내용
				if(bl == true || st != null){ //추가 내용
					System.out.println("이름 : "+st.getName());
					System.out.println("주소 : "+st.getAddr());
					System.out.println("국어 : "+st.getKor());
					System.out.println("영어 : "+st.getEng());
					System.out.println("수학 : "+st.getMath());
				}else{
					System.out.println("찾는 학생이 없습니다!!!");
				}
				break;
			case 2:
				bl =true;
				while(bl){
					System.out.print("학번 입력 : ");
					stName = input.next();
					st.setName(stName);
					bl = st.chkStName(arr); 
					bl = outMember.chkFile(stName); // 추가내용
					if(bl == true ){
						System.out.println("존재하는 학번 입니다!!!");
						System.out.println("다시 입력 하세요");
					}
				}
				System.out.print("이름 입력 : ");
				stName = input.next();
				System.out.print("국어 점수 입력 : ");
				kor = input.nextInt();
				System.out.print("영어 점수 입력 : ");
				eng = input.nextInt();
				System.out.print("수학 점수 입력 : ");
				math = input.nextInt();
				st.setName(stName);st.setKor(kor);
				st.setEng(eng);	st.setMath(math);
				arr.add(st);
				outMember.MkFile(st); //추가 내용
				System.out.println("가입 되셨습니다!!!");
				break;
			case 3:return ;
			}
		}

	}
}
