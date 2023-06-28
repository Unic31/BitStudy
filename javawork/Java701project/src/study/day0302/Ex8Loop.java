package study.day0302;

public class Ex8Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 5; i++) {
			for (int sp = i; sp <= 5; sp++) {// 공백은 4 3 2 1 0
				System.out.print(' ');
			}
			for (int j = 1; j <= i; j++) { // *는 1 2 3 4 5
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("=".repeat(20));

		for (int i = 1; i <= 5; i++) {
			for (int sp = i; sp <= 5; sp++) {// 공백은 4 3 2 1 0
				System.out.print(' ');
			}
			for (int j = 0; j < i * 2 - 1; j++) {// 출력이 1 3 5 7 9
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
