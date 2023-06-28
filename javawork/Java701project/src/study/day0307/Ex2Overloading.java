package study.day0307;
/*
 * method overloading : 중복 함수
 * 
 * 같은 클래스 내의 메소드중 메소드 명은 같고 인자가 다른 경우를 오버로딩 메소드 라고 한다
 * 	리턴 타입은 달라도 된다
 */

class Apple{
	public static int getLength(int n)
	{
		//sting타입으로 변환
		String s=String.valueOf(n);
		//길이를 리턴
		return s.length();
	}
	public static int getLength(double n)
	{
		//sting타입으로 변환
		String s=String.valueOf(n);
		//길이를 리턴
		return s.length();
	}
	public static int getLength(float n)
	{
		//sting타입으로 변환
		String s=String.valueOf(n);
		//길이를 리턴
		return s.length();
	}
	public static int getLength(String n)
	{
		//길이를 리턴
		return n.length();
	}
}

public class Ex2Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1=123000;
		float n2=2.345f;
		double n3=34.5678;
		String n4="Yes or No";
		
		System.out.println("각 데이터의 길이 구하기");
		System.out.println(n1+"의 길이는 "+Apple.getLength(n1));
		System.out.println(n2+"의 길이는 "+Apple.getLength(n2));
		System.out.println(n3+"의 길이는 "+Apple.getLength(n3));
		System.out.println(n4+"의 길이는 "+Apple.getLength(n4)); //클래스.메소드(클래스에 있는 메소드 사용 인듯)
	}

}
