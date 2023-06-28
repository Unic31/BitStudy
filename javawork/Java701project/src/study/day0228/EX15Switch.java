package study.day0228;

import java.util.Scanner;

public class EX15Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String color, result;

		while (true) {// 조건이 true이므로 계속 반복. while 안에서 break 만나야 빠져나온다
			// 영문으로 색상을 입력하면 한글로 색상을 출력
			// end입력시 while 문을 빠져 나가게
			// switch는 jdk8부터 문자열도 가능(이전에는 불가능했다)
			System.out.println("영문 칼라명 입력");
			color = sc.nextLine();

			// 대소문자 상관 없이 end 입력시 while 문을 빠져나간다
			if (color.equalsIgnoreCase("end"))
				break;

//			switch (color) {
//			case "red":
//			case "RED":
//				result = "빨강색";
//				break;
//			case "blue":
//			case "BLUE":
//				result = "파랑색";
//				break;
//			case "pink":
//			case "PINK":
//				result = "분홍색";
//				break;
//			default:
//				result="그 이외의 색";
//			}
			
			//무조건 모두 소문자로 변경 후 case에 비교
			switch (color.toLowerCase()) {
			case "red":
				result = "빨강색";
				break;
			case "blue":
				result = "파랑색";
				break;
			case "pink":
				result = "분홍색";
				break;
			default:
				result = "그 이외의 색";
			}
			System.out.println(color + "=>" + result);

		}
		System.out.println("***End***");
	}

}
