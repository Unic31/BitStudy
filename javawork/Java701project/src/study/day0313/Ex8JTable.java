package study.day0313;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex8JTable extends JFrame {

	JTable table1, table2, table3;

	public Ex8JTable(String title) {
		// TODO Auto-generated constructor stub
		super(title);

		// 단순히 윈도우만 종료하고 싶을때는 메소드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 컴포넌트 생성 및 이벤트 설정하기 위한 메소드
		this.initDesign();// 이름 맘대로, 비저블보단 위

		this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 300, 500);
		this.setVisible(true);// 얘를 제일 마지막에 해줘야 생성됨(생성전에 세팅하고 생성하는느낌)
	}

	private void initDesign() { // 같은 클래스 내에서라 프라이빗이라도 상관 없긴 함
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(3,1));
		
		//table1생성
		String []title1= {"이름","주소","나이"};
		String [][]data1= {{"이지영","서울","23세"},{"홍길동","대구","35세"},{"강철수","부산","29세"}};
		table1=new JTable(data1, title1);
		this.add(table1);//그냥 넣는것-title가 안나옴
		
		table2=new JTable(data1,title1);
		this.add(new JScrollPane(table2));//스크롤팬에 담아 넣는것
		
		//model을 이용하면 나중에라도 데이터 추가나 삭제가 가능하다
		DefaultTableModel model=new DefaultTableModel(data1,title1);//인터페이스 모델 불러와서
		table3=new JTable(data1,title1);
		this.add(new JScrollPane(table3));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex8JTable("table");
	}

}
