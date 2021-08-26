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
		System.out.println("�̸� �Է�");
		String name = sc.next();
		Test05 t5 = new Test05();
		t5.setName(name);
		
		//NotSerializableException : ����ȭ�� ���� �ʾƼ� �߻��ϴ� ���� 
		//(�ش�Ŭ������ implements Serializable�� ���־���Ѵ�.)
		oos.writeObject(t5);
		oos.close();
	}

}
