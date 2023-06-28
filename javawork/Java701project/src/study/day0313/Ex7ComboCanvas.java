package study.day0313;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex7ComboCanvas extends JFrame {

	MyPhoto my = new MyPhoto();
	Image image;
	String imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\19.jpg";
	JComboBox<String> combo;

	public Ex7ComboCanvas(String title) {
		// TODO Auto-generated constructor stub
		super(title);

		// 단순히 윈도우만 종료하고 싶을때는 메소드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 컴포넌트 생성 및 이벤트 설정하기 위한 메소드
		this.initDesign();// 이름 맘대로, 비저블보단 위

		this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 300, 400);
		this.setVisible(true);// 얘를 제일 마지막에 해줘야 생성됨(생성전에 세팅하고 생성하는느낌)
	}

	private void initDesign() { // 같은 클래스 내에서라 프라이빗이라도 상관 없긴 함
		// TODO Auto-generated method stub
		// image 생성
		image = new ImageIcon(imageName).getImage();

		this.add("Center", my);// canvas

		String[] data = { "수지", "신세경", "박보영", "강동원", "신민아", "유아인" };
		combo = new JComboBox<>(data);

		JPanel p = new JPanel();// p 라는 패널을 만들고
		p.add(combo);// 콤보를 패널에 넣고
		this.add("North", p);// 패널의 위치를 정한다

		// combo이벤트
		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(combo.getSelectedIndex());
//				System.out.println(combo.getSelectedItem());

				switch (combo.getSelectedIndex()) {
				case 0:
					imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\19.jpg";
					break;
				case 1:
					imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\18.jpg";
					break;
				case 2:
					imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\12.jpg";
					break;
				case 3:
					imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\9.jpg";
					break;
				case 4:
					imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\17.jpg";
					break;
				default:
					imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\20.jpg";
					break;
				}

				// image얻기
				image = new ImageIcon(imageName).getImage();// imageName를 불러와서 아이콘 화 시킨다
				// paint호출
				my.repaint();

			}
		});
		;
	}

	class MyPhoto extends Canvas {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);

			// 이미지 그리기
			g.drawImage(image, 0, 0, 300, 320, this);
			
			// 문자열 출력
			g.setFont(new Font("Impact", Font.ITALIC|Font.BOLD,35));
			g.setColor(Color.magenta);
			g.drawString("BitCamp 701 Class", 5, 200);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex7ComboCanvas("이미지 선택");
	}

}
