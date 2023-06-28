package study.day0228;

import java.util.Date;
import java.util.Scanner;

public class Ex13Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year,month,day;
		String week;
		/*
		 * 년도와 월을 입력하면 그 달의 1일이 무슨 요일인지 출력해보자(달력만들때 필요함)
		 */
		
		System.out.println("년도 입력");
		year=sc.nextInt();
		System.out.println("월 입력");
		month=sc.nextInt();
		
		Date date=new Date(year-1900, month-1, 1);
		day=date.getDay();//요일 숫자 일:0....토:6
		
		week=day==0?"일":day==1?"월":day==2?"화":day==3?"수":day==4?"목":day==5?"금":"토";
		
		System.out.printf("%d년 %d월 1일은 %s요일 입니다",year,month,week);
	}

}
