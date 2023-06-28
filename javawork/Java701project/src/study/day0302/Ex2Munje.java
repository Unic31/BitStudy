package study.day0302;

import java.util.Scanner;

public class Ex2Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String sang;
		int su, dan, total;

		System.out.println("상품명 입력");
		sang = sc.nextLine();
		System.out.println("수량과 단가를 각각 입력");
		su = sc.nextInt();
		dan = sc.nextInt();
		total = su * dan;

		System.out.println("총 " + total + "원");
		if (su >= 5) {
			// total=(int)(total*0.9);
			total = total * 9 / 10;

			System.out.println("10프로 할인된 금액 " + total + "원");

		}
	}

}
