package study.day0302;

public class Ex11Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++) {
				if(j==3)
					continue;//j가 3일때 아래꺼 다 패스(실행안됨, syso건너뛰고 ++되서 4가된다)
				System.out.printf("i=%d,j=%d\n",i,j);
			}
		}
		System.out.println("=".repeat(20));
		
		Loop1://레이블
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++) {
				if(j==3)
					continue Loop1;//j가 3일때 바깥쪽 i++로 이동한다(이후인 j가 3일때, 4일때 출력안됨)
				System.out.printf("i=%d,j=%d\n",i,j);
				
			}
		}
		System.out.println("=".repeat(20));
		
		Loop2://레이블
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++) {
				System.out.printf("i=%d,j=%d\n",i,j);
				if(j==2)
					break Loop2;//다중for문을 빠져나온다
			}
		}
		System.out.println("=".repeat(20));
		
		
		
		
		
		
		
		
		
		
		
	}

}
