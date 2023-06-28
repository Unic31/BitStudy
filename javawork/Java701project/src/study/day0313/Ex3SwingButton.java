package study.day0313;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex3SwingButton extends JFrame {
	JButton btn1=new JButton("버튼1");//선언과 생성(호출시 바로 사용)
	JButton btn2;//선언(아래에서 생성
	JLabel lblMessage;
	
	public Ex3SwingButton(String title) {
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

		//버튼,체크박스 등등을 컴포턴트라 부른다
		//버튼을 추가할 프레임이나 다이얼로그 등을 컨테이너라 부른다
		
		//컴포넌트를 컨테이너에 추가하는 메소드 add를 통해서 부착한다
		//기본 레이아웃이 설정:BorderLayout-상 하 좌 우 센터
		
//		this.add("North",btn1);
		this.add(btn1,BorderLayout.NORTH);
		
		btn2=new JButton("버튼2");//생성
//		this.add("South",btn2);
		this.add(btn2,BorderLayout.SOUTH);
		
		//센터에 라벨을 생성해서 넣기
		lblMessage=new JLabel("Hava a Nice Day!!", JLabel.CENTER);//라벨을 수평으로 센터
		lblMessage.setOpaque(true);//불투명모드, 기본은false(투명해서 뒤에 프레임색으로 나옴)
		lblMessage.setBackground(Color.green);//라벨 배경색 변경
		lblMessage.setForeground(Color.red);//라벨 글자색 변경
		lblMessage.setFont(new Font("Comic Sans MS", Font.BOLD, 30));//메소드 썻는데 안에서 클래스 요구하면 바로 생성하면 됨
		this.add("Center",lblMessage);//프레임에서 센터
		
		//익명 내부클래스 형태로 버튼 이벤트 추가, 
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setText("Button One Click");
				lblMessage.setForeground(new Color(50,200,130));
				lblMessage.setBackground(Color.yellow);
			}
		});
		btn2.addActionListener(new ActionListener() {//addActionListener은 ActionListener타입으로 가져와야 하기 때문에
														//new로 생성
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setText("BTN TWO Click");
				lblMessage.setForeground(Color.magenta);
				lblMessage.setBackground(Color.cyan);
			}
		});
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3SwingButton("버튼생성");
		
	}

}
