package study.day0310;

import java.util.ArrayList;
import java.util.List;

public class Ex7ListShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ShopDTO> list = new ArrayList<>();
		// list에 5개의 상품을 추가
		list.add(new ShopDTO("사과", 3, 2300));
		list.add(new ShopDTO("오렌지", 6, 3500));
		list.add(new ShopDTO("포도", 1, 6600));
		list.add(new ShopDTO("딸기", 5, 8800));
		list.add(new ShopDTO("망고", 2, 12000));

		System.out.println("총" + list.size() + "개의 상품이 있습니다");

		System.out.println("번호\t상품\t수량\t단가\t총금액");
		int n = 1;
		for (ShopDTO dto : list) {
			System.out.println(n++ + "\t" + dto.getSangpum() + "\t" + dto.getSu() + "\t" + dto.getDan() + "\t"
					+ dto.getSu() * dto.getDan());
		}
		System.out.println();
		// 다른방법
		for (int i = 0; i < list.size(); i++) {
			ShopDTO dto = list.get(i);
			System.out.println(i + 1 + "\t" + dto.getSangpum() + "\t" + dto.getSu() + "\t" + dto.getDan() + "\t"
					+ dto.getSu() * dto.getDan());

		}
		System.out.println("1번 인덱스 데이터 제거후 다시 출력");
		list.remove(1);
		for (int i = 0; i < list.size(); i++) {
			ShopDTO dto = list.get(i);
			System.out.println(i + 1 + "\t" + dto.getSangpum() + "\t" + dto.getSu() + "\t" + dto.getDan() + "\t"
					+ dto.getSu() * dto.getDan());

		}
		
		System.out.println("전체 제거 후 갯수 확인하기");
		list.clear();
		System.out.println(list.size());
	}

}
