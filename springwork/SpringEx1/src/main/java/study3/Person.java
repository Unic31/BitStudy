package study3;

public class Person {
	MyShop myShop;
	String name;
	String address;
	
	public Person(String name, String address) {
		this.name=name;
		this.address=address;
	}
	public void setMyShop(MyShop myShop) {
		this.myShop=myShop;
	}
	public void write() {
		System.out.println("**��ǰ��������**");
		myShop.showShop();
		
		System.out.println("�̸�:"+name);
		System.out.println("�ּ�:"+address);
	}
}
