package study.day0307;

class Car{
	String color;
	int speed;
	int gear;
	
	@Override //toString()은 값 확인용.
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + "]";
	}
	
	void changeGear(int g) {
		gear=g;
	}
	void speedUp() {
		speed=speed+10;
	}
	void speedDown() {
		speed=speed-10;
	}
	
}

public class BookCarTest {

	public static void main(String[] args) {
		
		Car myCar = new Car();
		myCar.changeGear(1);
		myCar.speedUp();
		System.out.println(myCar);

	}

}
