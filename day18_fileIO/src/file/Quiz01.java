package file;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) throws Exception{
		File file = new File("C:/park's java/abcd1234/test.txt");
		FileOutputStream fos = new FileOutputStream(file, true);
		Scanner sc = new Scanner(System.in);
		String nextLine = "\n";
		System.out.print("�̸� �Է� : ");
		String s = sc.next();		

		System.out.print("���� �Է� : ");
		String s1 = sc.next();

		System.out.print("�ּ� �Է� : ");
		String s2 = sc.next();

		fos.write(s.getBytes());
		fos.write(nextLine.getBytes());
		fos.write(s1.getBytes());
		fos.write(nextLine.getBytes());
		fos.write(s2.getBytes());
		fos.write(nextLine.getBytes());

	}
}
