package study.day0302;

import java.util.Date;

import java.util.Scanner;

public class Ex3Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int year, month, day, 요일;
		String weekday;

		System.out.println("년도와 월 일을 차례대로 입력해주세요");
		year = sc.nextInt();
		month = sc.nextInt();
		day = sc.nextInt();

		// date 클래스 생성
		Date date = new Date(year - 1900, month - 1, day);
		// 요일 숫자 구하기
		요일 = date.getDay();
		// 요일구하기
		weekday = 요일 == 0 ? "일"
				: 요일 == 1 ? "월" : 요일 == 2 ? "화" : 요일 == 3 ? "수" : 요일 == 4 ? "목" : 요일 == 5 ? "금" : "토";

		System.out.printf("%d년 %02d월 %02d일은 %s요일 입니다", year, month, day, weekday);

	}

}
