package study.day0303;

public class Ex2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names=new String[5]; //null로 초기화값	//객체는new로 할당??
		int []scores=new int[5];	//0으로 초기화 값
		
		// char = 'n', String = "n";, int = n;
		
		//데이터 넣기
		names[0]="한가인";
		scores[0]=98;
		
		names[1]="이승기";
		scores[1]=78;
		
		names[2]="강호동";
		scores[2]=86;
		
		names[3]="유재석";
		scores[3]=69;
		
		names[4]="한가인";
		scores[4]=98;
		
		for(int i=0;i<names.length;i++) {
			System.out.println(names[i]+"\t"+scores[i]);
		}
		
			
		
		
		
		
		
		
	}

}
