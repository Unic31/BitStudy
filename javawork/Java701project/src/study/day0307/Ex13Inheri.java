package study.day0307;

//부모클래스 (super class)
class SuperObj
{
	String msg;//멤버변수
	
	SuperObj()
	{	
		System.out.println("super 클래스의 생성자");
	}
	SuperObj(String msg)
	{
		this.msg=msg;
	}
}

//자식 클래스(sub class):자바는 단일상속만 지원
class SubObj extends SuperObj
{
	String msg2;
	
	SubObj()
	{
		super();//디폴트인경우엔 생략가능. 써도 호출 안써도 호출되며 무조건 첫줄에 있어야만 한다.
		System.out.println("sub 클래스의 생성자");
	}
	
	SubObj(String msg,String msg2)
	{
		super(msg); //인자가 같은 타입인 super클래스의 생성자가 호출된다. 디폴트가 아니라 생략안됨
//		SuperObj(String msg)
//		{
//			this.msg=msg;
//		} <---부모클래스의 이게 호출됨
		this.msg2=msg2;
	}
	
	public void writeData()
	{
		System.out.println(msg);
		System.out.println(msg2);
		
	}
}


public class Ex13Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj sub=new SubObj();
		
		SubObj sub2=new SubObj("아버지","저예요");//아버지는 슈퍼클래스의 msg로 가고 저예요는 서브클래스의 msg2로 들어간다
		sub2.writeData();
	}

}
