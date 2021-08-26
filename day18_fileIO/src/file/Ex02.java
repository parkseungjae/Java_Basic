package file;

import java.io.File;
import java.io.FileInputStream;

public class Ex02 {
	public static void main(String[] args) throws Exception{
		File file = new File("C:/park's java/abcd1234/test.txt");
		FileInputStream fis = new FileInputStream(file);
		while(true) {
			int res = fis.read();
			
			//파일을 바이트 단위로 가져와 마지막을 알리는 eof값 ( -1이다) 까지 가져오기위해 res<0 조건을 줌.
			if(res < 0) {
				break;
			}
			System.out.print((char)res);
		}
	}

}
