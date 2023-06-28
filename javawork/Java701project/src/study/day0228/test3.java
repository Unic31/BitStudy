package study.day0228;

import java.util.Date;
import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 태어난 년도와 월 일을 키보드로부터 입력받아 그날이 무슨 요일인지 출력하시오
		// scanner, date클래스 사용
		int year, month, day, birth;
		String week;

		System.out.println("년도 입력");
		year = sc.nextInt();
		System.out.println("월 입력");
		month = sc.nextInt();
		System.out.println("일 입력");
		day = sc.nextInt();

		Date date = new Date(year - 1900, month - 1, day);
		birth = date.getDay();// 요일 숫자 일:0....토:6
		week = birth == 0 ? "일"
				: birth == 1 ? "월" : birth == 2 ? "화" : birth == 3 ? "수" : birth == 4 ? "목" : birth == 5 ? "금" : "토";
		System.out.println(week);

//		
		System.out.printf("%d년 %d월 %d일은 %s요일 입니다",year,month,day,week);
	}

}
