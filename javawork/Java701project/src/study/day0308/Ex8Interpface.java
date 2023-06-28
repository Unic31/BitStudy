package study.day0308;

//class가 class를 상속받을때 extends
//interface가 interface를 상속받을때 extends
//class가 interface를 구현할땐 implements
//상속받고 구현하고 다하면 둘 다 써야함(extends 먼저 쓴 뒤 implements)

interface Kiwi
{
	public void play();
}

interface Manggo extends Kiwi
{
	public void study();//안보이지만 상속받았기 때문에 play도 있는것
}
class Banana
{
	public void eat()
	{
		System.out.println("바나나를 먹어요");
	}
}
class Berry extends Banana implements Manggo 
{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("우리 다같이 놀아요");
	}
	
	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("자바 공부를 합시다");
	}
}

public class Ex8Interpface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manggo m1 = new Berry();
		m1.play();
		m1.study();
		
		Banana m2 = new Berry();
		m2.eat();
		
		Berry m3 = new Berry();
		m3.eat();
		m3.play();
		m3.study();
		
	}

}
