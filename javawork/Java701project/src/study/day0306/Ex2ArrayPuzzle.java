package study.day0306;

import java.util.Scanner;

public class Ex2ArrayPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] puzzle = new int[3][3];
		int binggo;

		while (true) {
			// 3행3열 1~3의 난수를 구해서 넣는다
			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j < puzzle[i].length; j++) {
					puzzle[i][j] = (int) (Math.random() * 3) + 1;
				}
			}

			// 출력
			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j < puzzle[i].length; j++) {
					System.out.printf("%4d", puzzle[i][j]);

				}
				System.out.println();
			}

			// 행,열은 for문으로 해보자
			binggo = 0;
			for (int row = 0; row < puzzle.length; row++) {
				if (puzzle[row][0] == puzzle[row][1] && puzzle[row][1] == puzzle[row][2])
					binggo++;
			}

			for (int col = 0; col < puzzle.length; col++) {
				if (puzzle[0][col] == puzzle[1][col] && puzzle[1][col] == puzzle[2][col])
					binggo++;
			}

			// 대각선
			if (puzzle[0][0] == puzzle[1][1] && puzzle[1][1] == puzzle[2][2])
				binggo++;

			if (puzzle[0][2] == puzzle[1][1] && puzzle[1][1] == puzzle[2][0])
				binggo++;

			if (binggo == 0)
				System.out.println("꽝");
			else
				System.out.println("빙고 " + binggo + "개");
			System.out.println("=".repeat(20));
			String ch = sc.nextLine(); // 문자열로 읽어서
			if (ch.equals("q")) { // 그 값이 q면
				System.out.println("게임 종료");
				break;
			}
		}

	}

}
