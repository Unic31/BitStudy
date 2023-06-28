package study.day0307;

import study.day0306.Shop;

public class Ex8Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shop s1 = new Shop();
		s1.writeShop();
		
		Shop s2=new Shop(2000);
		s2.writeShop();
		
		Shop s3=new Shop("딸기");
		s3.writeShop();
		
		Shop s4=new Shop("복숭아",2500);
		s4.writeShop();

	}

}
