package test;

import java.util.ArrayList;
import java.util.Scanner;

public class test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String userId = "    ȫ�浿    ";
		if(name.equals(userId.trim())) {
			System.out.println("�������!!!");
		}else {
			System.out.println("��������!!!");
		}

	}
}