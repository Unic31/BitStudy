package study.day0307;

class Test
{
	String name="이지아";//private아니라서 같은 패키지 안에서는 접근 가능
	int age=23;		
}

class CallBy
{	
	//call by value:주소가 아닌 값만 전달된다(모든 기본형,String가 여기 해당)
	public void chasngeInt(int n)//메인의 n하고는 완전히 다른 변수(값만 전달받을뿐)
	{
		n+=10;
		System.out.println("changeInt n="+n);//여기서는 110이지만 아래에서 n이랑은 관련이 없다.
	}

	public void changeString(String m) { //m에는 happy라는 값이 전달됨
		// TODO Auto-generated method stub
		m="hello";//여기서 m을 hello로 바꿨지만 메인의 m이 바뀌진 않는다
		System.out.println(m);
	}
	
	//배열은 타입에 상관없이 무조건 reference 즉 주소가 전달된다
	//이런 경우를 call by reference라고 한다
	public void changeArray(int []a)
	{
		a[1]=100;//2번지 값만 변경해보자
	}

	public void changeTest(Test t) { //메인의 t변수와 주소가 같은 변수이다
		// TODO Auto-generated method stub
		t.name="이상아";
		t.age=35;
				
	}
}

public class Ex5CallBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CallBy call=new CallBy();//스태틱이 아니라서 생성
		int n=100;
		call.chasngeInt(n);//n은 값으로 전달(주소전달 아님)
		System.out.println();
		
		System.out.println("n은 바꼈을까?"+n);
		
		String m="Happy";
		call.changeString(m);
		System.out.println("m은 바꼇을까?"+m);
		
		
		int []a= {3,5,9};//배열은 타입 상관없이 객체이다
		call.changeArray(a);//배열 a의 주소가 전달, 메소드의 인자와 메인의 배열변수는 주소가 같은 변수이다.
		System.out.println("배열값은 바꼈을까?");
		for(int b:a)
			System.out.print(b+" ");//2번지 배열값이 바껴있다
		System.out.println();
		
		Test t=new Test();
		System.out.println(t.name+","+t.age);
		call.changeTest(t);//t의 주소가 전달된다 call by reference
		System.out.println(t.name+","+t.age);//변경되어 있는지 확인
	}

}
