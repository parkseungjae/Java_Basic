package file;

import java.io.File;
import java.io.FileOutputStream;

public class Ex01 {
	public static void main(String[] args) throws Exception{
		//new File(���ϰ��);
		File filePath = new File("C:/park's java/test/aaa.txt");
		//FOS(filePath, **true = �������뿡�� �̾ �����ϰڴ� ( ���������۾��� ������ �߰��ȴ�.))
		FileOutputStream fos = new FileOutputStream(filePath, true);
		
		
		fos.write(97);
		fos.write('A');
		
		String name = "�ȳ��ϼ���";
		
		//�迭������ ���� ���� ���� getBytes() �� ������־�� ���� ���� �� �ִ�.
		fos.write( name.getBytes());
		
	}
}
