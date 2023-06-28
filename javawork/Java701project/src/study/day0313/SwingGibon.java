package study.day0313;

import java.awt.Color;

import javax.swing.JFrame;

public class SwingGibon extends JFrame{
	
	public SwingGibon(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//단순히 윈도우만 종료하고 싶을때는 메소드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//컴포넌트 생성 및 이벤트 설정하기 위한 메소드
		this.initDesign();//이름 맘대로, 비저블보단 위
		
		this.getContentPane().setBackground(new Color(200,200,200));
		this.setBounds(900,100,300,300);
		this.setVisible(true);//얘를 제일 마지막에 해줘야 생성됨(생성전에 세팅하고 생성하는느낌)
	}
	private void initDesign() { //같은 클래스 내에서라 프라이빗이라도 상관 없긴 함
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		SwingGibon ex=new SwingGibon("기본프레임");
		
	}

}
