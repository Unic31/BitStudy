package study.day0313;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex5Canvas extends JFrame {
	// 내부클래스인 MyDraw생성
	MyDraw draw = new MyDraw();

	// 사각형의 초기 색상
	Color initcolorColor = new Color(239, 136, 190);// 값으로 준걸 변수로 바꿈

	public Ex5Canvas(String title) {
		// TODO Auto-generated constructor stub
		super(title);

		// 단순히 윈도우만 종료하고 싶을때는 메소드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 컴포넌트 생성 및 이벤트 설정하기 위한 메소드
		this.initDesign();// 이름 맘대로, 비저블보단 위

//		this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 500, 500);
		this.setVisible(true);// 얘를 제일 마지막에 해줘야 생성됨(생성전에 세팅하고 생성하는느낌)
	}

	// Canvas를 상속받는 내부 클래스
	class MyDraw extends Canvas {

		String imgPath1 = "C:\\bit701naver\\webwork\\image\\animal\\C1.png";
		String imgPath2 = "C:\\bit701naver\\webwork\\image\\animal\\C8.png";

		@Override
		public void paint(Graphics g) {// 처음 생성시나 프레임 변경시 자동호출, 강제호출repaint()
			// TODO Auto-generated method stub
			System.out.println("페인트 호출");
			super.paint(g);// 부모가 가진 페인트 호출

			g.setColor(Color.magenta);
			g.drawOval(30, 30, 100, 100);// 테두리, x y w h //높이 넓이를 똑같이 주면 원

			g.setColor(Color.green);
			g.fillOval(150, 30, 100, 100);// 꽉찬

			g.setColor(initcolorColor);// 값으로 준걸 변수로 바꿈
			g.fillRect(200, 180, 120, 150);// 사각형

			g.drawRect(50, 180, 100, 100);

			// 캔바스에 이미지를 그리는 두가지 방법
			Image img = new ImageIcon(imgPath1).getImage();// 이미지를 얻고 아이콘으로 변환
			g.drawImage(img, 30, 300, 100, 100, this);

			Image img2 = Toolkit.getDefaultToolkit().getImage(imgPath2);
			g.drawImage(img2, 350, 30, 100, 100, this);

		}
	}

	private void initDesign() { // 같은 클래스 내에서라 프라이빗이라도 상관 없긴 함
		// TODO Auto-generated method stub
		// center 에 draw추가
		this.add("Center", draw);

		JPanel p = new JPanel();// 패널생성. 버튼은 위치당 하나밖에 못들어 가지만 패널로 묶고 버튼을 패널에 넣는다

		JRadioButton rb1 = new JRadioButton("핑크", true);
		JRadioButton rb2 = new JRadioButton("초록");
		JRadioButton rb3 = new JRadioButton("오렌지");

		// Radio 버튼 3개를 그룹으로 묶는다
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);

		// 패널에 추가
		p.add(rb1);
		p.add(rb2);
		p.add(rb3);

		this.add("North", p);// 캔버스에 패널 추가

		// 라디오 버튼 이벤트는 익명 내부 클래스 형태로 만들어보자
		rb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 색상변경
				initcolorColor = new Color(239, 136, 190);
				// 캔버스의 paint강제호출
				draw.repaint();
			}
		});
		rb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 색상변경
				initcolorColor = new Color(22, 239, 112);
				// 캔버스의 paint강제호출
				draw.repaint();
			}
		});
		rb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 색상변경
				initcolorColor = Color.orange;
				// 캔버스의 paint강제호출
				draw.repaint();
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5Canvas("Canvas");
	}

}
