package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Ex03 {
	public static void main(String[] args) throws Exception{
		File filePath = new File("C:/park's java/abcd1234/test.txt");
		//fos�� ���������� ���Ͽ� �۾��� ������
		FileOutputStream fos = new FileOutputStream(filePath);
		//bos�� ���������� ���Ϸ� �����ϴ� ���� �ƴ� �ڽ��� ����ҿ� �ռ� ������ �Ѵ�.
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//1�ʿ� �ϳ��� �Ź� ������ �ϰ� �ȴ�
		for(char i= '1'; i < '9'; i++) {
			Thread.sleep(1000);
			//bos ������ �۾�
			bos.write(i);
		}
		//Buffer������ ����� (�۾����� ���Ϸ� �����)
		bos.close();
		bos.write('a');
		bos.flush();
	}
}
