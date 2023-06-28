package study.day0302;

import java.util.Scanner;

public class Ex10Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int menu,dan;
		
		while(true) {
			System.out.println("1. 구구단 입력 후 출력 2. 구구단 전체 3. 종료");
			menu=sc.nextInt();
			
			if(menu==1) {
				//조건 : 2~9사이 입력시 해당 구구단 출력
				//그 값을 벗어날경우 "잘못입력했어요" 메세지 출력 후 다시 메뉴 나오도록(continue)
				 System.out.println("2~9사이 값 입력");
				 dan = sc.nextInt();
				 if(dan<2 || dan>9) {
					 System.out.println("잘못 입력했어요");
					 continue;
					
				 }else {
					 System.out.println("** "+dan+" 단 **\n");
				 }
				for(int i = 1;i<=9;i++) {
					System.out.println(dan+"*"+i+"="+dan*i);//("%d x %2d = %2d\n", dan, i, dan*i);
				}
			}
			else if(menu==2) {
				//구구단 제목
				for(dan=2;dan<=9;dan++) {
					System.out.printf("%d 단\t",dan);
			}
				System.out.println();
				//2~9단을 가로방향으로 출력
				for(int i=1;i<=9;i++) {
					for(dan=2;dan<=9;dan++) {
						System.out.printf("%dx%d=%2d\t",dan,i,dan*i);
					}
					System.out.println();
				}
				
//			else if(menu==2) {
//				//2~9단을 가로방향으로 출력
//				for(int i = 2;i<=9;i++) { //행
//					System.out.print(i+"단 ");
//					for(int j=1;j<=9;j++) { //열
//						System.out.print(i+"x"+j+"="+j*i+" ");
//					}System.out.println();
//				}
				
			}else {
				System.out.println("***시스템 종료***");
				break;
				
			}
		}
	}

}
