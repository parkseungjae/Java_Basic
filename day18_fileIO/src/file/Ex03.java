package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Ex03 {
	public static void main(String[] args) throws Exception{
		File filePath = new File("C:/park's java/abcd1234/test.txt");
		//fos는 직접적으로 파일에 작업을 수행함
		FileOutputStream fos = new FileOutputStream(filePath);
		//bos는 직접적으로 파일로 접근하는 것이 아닌 자신의 저장소에 먼서 저장을 한다.
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//1초에 하나씩 매번 접근을 하게 된다
		for(char i= '1'; i < '9'; i++) {
			Thread.sleep(1000);
			//bos 공간에 작업
			bos.write(i);
		}
		//Buffer공간을 비워냄 (작업량을 파일로 출력함)
		bos.close();
		bos.write('a');
		bos.flush();
	}
}
