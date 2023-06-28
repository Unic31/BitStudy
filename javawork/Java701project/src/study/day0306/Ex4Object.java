package study.day0306;

class Apple{
	public String mes1="Hello";//static이 안붙은것들은 인스턴스 변수. 밑에서 new로 생성 후 접근
	private String mes2="Happy";//은닉(Apple 이라는 클래스 안에서만 사용 가능)
	public static final String MES="Have a Good Day";//상수화 할때 주로 static, fianl 붙인다. 변경불가값(상수)
	
	/*커서를 이 클래스 안에두고 마우스 우클릭-소스-제네레이트 게터세터*/
	//은닉된걸 밖으로 던저줄때 게터, 세터. 있어야만 접근 가능함
	public String getMes2() {
		return mes2;//같은 구역안에 같은 이름 없어서 this생략된듯
	}
	public void setMes2(String mes2) {
		this.mes2 = mes2;//같은 구역안에 같은 이름 있으면 무조건 this붙여야 한다
	}
}
//위는 Apple클래스 아래는 Ex4Object 클래스. 다른공간
public class Ex4Object {//퍼블릭(접근지정자)이 붙는건 무조건 파일명을 가진 클래스 하나

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Apple 이 가진 멤버변수중 new로 생성하지 않아도 접근이 가능한 변수
		System.out.println(Apple.MES); //읽기만 하고 변경 안됨

		
		//인스턴스 멤버 변수는 new로 생성 후 접근이 가능하다
		Apple a=new Apple();
		System.out.println(a.mes1);
//		System.out.println(a.mes2);//패키지 상관없이 접근 불가(private)
		
		//mes2출력
		System.out.println(a.getMes2());
		//mes2의 값을 Bitcamp로 변경
		a.setMes2("Bitcamp");
		//mes2변경된 값을 다시 출력
		System.out.println(a.getMes2());
	}

}
