package study.day0228;

public class Ex14Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score=90;
		final String MESSAGE="Happy Day";//상수는 보통 대문자
		//변수는 값 변경이 가능하다
		score=100;//변경해도 에러 안남
		//final 상수는 값 변경이 불가능함
		//MESSAGE="Nice"; //final 상수는 수정시 오류 발생
		
		System.out.println(score+"."+MESSAGE);
	}

}
