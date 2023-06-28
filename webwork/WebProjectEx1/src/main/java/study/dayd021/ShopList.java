package study.dayd021;

import java.util.ArrayList;
import java.util.List;

public class ShopList {
	private List<ShopDto> list = new ArrayList<>();

	public ShopList() {
		// TODO Auto-generated constructor stub
		
		list.add(new ShopDto("1번상품", 1000, "black", "1"));
		list.add(new ShopDto("2번상품", 2000, "white", "2"));
		list.add(new ShopDto("3번상품", 3000, "green", "3"));
		list.add(new ShopDto("4번상품", 4000, "orange", "4"));
		list.add(new ShopDto("5번상품", 5000, "gray", "5"));
	}

	public List<ShopDto> getSangpumList() {
		return list;

	}

}
