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
		System.out.println("�̸� : " + getName());
		System.out.println("�̸� : " + getAddr());
		System.out.println("�̸� : " + getAge());
		System.out.println("�̸� : " + getKor());
		System.out.println("�̸� : " + getEng());
		System.out.println("�̸� : " + getMath());
		System.out.println("===================");
	}

}

class FileClass {
	StudentClass si = new StudentClass();

	Scanner sc = new Scanner(System.in);
	public void MkFile(StudentClass outSt) throws Exception{
		System.out.println("�л� ������ �Է����ּ���...");
		File filePath = new File("C:/park's java/quiz210826/"+outSt.getName()+".txt");
		FileOutputStream fos = new FileOutputStream(filePath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		System.out.println(outSt.getName()+"�� �� ������ �߰��Ǿ����ϴ�");
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
		System.out.println("�л� ��� ");
		System.out.print("�̸� : ");
		si.setName(sc.next()); 
		System.out.print("�ּ� : ");
		si.setAddr(sc.next()); 
		System.out.print("���� : ");
		si.setAge(sc.nextInt());
		System.out.print("���� : ");
		si.setKor(sc.nextInt());
		System.out.print("���� : ");
		si.setEng(sc.nextInt());
		System.out.print("���� : ");
		si.setMath(sc.nextInt()); 
		System.out.println("�л� ������ ��ϵǾ����ϴ�.\n");

	}

	public void selectSt() throws Exception {
		while(true) {
			System.out.println("ã������ �л��� �̸��� �Է��� �ּ��� : ");
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
				System.out.println("�Է��Ͻ� ������ �����ϴ�.");
				break;
			}
		}
	}
	 */
}


public class Quiz01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileClass outMember = new FileClass(); // �߰�����

		Scanner input = new Scanner(System.in);
		ArrayList<StudentClass> arr = new ArrayList<StudentClass>();
		String stName,stAddr;
		int kor,eng,math;
		int num;
		boolean bl;
		while(true){
			System.out.println("1.�л� �˻�");
			System.out.println("2.���");
			System.out.println("3.����");
			System.out.print(">>> ");
			num = input.nextInt();
			StudentClass st = new StudentClass();
			switch(num){
			case 1:
				System.out.print("ã�� �л� �й� �Է� : ");
				stName = input.next();
				bl=st.selSt(arr,stName);
				st = outMember.fileRead(stName); // �߰�����
				if(bl == true || st != null){ //�߰� ����
					System.out.println("�̸� : "+st.getName());
					System.out.println("�ּ� : "+st.getAddr());
					System.out.println("���� : "+st.getKor());
					System.out.println("���� : "+st.getEng());
					System.out.println("���� : "+st.getMath());
				}else{
					System.out.println("ã�� �л��� �����ϴ�!!!");
				}
				break;
			case 2:
				bl =true;
				while(bl){
					System.out.print("�й� �Է� : ");
					stName = input.next();
					st.setName(stName);
					bl = st.chkStName(arr); 
					bl = outMember.chkFile(stName); // �߰�����
					if(bl == true ){
						System.out.println("�����ϴ� �й� �Դϴ�!!!");
						System.out.println("�ٽ� �Է� �ϼ���");
					}
				}
				System.out.print("�̸� �Է� : ");
				stName = input.next();
				System.out.print("���� ���� �Է� : ");
				kor = input.nextInt();
				System.out.print("���� ���� �Է� : ");
				eng = input.nextInt();
				System.out.print("���� ���� �Է� : ");
				math = input.nextInt();
				st.setName(stName);st.setKor(kor);
				st.setEng(eng);	st.setMath(math);
				arr.add(st);
				outMember.MkFile(st); //�߰� ����
				System.out.println("���� �Ǽ̽��ϴ�!!!");
				break;
			case 3:return ;
			}
		}

	}
}
