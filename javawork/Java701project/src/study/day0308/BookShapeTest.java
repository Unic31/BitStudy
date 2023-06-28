package study.day0308;

class Shape{
	protected int x, y;
	public void draw() {
		System.out.println("Shape Draw");
	}
}

class Rectangle extends Shape{
	private int width, height;
	public void draw() {
		System.out.println("Rectangle Draw");
	}
}

class Triangle extends Shape{
	private int base, height;
	public void draw() {
		System.out.println("Triangle Draw");
	}
}

class Circle extends Shape{
	private int radius;
	public void draw() {
		System.out.println("Circle Draw");
	}
}

public class BookShapeTest {

	public static void main(String[] args) {
//		Shape s1;
//		
//		s1=new Shape();
//		Shape s2 = new Rectangle(); //부모클래스로 자식클래스 객체 참조 가능
//									//이것을 업캐스팅(upcasting,상형형변환)이라고 한다
		Shape s = new Rectangle();
		Rectangle r = new Rectangle();
		s.x=0;
		s.y=0;
//		s.width=100;//직접 상속받은게 아니라면 super를 통해서는 sub클래스의 필드와 메소드에 접근할수 없다
//		s.height=100;
		s.draw();//상속받은draw는 가능한것.
		
		System.out.println();
		
		Shape[] arrayOfShapes = new Shape[3]; //Shape의 배열선언
		
		arrayOfShapes[0]=new Rectangle();//배열arrayOfShapes에 객체를 만들어 대
		arrayOfShapes[1]=new Triangle();//다형성에 의하여 Shape객체 배열에 모든 타입의 객체 저장가능.
		arrayOfShapes[2]=new Circle();//부모배열에 상속받은애들을 넣을수 있다는거인듯
		
		for(int i=0;i<arrayOfShapes.length;i++) {
			arrayOfShapes[i].draw();
		}
	}

}
