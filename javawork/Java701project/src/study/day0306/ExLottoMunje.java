package study.day0306;

import java.util.Random;
import java.util.Scanner;

public class ExLottoMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money;
		int[] lotto = new int[6];
		Random r = new Random();

		// 금액을 입력후 금액만큼 로또 출력(1~45 사이 중복없는 숫자로 오름차순 정렬로 출력)
		// 단 금액이 1000원 미만이면 "금액이 부족합니다" 출력후 메인종료
		// 입력한 금액만큼(천원당1회) 반복해서 로또 숫자 구한후 정렬후 출력
		/*
		 * 예) 로또구입금액: 5000
		 * 
		 * 1회 : 5 12 25 34 41 45 2회 : 3회 : 4회 5회
		 */
		System.out.println("로또 구입금액은?");
		money = sc.nextInt();
		if (money < 1000) {
			System.out.println("금액이 부족합니다");
			return;
		}

		for (int n = 1; n <= money / 1000; n++) {

			// 로또 배열 랜덤숫자 구하기,중복처리
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = r.nextInt(45) + 1;
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;// 또는 continue 레이블
					}
				}
			}
			// 오름차순 정렬
			for (int i = 0; i < lotto.length - 1; i++) {
				for (int j = i + 1; j < lotto.length; j++) {
					if (lotto[i] > lotto[j]) {
						int temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					}
				}
			}
			// 출력
			System.out.printf("%2d회 : ", n);
			for (int lo : lotto) {
				System.out.printf("%4d", lo);
			}
			System.out.println();
		}
	}

}
