package study.day0228;

public class Ex17Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Math 클래스는 수학 메소드들을 가지고 있는 수학 클래스
		//상수는 Math.PI => 3.141592...
		//Math 클래스의 모든 메소드는 static 메소드이다
		//static메소드는 클래스 생성 없이 클래스 명으로 호출 한다(예:Math.random())
		
		System.out.println(Math.PI);
		System.out.println("3과 5중 더 큰 값은? "+Math.max(3,5));//수비교
		System.out.println("3과 5중 더 작은 값은? "+Math.min(3,5));
		System.out.println("3의 4승은 "+Math.pow(3, 4));//지수승
		System.out.println("0~사이의 난수 구하기 : "+Math.random());
		
		double su=3.7;
				
		System.out.println("무조건 올림 출력 : "+Math.ceil(su));//3.1이나  3.9나 무조건 4.0
		System.out.println("무조건 올림 출력 : "+Math.floor(su));//3.1이나  3.9나 무조건 3.0
		System.out.println("반올림 : "+Math.round(su));//반올림
		
		//반지름이 20cm인 피자 두개와 반지름이 30cm인 피자 1개 중 어떤개 면적이 더 클까
		System.out.println("반지름이 20cm인 피자 2개의 전체 면적");
		System.out.println(20*20*Math.PI*2);//2513.27
		
		System.out.println("반지름이 30cm인 피자 1개의 전체 면적");
		System.out.println(30*30*Math.PI);//2827.43
				
		
		
		
	}
	

}
