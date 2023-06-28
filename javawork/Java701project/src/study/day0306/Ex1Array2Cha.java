package study.day0306;

import java.util.Scanner;

public class Ex1Array2Cha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 이름 저장할 배열
		String[] names=new String[3];
		//3과목의 점수와 총점을 구할 2차원 배열 선언
		int [][]scores=new int[3][5];//3행 5열 (3과목점수,총점,등수)
		
		//입력
		for(int i=0;i<names.length;i++) {
			System.out.println(i+1+"번의 이름은?");
			names[i]=sc.nextLine();
			
			System.out.println("3과목의 점수를 입력해 주세요");
			for(int j=0;j<3;j++) {
				scores[i][j]=sc.nextInt();
			}
			//int다음에 String할때 엔터시
			//마지막 점수 입력 후 버퍼에 저장된 엔터를 따로 읽어서 처리한다
			sc.nextLine();
		}
		//총점 구하기
		for(int i=0;i<scores.length;i++) {
			for(int j=0;j<3;j++) {
				scores[i][3]+=scores[i][j];
				
			}
		}
		//등수 구하기//등수 초기값은 = 1(나보다 잘하는 사람이 없으면 1등)
		for(int i=0;i<scores.length;i++) {
			//등수열은 1로 초기값 지정
			scores[i][4]=1;
			for(int j=0;j<scores.length;j++) {
				if(scores[i][3]<scores[j][3]);//상대방(j)의 총점이 기준(i)보다 더 높을경우 i번지의 등수를 1증가
				{
					scores[i][4]++;
				}
			}
			
		}
		
		
		
		//출력
		System.out.println("이름\t국어\t영어\t수학\t총점\t등수");
		System.out.println("=".repeat(30));
		for(int i=0;i<names.length;i++) 
		{
			System.out.printf("%-10s",names[i]);//10칸 중 왼쪽으로 출력(오른쪽에 공백)
			
			for(int j=0;j<scores[i].length;j++) 
			{
				System.out.printf("%5d",scores[i][j]);
			}
			System.out.println();
		}
	}

}
