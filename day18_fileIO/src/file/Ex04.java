package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex04 {
	public static void main(String[] args) throws Exception{
		File filePath = new File("C:/park's java/abcd1234/test.txt");
		FileOutputStream fos = new FileOutputStream(filePath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		String str = "Test";
		StringBuffer sb = new StringBuffer();
		sb.append("abcd");
		sb.append("111");
		System.out.println(str);
		System.out.println(sb);

		dos.writeUTF("�ڽ���");
		dos.writeInt(100);		
		
		dos.close();
		/*
		 * �����͸� Byte ���·� �ٲ��ִ°� ����ȭ
		 * Byte���¸� ������ȭ ��Ű�°� ������ȭ
		 */
		
		FileInputStream fis = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		String name = dis.readUTF();
		int num = dis.readInt();
		System.out.println("name : " + name);
		System.out.println("num : " + num);
	}

}
