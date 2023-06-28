import java.util.Scanner;

public class Main3 {
	// 라운드 10번
	// 이기면3, 비기면1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		int winA = 0;
		int winB = 0;
		int a1 = 0;
		int b1 = 0;
		String result = null;

		String[] a = A.split(" ");
		String[] b = B.split(" ");
		for (int i = 0; i < a.length; i++) {
			a1 = Integer.parseInt(a[i]);
			b1 = Integer.parseInt(b[i]);
			if (a1 > b1) {
				winA += 3;
				result = "A";
			} else if (a1 < b1) {
				winB += 3;
				result = "B";
			} else {
				winA++;
				winB++;
//				if (Integer.parseInt(a[i - 1]) > Integer.parseInt(b[i - 1])) {
//					result = "A";
//				} else if (Integer.parseInt(a[i - 1]) < Integer.parseInt(b[i - 1])) {
//					result = "B";
//				} else {
//					
//				}
			}
		}
		if (winA > winB) {
			System.out.println(winA + " " + winB);
			System.out.println(result);
		} else if (winA < winB) {
			System.out.println(winA + " " + winB);
			System.out.println(result);
		} else {
			if (winA == winB) {
				System.out.println(winA + " " + winB);
				System.out.println("D");
			}
		}

	}

}
