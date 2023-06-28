package study.day0313;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex6ThreadCanvas extends JFrame implements ActionListener {
	
	MyDraw draw=new MyDraw();
	JButton btnStart=new JButton("원그리기 시작");
	JButton btnStop=new JButton("원그리기 멈춤");
	boolean loop=false;//true일 경우 원이 무한으로 그려지도록 할 예정
	Color drawColor=new Color(180,190,200);//색 초기값
	int xPos, yPos;//좌표를 전역변수로 두고 랜덤하게 바꿀것
	

	public Ex6ThreadCanvas(String title) {
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

	private void initDesign() { // 같은 클래스 내에서라 프라이빗이라도 상관 없긴 함
		// TODO Auto-generated method stub
		JPanel p=new JPanel();//패널생성
		p.add(btnStart);//패널에 버튼
		p.add(btnStop);//패널에 버튼
		
		this.add("North",p);//패널-버튼 위치
		
		this.add("Center",draw);//그리기위치
		
		//버튼 이벤트
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);//this:actionPerformed 메소드를 구현한 클래스의 인스턴스를 보낸다
										//버튼 눌렀을때 액션퍼폼드 호출?
	}
	
	//Canvas 내부클래스
	class MyDraw extends Canvas implements Runnable{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
//			super.paint(g);
			
			if(loop) {
				g.setColor(drawColor);
				g.fillOval(xPos, yPos, 60, 60);
			}
		}
		@Override
		public void run() {//러너블이 가지고 있는 메소드
			// TODO Auto-generated method stub
//			System.out.println("run");
			while(loop) {//loop가 true인 동안 계속=버튼시작을 한 순간
				//랜덤색상 구하기
				int r=(int)(Math.random()*256);//0~255
				int g=(int)(Math.random()*256);//0~255
				int b=(int)(Math.random()*256);//0~255
				
				drawColor=new Color(r,g,b);
				
				//랜덤하게 x좌표,y좌표 구한다
				xPos=(int)(Math.random()*450);
				yPos=(int)(Math.random()*450);
				
				
				//캔버스의 paint호출
				this.paint(getGraphics());
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6ThreadCanvas("Thread로 원 그리기");
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {//버튼을 눌렀을때?
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnStart) {
//			System.out.println("Start");
			loop=true;
		}else {
//			System.out.println("Stop");
			loop=false;
		}
		
		//Thread의run메소드 호출
		//인터페이스 러너블을 구현했으므로 스레드 생성자에 마이드로우의 인스턴스를 보낸다
		Thread th=new Thread(draw);//드로우로 스레드 생성
		th.start();//run메소드 호출
		
	}

}
