package file;

import java.io.File;
import java.io.FileInputStream;

public class Ex02 {
	public static void main(String[] args) throws Exception{
		File file = new File("C:/park's java/abcd1234/test.txt");
		FileInputStream fis = new FileInputStream(file);
		while(true) {
			int res = fis.read();
			
			//������ ����Ʈ ������ ������ �������� �˸��� eof�� ( -1�̴�) ���� ������������ res<0 ������ ��.
			if(res < 0) {
				break;
			}
			System.out.print((char)res);
		}
	}

}
