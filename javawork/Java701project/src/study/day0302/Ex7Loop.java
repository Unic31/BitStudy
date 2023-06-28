package study.day0302;

public class Ex7Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5행5열로 *출력
		for (int i = 1; i <= 5; i++) { // 주로 행
			for (int j = 1; j <= 5; j++) {// 주로 열
				System.out.print("*");
			}
			System.out.println();// 출력 후 j빠져나오면 한줄 띄우기 하고 다시 i증가식으로
		}
		System.out.println("=".repeat(20));

		for (int i = 1; i <= 5; i++) { // 주로 행
			for (int j = 1; j <= i; j++) {// 주로 열
				System.out.print("*");
			}
			System.out.println();// 출력 후 j빠져나오면 한줄 띄우기 하고 다시 i증가식으로
		}
		System.out.println("=".repeat(20));
		for (int i = 1; i <= 5; i++) { // 주로 행
			for (int j = 5; j >= i; j--) {// 주로 열 for(int j=i;j<=5;j++)
				System.out.print("*");
			}
			System.out.println();// 출력 후 j빠져나오면 한줄 띄우기 하고 다시 i증가식으로
		}

	}

}
