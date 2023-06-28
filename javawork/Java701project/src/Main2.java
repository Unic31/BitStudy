import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = Integer.parseInt(sc.nextLine());
		String a;

		for (int i = 0; i < c; i++) {
			a = sc.nextLine();
//			System.out.println(arr);
			String[] arr2 = a.split(" ");

			int sum = 0;
			int result = 0;
			double cnt = 0;
			double r;
			for (int j = 1; j < arr2.length; j++) {
				sum += Integer.parseInt(arr2[j]);
			}
			result = sum / (arr2.length - 1);
			for (int n = 1; n < arr2.length; n++) {
				if (result < Integer.parseInt(arr2[n])) {
					cnt++; // 평균보다 높은사람
				}

			}

			r = cnt / Integer.parseInt(arr2[0]) * 100;
			System.out.printf("%.3f", r);
			System.out.print("%\n");
		}

	}

}
//5 = c
//5 arr2[i] 50 50 70 80 100 = a
//7 100 95 90 80 70 60 50
//3 70 90 80
//3 70 90 81
//9 100 99 98 97 96 95 94 93 91