package study.day0302;

import java.util.Scanner;

public class Ex9Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int menu;
		int su1, su2, sum;

		Exit: // 레이블(break Exit;
		while (true) {
			System.out.println("**메뉴**");
			System.out.println("1. 숫자 입력 후 1부터 그 숫자까지 합계 구하기");
			System.out.println("2. 2개의 숫자 입력 후 숫자1~숫자2까지 합계 구하기");
			System.out.println("3. 숫자 입력 후 Factorial구하기(1부터 그 숫자까지의 곱하기)");
			System.out.println("4. 두개의 숫자(su1,su2) 입력 후 su1의 su2승 구하기");
			System.out.println("5. 종료");

			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("숫자를 입력하세요");
				su1 = sc.nextInt();
				sum = 0;
				for (int i = 1; i <= su1; i++) {
					sum += i;
				}
				System.out.printf("1부터 %d까지의 합계는 %d입니다\n", su1, sum);
//				su2 = 0;
//				for(sum=1;sum<su1;sum++) {
//					su2+=sum;			
//				}	System.out.println(su2+su1);
				break;
			case 2:
				System.out.println("두개의 숫자를 입력하세요");
				su1 = sc.nextInt();
				su2 = sc.nextInt();
				sum = 0;
				for (int i = su1; i <= su2; i++) {
					sum += i;
				}
				System.out.printf("%d부터 %d까지의 합계는 %d입니다\n", su1, su2, sum);
				break;
			case 3:
				System.out.println("factorial 구할 숫자를 입력하세요");
				su1 = sc.nextInt();
				sum = 1;
				for (int i = 1; i <= su1; i++) {
					sum *= i;
//				for (int i=su1;i>sum;i--) {
//					sum+=sum*i;
				}
				System.out.printf("%d ! = %d\n", su1, sum);
				break;
			case 4:
				System.out.println("지수승을 구할 두 숫자 입력");
				su1 = sc.nextInt();
				su2 = sc.nextInt();
				sum = 1;
				for (int i = 1; i <= su2; i++) {
					sum *= su1;
				}
				System.out.printf("%d의 %d승은 %d입니다\n", su1, su2, sum);
				break;
			default:
				System.out.println("**프로그램 종료**");
				// break; // break만 쓸 경우 switch만 빠져나와서 while문은 계속 반복됨
				break Exit;// break Exit; 하면 break위치로 빠져나가서 모든게 중단
			}
			System.out.println();
		}
	}

}
