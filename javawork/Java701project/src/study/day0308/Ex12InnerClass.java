package study.day0308;

//Anonymous 내부 클래스

interface InterTest {
	public void insert();

	public void deledt();
}

abstract class AbstTest
{
	abstract public void process();
}

public class Ex12InnerClass {
	
	//익명 내부 클래스 형태로 구현한경우
	InterTest it=new InterTest() {//클래스란 단어가 없지만 클래스임.멤버변수 it가 아래 기능들을 갖게되는것.
		
		@Override
		public void insert() {
			// TODO Auto-generated method stub
			System.out.println("데이터를 추가한다");
		}
		
		@Override
		public void deledt() {
			// TODO Auto-generated method stub
			System.out.println("데이터를 삭제한다");
		}
	};

	AbstTest ab=new AbstTest() {
		
		@Override
		public void process() {
			// TODO Auto-generated method stub
			System.out.println("process");
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex12InnerClass ex=new Ex12InnerClass();
		ex.it.insert();
		ex.it.deledt();
		ex.ab.process();
		
	}

}
