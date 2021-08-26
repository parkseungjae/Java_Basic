package file;

import java.io.File;
import java.io.FileOutputStream;

public class Ex01 {
	public static void main(String[] args) throws Exception{
		//new File(파일경로);
		File filePath = new File("C:/park's java/test/aaa.txt");
		//FOS(filePath, **true = 기존내용에서 이어서 진행하겠다 ( 이전내용작업과 별개로 추가된다.))
		FileOutputStream fos = new FileOutputStream(filePath, true);
		
		
		fos.write(97);
		fos.write('A');
		
		String name = "안녕하세요";
		
		//배열형태의 값을 받을 때는 getBytes() 를 사용해주어야 값을 받을 수 있다.
		fos.write( name.getBytes());
		
	}
}
