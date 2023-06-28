package study.day0302;

public class Ex5Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 65;// 'A'
		while (a <= 'Z') {
			System.out.print((char) a++);// Z가 될때까지 반복
		}

		System.out.println();

		char b = 'A';
		do {
			System.out.print(b++);
		} while (b <= 'Z');

		System.out.println();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.printf("%c", ch);
		}

		System.out.println();
		System.out.println("-".repeat(30));// -를 30개 만큼 반복

		String msg = "Happy!";
		int idx = 0;
		while (true) {
			System.out.printf("%8s", msg);// Happy!(6글자)만큼 출력하고 빈칸2개 더 출력
			idx++;
			if (idx == 5)
				break;
		}

		System.out.println();

		idx = 0;
		do {
			System.out.printf("%8s", msg);// Happy!(6글자)만큼 출력하고 빈칸2개 더 출력
			idx++;
			if (idx == 5)
				break;
		} while (true);		
		System.out.println();		
		for(idx=1;idx<=5;idx++) {
			System.out.printf("%8s",msg);// Happy!(6글자)만큼 출력하고 빈칸2개 더 출력
		}
		
		System.out.println();
		System.out.println("-".repeat(30));// -를 30개 만큼 반복
		
		//msg를 5번씩 출력 하는데 총 세번 반복
		//다중for문을 이용
		
		for(int row=1;row<=3;row++) {
			for(int col=1;col<=5;col++) { //row가 1일때 col이 1~5까지, row가 2일때 col이 3이 될때까지... 반복
				System.out.printf("%8s",msg);
			}
			System.out.println();//5개 출력할때마다 줄 띄움
		}
		
		
		
	}

}
