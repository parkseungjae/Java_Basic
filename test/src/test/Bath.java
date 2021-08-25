package test;

import java.util.Scanner;

public class Bath{
	int water;
	double temp =20;

	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}

	public void fillWater(int sec) {
		for(int i = 1; i <=sec; i++) {
			System.out.println(i+"��");
			this.water += 2;
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			if(this.water >= 100) {
				setWater(100);
				System.out.println("������ ����á���ϴ�.");
				break;
			}
		}
		System.out.println("���� " +getWater() + "L �ֽ��ϴ�.");

	}

	public void outWater(int sec) {
		for(int i = 1; i<=sec; i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			System.out.println(i+"��");
			this.water -=2;

			if(this.water <= 0) {
				setWater(0);
				System.out.println("������ ������ϴ�.");
				break;
			}
		}
		System.out.println("���� " +getWater() + "L �ֽ��ϴ�.");

	}
	public void inoutWater(int sec) {
		while(sec != 3) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.�� ä���\t2.�� ������\t3.������ �ٸ� ���");
			int sel =sc.nextInt();
			switch(sel) {
			case 1:
				int selSec =sc.nextInt();				
				this.timer(selSec);
					if(this.water <= 0) {
						setWater(100);
						System.out.println("������ ���� á���ϴ�.");
					}
				
				System.out.println("���� " +getWater() + "L �ֽ��ϴ�.");
				break;		
			case 2:
			}
		}
	}
	public void timer(int sec) {
		System.out.println("�ð��� �Է����ּ��� (��)");
		for(int i = 1; i<=sec; i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			System.out.println("���� ä��� ���Դϴ�... " +i+"��");
			this.water +=2;
		}
	}

	public void upTemp() {
		this.temp +=1;
		if(getTemp() >= 70) {
			this.temp = 70;
			System.out.println("�ʹ� �߰̽��ϴ� �µ��� �����ּ���.");
		}

		System.out.println("���� ���� : " + getTemp());
	}
	public void downTemp() {
		this.temp -=1;
		if(getTemp() <= 0) {
			this.temp = 0;
			System.out.println("�ʹ� �������ϴ� �µ��� �÷��ּ���.");
		}
		System.out.println("���� ���� : " + getTemp());
	}
	public void chkTemp() {

		System.out.println("���� ���� : " + getTemp());
	}

	public void bath() {
		Bath b = new Bath();
		Scanner sc = new Scanner(System.in);
		int select =0, sec = 0;
		while(select != 6) {
			System.out.println("������ �ֽ��ϴ� �Ͻ� ����� �������ּ���");
			System.out.println("1.�� ä���\t2.�� ����\t3.�� �µ� �ø���");
			System.out.println("4.�� �µ� ������\t5.�� �µ� Ȯ��\t6.ȭ��� ������ ������");

			select = sc.nextInt();
			switch(select) {
			case 1:
				System.out.println("ä�� �ð��� �Է����ּ���");
				sec = sc.nextInt();
				b.fillWater(sec);
				break;
			case 2:
				System.out.println("���� ��� �ð��� �Է����ּ���");
				sec = sc.nextInt();
				b.outWater(sec);
				break;
			case 3:
				b.upTemp();
				break;
			case 4:
				b.downTemp();
				break;
			case 5:
				b.chkTemp();
				break;
			case 6:
				System.out.println("ȭ��� ������ �����ϴ�.");
				break;
			}
		}
	}
}
