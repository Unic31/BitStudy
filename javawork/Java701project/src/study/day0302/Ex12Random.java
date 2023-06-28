package study.day0302;

import java.util.Random;

public class Ex12Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자바에서 난수를 구하는 방법이 두가지가 있다
		//1.Math.random()
		for(int i=1;i<=5;i++) {
//			double r=Math.random();//0.000.... ~ 0.999...까지의 난수 발생
//			System.out.println(r);
			
			//0~9까지의 난수
			int r=(int)(Math.random()*10);
			System.out.println(r);			
		}
		
		System.out.println("=".repeat(20));
		//2.Random클래스
		Random random=new Random();
		for(int i=1;i<=5;i++) {
			int r=random.nextInt(10);//0~9사이의 난수
			System.out.println(r);
		}
		System.out.println("=".repeat(20));
		for(int i=1;i<=5;i++) {
//			int r=random.nextInt(26)+65;//A~Z (65~90)  (0~25)+65 가 되는것
			int r=random.nextInt(26)+97;//a~z (97~122)   (0~25)+97
			System.out.println((char)r);
		}
		
		
		
		
	}

}
