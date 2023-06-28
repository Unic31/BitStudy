package study.day0308;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

class MyHome extends JFrame implements WindowListener {

	// WindowListner 라는 인터페이스가 가친 추상 메소드들 무조건 모두 오버라이드 해야한다
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("윈도우를 종료합니다");
		System.exit(0);// 0:정상종료시
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public MyHome(String title) {
		// TODO Auto-generated constructor stub
		super(title);// 부모(JFrame)에서 가져오는거기 때문에 부모안에 타입이랑 변수 넣어줘야되는거같음
		this.setBounds(900, 100, 300, 300);// x y w h
		// 프레임 색 변경
//		this.getContentPane().setBackground(Color.green);// Color의 static상수들을 이용해서 색상 변경
		//rgb색상으로 프레임색 변경
		this.getContentPane().setBackground(new Color(234, 123, 190));
		// 윈도우 이벤트를 발생하려면
		this/* (frame) */.addWindowListener(this);

		this.setVisible(true);// 프레임 보이게 하기
	}

}

public class Ex9Window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHome my = new MyHome("개신기해");// 생성자 호출
	}

}
