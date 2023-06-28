package study.day0228;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		// 상품명과 수량 단가를 입력받아서 총 금액을 구해서 출력하시오
		// (단 수량이 5개 이상이면 총 금액 출력 후 10프로 DC된 금액도 같이 출력해주세요)
		/*
		 * 예시 상품명 딸기 수량 5 단가 1000
		 * 
		 * 총 5000원 10프로 할인된 금액 4500원
		 */
		String 상품명;
		int 수량, 단가;
		double 할인금액;
		System.out.println("상품명을 입력해 주세요");
		상품명 = sc.nextLine();
		System.out.println("수량을 입력해 주세요");
		수량 = sc.nextInt();
		System.out.println("단가를 입력해 주세요");
		단가 = sc.nextInt();
		System.out.println("상품명 : " + 상품명);
		System.out.println("수량 : " + 수량 + "개");
		할인금액 = (수량 * 단가) - (수량 * 단가 * 0.1);
		System.out.println("단가 : " + 단가 + "원");
		if (수량 >= 5) {
			System.out.println("총 : " + (단가 * 수량) + "원이며 10% 할인된 금액은 " + (int) 할인금액 + "원 입니다");
		} else {
			System.out.println("총 : " + (단가 * 수량) + "원");
		}
	}

}
