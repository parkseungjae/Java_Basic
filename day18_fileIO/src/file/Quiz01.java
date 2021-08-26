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
		System.out.print("이름 입력 : ");
		String s = sc.next();		

		System.out.print("나이 입력 : ");
		String s1 = sc.next();

		System.out.print("주소 입력 : ");
		String s2 = sc.next();

		fos.write(s.getBytes());
		fos.write(nextLine.getBytes());
		fos.write(s1.getBytes());
		fos.write(nextLine.getBytes());
		fos.write(s2.getBytes());
		fos.write(nextLine.getBytes());

	}
}
