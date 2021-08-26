package file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ex06 {
	public static void main(String[] args) throws Exception{
		File filePath = new File("C:/park's java/abcd1234/test.txt");
		FileInputStream fis = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Test05 t5 = (Test05)ois.readObject();
		t5.print();
	}

}
