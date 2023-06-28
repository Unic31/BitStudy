package study.day0308;

import java.util.List;
import java.util.Vector;

class Super1
{
	public void process()
	{
		System.out.println("나는 아무 일을 안한다");
	}
	
	public void superProcess()
	{
		System.out.println("super 만 가지고 있는 메소드");
	}
}

class Sub1 extends Super1
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터를 파일에 저장합니다");
	}
	
	public void sub1Process()
	{
		System.out.println("sub1만 할수있는 일");
	}
}


public class Ex3Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//슈퍼로 선언하고 서브로 생성시
		//오버라이드 메소드와 super가 가진 메소드는 호출 가능하다
		//단 sub만이 가진 메소드는 호출 불가
		Super1 s1 = new Sub1();
		s1.process();//오버라이드 메소드
		s1.superProcess();//부모가 가진 메소드
		
		//s1.sub1Process();//오류
		((Sub1)s1).sub1Process();//s1을 Sub1으로 다운형변환을 하고 호출하는 방법은 가능하다
		
		//collection 의 List 경우를 보자
		List<String> list=new Vector<>();
		list.add("사과");//add는 오버라이드 메소드이므로 호출 가능
		
		int n=((Vector<String>)list).capacity();
		System.out.println("할당크기:"+n);
		
	}

}
