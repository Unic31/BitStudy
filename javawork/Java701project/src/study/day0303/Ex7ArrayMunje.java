package study.day0303;

import java.util.Scanner;

public class Ex7ArrayMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] data = { 12, 5, 8, 11, 9, 15, 3, 17, 1, 10 };

		// 숫자 입력 후 그 숫자가 배열 몇번째에 있는지 출력 하기
		// 없을경우 x는 배열에 없습니다 라고 출력

		// 방법1:int 타입에 배열번지에 없는 값을 초기값으로 지정 후
		// 찾을경우 그 배열 번지값을 대입한다
		// 반복문을 빠져 나온 후 -1이면 '없다' 는 메세지, 아닐경우 출력

//		int n=-1;
//		int su;
//		System.out.println("검색할 숫자 입력");
//		su=sc.nextInt();
//		for(int i=0;i<data.length;i++) {
//			if(su==data[i]) {                 //문자열은 객체라 동등연산자 안됨
//				n=i;
//			}
//		}
//		if(n==-1) {
//			System.out.println(su+"는 배열에 없다");
//		}else {
//			System.out.println(su+"는 "+(n+1)+"번째에 있다");
//		}

		// 방법2:같은 값을 찾으면 출력 후 n=true로 변경
		// 반복문을 빠져 나왔을대 같은값이 없었다면 n은 여전히 false
		boolean n = false;
		System.out.println("검색할 숫자 입력");
		int su = sc.nextInt();
		for(int i=0;i<data.length;i++) {
			if(su==data[i]) {
				n=true;
				System.out.println("입력한 "+su+"는 "+(i+1)+"번째에 있습니다");
				break;
			}
		}
		if(n==false) {
			System.out.println(su+"는 배열에 없습니다");
			
		}

	}

}
