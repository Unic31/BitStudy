package study.day0303;

import java.util.Random;
import java.util.Scanner;

public class Ex16Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money;
		int[] lotto = new int[6];
		Random r = new Random();

		// 금액을 입력 후 금액만큼 로또 출력(1~45사이 중복 없는 숫자로 오름차순 정렬)
		// 단 금액이 1000원 미만이면 "금액이 부족합니다" 출력 후 메인 종료
		// 입력한 금액만큼 (천원당1회) 반복해서 로또 숫자 구한 후 정렬 후 출력
		/*
		 * 예) 로또 구입 금액:5000
		 * 
		 * 1회 : 5 12 25 34 41 45 2회 : 3회 : 4회 : 5회 :
		 */

		System.out.println("금액을 입력해 주세요");
		money = sc.nextInt();
		if (money < 1000) {
			System.out.println("금액이 부족합니다");
		} else {
			for (int n = 1; n <= money / 1000; n++) {

				Lotto: for (int i = 0; i < lotto.length; i++) {

					lotto[i] = r.nextInt(45) + 1;
					for (int j = 0; j < i; j++) {
						if (lotto[i] == lotto[j]) {
							i--;
							continue Lotto;
						}
					}

				}
				for (int i = 0; i < lotto.length; i++) {
					for (int j = i + 1; j < lotto.length; j++) {
						if (lotto[i] > lotto[j]) {
							int temp = lotto[i];
							lotto[i] = lotto[j];
							lotto[j] = temp;

						}
					}
				}
				System.out.print(n + "회");
				for (int lo : lotto) {
					System.out.printf("%4d", lo);

				}
				System.out.println();
			}

		}

	}
}
