package study.day0228;

import java.util.Scanner;

public class Ex9Operator {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//관계연산자 : > < >= <= == !=
//		//논리연산자 : &&(and) ||(or) !(not)
//		int kor=100,eng=80,mat=100;
//		System.out.println(kor>eng);//t
//		System.out.println(kor==mat);//t
//		System.out.println(!(kor==mat));//f
//		System.out.println(kor>eng && kor>mat);//f
//		System.out.println(kor>eng || kor>mat);//t

		Scanner sc = new Scanner(System.in);
		int kor, eng, mat;
		/*
		 * 3과목의 점수가 40 이상이고 평균이 60 이상이면 "합격" 그렇지 않을 경우 "불합격" 출력
		 */
		double avg;
		System.out.println("점수를 입력하세요");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();

		avg = (kor + eng + mat) / 3.0;
//		System.out.println("3과목의 평균:" + avg);
		System.out.printf("3과목의 평균:%5.1f\n", avg);
		// 나머지 조건 부분
		// if-else문 이용
		if (kor >= 40 && eng >= 40 && mat >= 40 && avg >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

	}

}
