package study.day0228;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		// 점수를 반복적으로 입력받아 총 몇개 입력인지 출력하고 그 점수들의 합계를 출력하시오
		// 점수 0 입력시 while 문 빠져나와서 합계와 갯수 출력
		// (while,scanner)
		int su;
		int total = 0;
		int 갯수 = 0;

		while (true) {
			System.out.println("점수를 입력하세요");
			su = sc.nextInt();
			갯수++;
			total += su;
			if (su == 0) {
				System.out.println("점수는 총 " + 갯수 + "개 입니다");
				System.out.println("점수는 총 " + total + "점 입니다");
				break;
			}
		}
	}

}
