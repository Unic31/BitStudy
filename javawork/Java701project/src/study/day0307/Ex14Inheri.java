package study.day0307;

class Animal
{
	private String animalName;//private는 상속안됨.
	
	Animal(String animalName)
	{
		this.animalName=animalName;
	}
	
	public void writeData()
	{
		System.out.println("animalName="+animalName);
	}
}

class Dog extends Animal
{
	private String animalColor;
	
	Dog(String animalName, String animalColor)
	{
		super(animalName);//반드시 첫줄. 부모에게 animalName전달
		this.animalColor=animalColor;
	}
	/*
	 * 부모가 가진 메서드와 동일한 메서드명과 인자를 가진 메서드 구현
	 * 미완성의 메서드를 완성할 목적으로 오버라이드 라고 한다
	 * @Override : @를 어노테이션 이라고 한다. 오버라이드 규칙에 어긋나지 않도록 해준다(어긋날경우 오류발생)
	 */
	@Override//@ : 어노테이션(부모껄 오버라이드 했다는 증명. 오류없이 하면 저게 붙음)
	public void writeData() {
		// TODO Auto-generated method stub
		super.writeData();//부모가 먼저 처리할경우 첫줄, 어디에 넣든 상관없음
		System.out.println("animalColor="+animalColor);
	}
}
public class Ex14Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d1=new Dog("리트리버","갈색");
		d1.writeData();//writeData가 Dog 에 있으면 Dog꺼 먼저 가져오고 없으면 부모꺼 가져온다
		
		//Dog d2=new Dog("스피츠","흰색");
		
		//super 클래스로 선언한 경우 오버라이드 메소드와 부모가 가진 메소드만 호출 가능하다
		//즉 sub 가진 메소드는 호출할수 없다.
		Animal d2=new Dog("스피츠","흰색");//앞은 부모 뒤는 서브
		d2.writeData();

	}

}
