package study.day0306;

import java.util.Scanner;


class Employee {
	static final String EMPNAME = "삼성전자";
	private String name;
	private String addr;
	private int gibon;
	private int sudang;
//	private int num;

	// set
	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setGibon(int gibon) {
		this.gibon = gibon;
	}

	public void setSudang(int sudang) {
		this.sudang = sudang;
	}
//	public void setNum(int num) {
//		this.num=num;
//	}

	// get
	public String name() {
		return this.name;
	}

	public String addr() {
		return this.addr;
	}

	public int gibon() {
		return this.gibon;
	}

	public int sudang() {
		return this.sudang;
	}
//	public int num() {
//		return this.num;
//	}

	public int getTax() {
		return (int)(gibon * 0.03);
	}

	public int getNetPay() {
		return (gibon + sudang) - getTax();
	}

	public void writeSawon() {
//		System.out.println((num+1)+"\t"+name + "\t" + addr + "\t" + gibon + "\t" + sudang + "\t" + getTax() + "\t" + getNetPay());
		System.out.println(name + "\t" + addr + "\t" + gibon + "\t" + sudang + "\t" + getTax() + "\t" + getNetPay());
	}

}

public class Ex8Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt;
//		Employee[] emp;
		// 사원 입력
		System.out.println("사원수를 입력하세요");
		cnt = Integer.parseInt(sc.nextLine());

		System.out.println();
		// 갯수만큼 할당
		Employee[] emp = new Employee[cnt];

		// 갯수만큼 데이터 넣기
		for (int i = 0; i < emp.length; i++) {
			// 각 배열의 객체 생성
			emp[i] = new Employee();

			System.out.println("사원명");
			String name = sc.nextLine();
			emp[i].setName(name); //js에서 setAttribute랑 비슷한듯. emp[i]번지에 name값을 부여

			System.out.println("주소");
			String addr = sc.nextLine();
			emp[i].setAddr(addr);

			System.out.println("기본급");
			int gibon = Integer.parseInt(sc.nextLine());
			emp[i].setGibon(gibon);

			System.out.println("수당");
			int sudang = Integer.parseInt(sc.nextLine());//int대신(인티저라는 클래스 안에 파스인트라는 메소드)
			emp[i].setSudang(sudang);
			
//			emp[i].setNum(i+1);

			System.out.println();

		}
		System.out.println("\"" + Employee.EMPNAME + "\"직원현황");
		System.out.println("번호\t사원명\t주소\t기본급\t수당\t세금\t실수령액");
		System.out.println("=".repeat(40));

//		for(Employee a:emp) {
//			a.writeSawon();
//		}
		for(int i=0;i<cnt;i++) {
			System.out.print((i+1)+"\t");
			emp[i].writeSawon();
		}

	}


}
