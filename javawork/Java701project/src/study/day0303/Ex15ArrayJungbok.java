package study.day0303;

import java.util.Random;

public class Ex15ArrayJungbok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 10개의 데이터를 저장할 배열을 생성 후 1~30 사이의 중복없는 숫자를
		 * 배열에 넣어보자
		 */
		Random r=new Random();
		int []data=new int[10];
		
		Loop:
		for(int i=0;i<data.length;i++) {
			data[i]=r.nextInt(30)+1;
			//중복숫자가 i 이전 번지에 있을 경우 다시 구하기
			for(int j=0;j<i;j++) {
				if(data[i]==data[j]) {
					i--;// 나가면 i++로 이동하므로 여기서 1을 뺀 후 이동한다(다음 자리가 아니라 제자리로 가기 위해서)
					//break;
					continue Loop;//바로 i++로 이동
				}
			}
		}
		
		//출력
		for(int a:data) {
			System.out.printf("%4d",a);
		}
		
		
		
		
		
	}

}
