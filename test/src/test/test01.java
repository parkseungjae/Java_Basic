package test;

import java.util.ArrayList;
import java.util.Scanner;

public class test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String userId = "    홍길동    ";
		if(name.equals(userId.trim())) {
			System.out.println("인증통과!!!");
		}else {
			System.out.println("인증실패!!!");
		}

	}
}
