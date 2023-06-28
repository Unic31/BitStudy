package study.day0306;

public class Shop {

	private String sangpum; // 객체라 초기값 안주면 null
	private int price; // 0

	// 다른 패키지에서 생성자 호출이 가능하게 하려면
	// 앞에 접근지정자 public 있어야 한다
	public Shop() {
		// System.out.println("디폴트 생성자 호출");
		// 멤버 변수 초기값 지정
		sangpum = "사과";
		price = 1000;
	}

	public Shop(String sangpum) {
		this.sangpum = sangpum;// 초기값 준거
	}

	public Shop(int price) {
		this.price = price;
	}

	public Shop(String sangpum, int price) {
		this.sangpum = sangpum;
		this.price = price;
	}

	// 멤버변수 출력하기 위한 메서드
	public void writeShop() {
		System.out.println("상품명:" + sangpum + ",가격:" + price);
	}

}

//day0307 Ex8 연습용 클래스