package study.day0313;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {
	MyPhoto my = new MyPhoto();
	JComboBox<String> combo1;
	JComboBox<String> combo2;
	Image image;
	String imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\2.jpg";
	int num1 = 0;
	int num2 = 0;

	public Test(String title) {
		// TODO Auto-generated constructor stub
		super(title);

		// 단순히 윈도우만 종료하고 싶을때는 메소드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 컴포넌트 생성 및 이벤트 설정하기 위한 메소드
		this.initDesign();// 이름 맘대로, 비저블보단 위

		this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 300, 300);
		this.setVisible(true);// 얘를 제일 마지막에 해줘야 생성됨(생성전에 세팅하고 생성하는느낌)
	}

	private void initDesign() { // 같은 클래스 내에서라 프라이빗이라도 상관 없긴 함
		// TODO Auto-generated method stub
		image = new ImageIcon(imageName).getImage();

		this.add("Center", my);

		String[] data1 = { "원", "사각형", "사진", "텍스트" };
		String[] data2 = { "파랑", "빨강", "흰색", "검정" };
		combo1 = new JComboBox<>(data1);
		combo2 = new JComboBox<>(data2);

		JPanel p = new JPanel();// p 라는 패널을 만들고
		p.add(combo1);// 콤보를 패널에 넣고
		p.add(combo2);
		this.add("North", p);// 패널의 위치를 정한다

		combo1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				switch (combo1.getSelectedIndex()) {
				case 0:
					num1 = 0;
					break;
				case 1:
					num1 = 1;
					break;
				case 2:
//					imageName = "C:\\bit701naver\\webwork\\image\\moviestar\\2.jpg";
					num1 = 2;
					break;
				default:
					num1 = 3;
					break;
				}
				image = new ImageIcon(imageName).getImage();
				my.repaint();
			}
		});

		combo2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				switch (combo2.getSelectedIndex()) {
				case 0:
					num2 = 0;
					break;
				case 1:
					num2 = 1;
					break;
				case 2:
					num2 = 2;
					break;
				default:
					num2 = 3;
					break;
				}
				image = new ImageIcon(imageName).getImage();
				my.repaint();
			}
		});

	}

	class MyPhoto extends Canvas {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			if (num2 == 0) {
				g.setColor(Color.blue);
			} else if (num2 == 1) {
				g.setColor(Color.red);
			} else if (num2 == 2) {
				g.setColor(Color.white);
			} else {
				g.setColor(Color.black);
			}

			if (num1 == 0) {

				g.fillOval(30, 30, 100, 100);
			} else if (num1 == 1) {

				g.fillRect(30, 30, 100, 100);
			} else if (num1 == 2) {
				g.drawImage(image, 0, 0, 300, 320, this);
			} else {
				g.setFont(new Font("Impact", Font.ITALIC | Font.BOLD, 35));
				g.drawString("TEXT", 150, 150);
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test("Test");
	}

}
