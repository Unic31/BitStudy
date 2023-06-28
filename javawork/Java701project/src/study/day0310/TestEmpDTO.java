package study.day0310;

import java.util.Scanner;

public class TestEmpDTO {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestEmpDTO dto = new TestEmpDTO(); 
		Scanner sc=new Scanner(System.in);
		
		System.out.println("**메뉴**");
		System.out.println("1.사원추가");
		System.out.println("2.사원검색");
		System.out.println("3.사원삭제");
		System.out.println("4.부서명 검색");
		System.out.println("5.전체출력");
		System.out.println("6.종료");
		int menu;
		while(true) {
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("숫자를 다시 입력하세요");
		}finally {
			System.out.println("=".repeat(30));
		}
		}
	}
	
}
/*
 * **메뉴**
 * 1.사원추가
 * 2.사원검색 - 이름 부서 나이 핸드폰 모두 출력
 * 3.사원삭제
 * 4.부서명 검색 - 부서별로 출력
 * 5.전체출력
 * 6.종료
 */