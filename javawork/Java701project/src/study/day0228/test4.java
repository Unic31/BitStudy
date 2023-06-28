package study.day0228;

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/* 1.원의 넓이 구하기
		 * 2.사각형의 넓이 구하기
		 * 
		 * 1번 선택시 원의 반지름을 입력받아 원의 넓이를 구해서 출력하고
		 * 2번 선택시 가로와 세로길이를 입력받아 사각형의 넓이를 구해서 출력하시오.
		 */
		double 반지름,가로,세로;
		int select;
		System.out.println("1. 원의 넓이 구하기");
		System.out.println("2. 사각형의 넓이 구하기");
		select = sc.nextInt();
		if(select==1) {
			System.out.println("반지름을 입력해 주세요");
			반지름 = sc.nextDouble();
			System.out.println("반지름이 "+반지름+"인 원의 넓이는 "+(반지름*반지름*Math.PI)+"입니다.");
		}else if(select==2) {
			System.out.println("가로의 길이를 입력해 주세요");
			가로 = sc.nextDouble();
			System.out.println("세로의 길이를 입력해 주세요");
			세로 = sc.nextDouble();
			System.out.println("가로의 길이가 "+가로+", 세로의 길이가 "+세로+"인 사각형의 넓이는 "+(가로*세로)+"입니다.");
		}else {
			System.out.println("1번이나 2번을 선택해 주세요");
		}
	}

}
