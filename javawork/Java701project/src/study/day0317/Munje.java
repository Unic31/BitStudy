package study.day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class Munje {

	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

		
	public Munje() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("마이쿼리 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("마이쿼리 드라이버 실패" + e.getMessage());
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "angel", "1234");
			System.out.println("로컬 마이쿼리 연결 성공");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("로컬 마이쿼리 연결실패" + e.getMessage());
		}

		return conn;

	}

	public void sel1() {
		Connection conn = this.getConnection();
		String sql = "select num, name, java, spring, java+spring 합계, round(((java+spring)/2),2) 평균 from bitcamp";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("Bitcamp");
			System.out.println("번호\t이름\t자바점수\t스프링점수\t합계\t평균");
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int java = rs.getInt("java");
				int spring = rs.getInt("spring");
				int total = rs.getInt("합계");
				int avg = rs.getInt("평균");

				System.out.println(num + "\t" + name + "\t" + java + "\t" + spring + "\t" + total + "\t" + avg);

			}
			System.out.println("=".repeat(30));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Munje mu = new Munje();
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 입력해 주세요");
		System.out.println("1.전체출력 2.이름검색 3.평균검색 4.종료");
		int sel = sc.nextInt();

		if (sel == 1) {
			System.out.println("1.전체출력");
			mu.sel1();
		} else if (sel == 2) {
			System.out.println("이름을 입력해 주세요");
			String 이름 = sc.next();
			mu.sel2(이름);
		} else if (sel == 3) {
//			평균점수를 입력해주세요
		}

	}

	private void sel2(String 이름) {
		// TODO Auto-generated method stub
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from bitcamp where name like '%" + 이름 + "%'";
//		System.out.println(sql);

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()==true) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int java = rs.getInt("java");
				int spring = rs.getInt("spring");
//				int total = rs.getInt("합계");
//				int avg = rs.getInt("평균");
				
				System.out.println(이름+"의 성적은");
				System.out.println("자바"+java+" 스프링"+spring+" 합계"+(java+spring)+" 평균"+(java+spring)/2+"입니다");
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 익셉션 날지안날지 모르니까 닫는건 항상 finally
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}

	}

}
