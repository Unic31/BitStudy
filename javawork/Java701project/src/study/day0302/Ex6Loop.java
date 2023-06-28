package study.day0302;

public class Ex6Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. 1~20까지의 숫자중 3의 배수만 출력 (printf("%4d",변수) //4칸 단위로 출력)
		for (int a = 1; a <= 20; a++) {
			if (a % 3 == 0) {
				System.out.printf("%4d", a);
			}
		}

		System.out.println();
		// 2. 10~1까지 거꾸로 출력
		for (int b = 10; b >= 1; b--) {
			System.out.printf("%4d", b);
		}

		System.out.println();
		// 3. 1~30까지 숫자중 5의 배수만 출력
		for (int c = 1; c <= 30; c++) {
			if (c % 5 == 0) {
				System.out.printf("%4d", c);
			}
		}

		System.out.println();
		// 4. *20개 출력
		for (int d = 1; d <= 20; d++) {
			System.out.print("*");
		}

		System.out.println();
		// 5. 1~20까지 중 홀수만 출력
		for (int e = 1; e <= 20; e += 2) {
			System.out.printf("%4d", e);
		}
	}

}
