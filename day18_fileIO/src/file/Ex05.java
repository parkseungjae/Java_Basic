package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) throws Exception{
		
		File filePath = new File("C:/park's java/abcd1234/test.txt");
		FileOutputStream fos = new FileOutputStream(filePath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
	
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력");
		String name = sc.next();
		Test05 t5 = new Test05();
		t5.setName(name);
		
		//NotSerializableException : 직렬화를 하지 않아서 발생하는 오류 
		//(해당클래스에 implements Serializable을 해주어야한다.)
		oos.writeObject(t5);
		oos.close();
	}

}
