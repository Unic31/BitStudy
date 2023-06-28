package study.day0228;

import java.util.Scanner;

public class Ex7Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int money;
		System.out.println("당신의 월 급여는?");
		money=sc.nextInt();
//		int 만원 = money/10000;
//		int 천원 = (money%10000)/1000;
//		int 백원 = ((money%10000)%1000)/100;
//		int 십원 = 	(((money%10000)%1000)%100)/10;
//		int 일원 = 	((((money%10000)%1000)%100)%10);
//		System.out.println("월급은 "+money+"원\n만원 : "+(만원)+"장\n천원 : "+(천원)+"장\n백원 : "+(백원)+"개\n십원 : "
//				+십원+"개\n일원 : "+(일원)+"개");
		/*
		 *  예) 2345678원
		 *  	만원 : 234장
		 *  	천원 : 5장
		 *  	백원 : 6개
		 *  	십원 : 7개
		 *  	일원 : 8개
		  */
		System.out.println("만원 : "+money/10000+"장");
		System.out.println("천원 : "+(money%10000)/1000+"장");
		System.out.println("백원 : "+(money%1000)/100+"개");
		System.out.println("십원 : "+(money%100)/10+"개");
		System.out.println("일원 : "+(money%10)+"개");
		
	}

}
