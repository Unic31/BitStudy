package study.day0303;

import java.util.Scanner;

public class Ex8ArrayMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] members = { "이효리", "강호동", "손미나", "손미나", "손흥민", "강호순", "이진", "박재범", "이효순", "박재순", "손예진", "김순자", "김말자",
				"이진상", "박진상", "손진상", "마이클", "제니퍼", "제니슨", "마이콜", "이순자" };

		/*
		 * 검색할 이름을 입력 후 몇번째에 있는지 출력 없을경우 없다는 메세지 출력
		 */
		System.out.println("검색할 이름을 입력");
		String name = sc.next();
		boolean n = false;

		for (int i = 0; i < members.length; i++) {
//			if (name.equals(members[i])) 
			if(name.compareTo(members[i])==0)//0이면 같다는뜻
			{
				n = true;
				System.out.println(name + "님은 " + (i + 1) + "번째에 있어요!");
				break;
			}
		}

		if (!n) {
			System.out.println(name + "님은 명단에 없어요!");
		}
	}
}
