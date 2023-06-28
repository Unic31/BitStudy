package study.day0303;

public class Ex6ArrayMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {100,78,67,190,-100,89,350,-290,78,200};
		int max=data[0]; //첫 데이터를 맥스값으로 '일단' 준다
		int min=data[0];
		
		for(int i=1;i<data.length;i++) {
			if(max<data[i]) {//만약 첫데이터값(일단 맥스로 준 값)이 다음 배열보다 작다면
				max=data[i];//그 값을 다시 맥스값으로 '일단'주고 다시 다음배열값이랑 비교 반복
			}
			
			if(min>data[i]) {
				min=data[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
		
		
		
		
		
		
		
		
		
	}

}
