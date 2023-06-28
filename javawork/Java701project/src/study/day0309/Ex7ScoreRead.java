package study.day0309;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex7ScoreRead {
	static final String FILENAME = "C:\\bit701naver/score.txt";

	public static void scoreRead() {
		/*
		 * 총 n개의 점수 읽음 90 67 100....(한줄에 5개씩) 총점 : xxx 평균 : xxx.x 소수점 이하 한자리
		 */
		FileReader fr = null;
		BufferedReader br = null;
		int cnt = 0;
		int sum = 0;
		double avg = 0;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			int idx = 1;
			while (true) {
				String scores = br.readLine();
				if (scores == null || scores.length() == 0)
					break;

				try {
					sum += Integer.parseInt(scores);// 예외 발생시 나머지 코드 실행 안함

					System.out.printf("%5s", scores);

					if (idx++ % 5 == 0)
						System.out.println();
					cnt++;

				} catch (NumberFormatException e) {
//					System.out.print("X");
				}

			}
			avg = (double) sum / cnt;
			System.out.println();
			System.out.println("총 갯수:" + cnt + "개");
			System.out.println("합계:" + sum);
			System.out.printf("평균:%5.1f\n", avg);

		} catch (FileNotFoundException e) {
			System.out.println("파일없음:" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scoreRead();
	}

}
