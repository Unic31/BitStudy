package study.day0227;

public class Ex1DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("자바 프로젝트 생성");
		//정수타입byte(1)-short(2)-int(4)-long(8)
		byte a=127;
		byte b=(byte) 234;//강제로 자료형보다 큰 값을 넣을 경우 값 손실이 발생한다
		System.out.println(a);//syso는 오버 로딩 메소em(여러 타입을 담을수 있다)
		System.out.println(b);//틀린값이 나온다. -2의 보수로 변환한 값이 나온다
		
		char m1='A';
		char m2='가'; //자바에서 char는 2바이트라 한글도 한글자 가능
		System.out.println(m1+","+m2);
		//ascii code : A:65, a:97
		System.out.println((int)m1);//A의 아스키코드 10진수 값이 나온다
		
		//묵시적 형변환:연산시에 자동으로 결정되는 타입(int+int=int, double+int=double
		// String+int=String, char+int=int)(연산을 했을때 더 큰 타입을 따라간다)
		System.out.println(m1+32);//'A'+32=97 : char와int의 결과는 int
		System.out.println((char)(m1+32));//a
		
		char m3=66;//내부적으로는 문자B(B=아스키코드66)로 인식
		int m4='A';//내부적으로 65(A=아스키코드65)로 인식
		System.out.println(m3+","+m4);//B, 65
		System.out.println((int)m3+","+(char)m4);//66,A
		 
	}

}
