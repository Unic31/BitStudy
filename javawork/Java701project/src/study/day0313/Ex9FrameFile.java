package study.day0313;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex9FrameFile extends JFrame {
	
	JButton btnOpen=new JButton("파일열기");
	JButton btnSave=new JButton("파일저장");
	JTextArea area=new JTextArea();

	public Ex9FrameFile(String title) {
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

	private void initDesign() { // 같은 클래스 내에서라 프라이빗이라도 상관 없긴 함
		// TODO Auto-generated method stub
		JPanel p=new JPanel();
		p.add(btnSave);
		p.add(btnOpen);
		this.add("North",p);
		
		this.add("Center",new JScrollPane(area));
		
		//불러오기
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.setText("");//기존의 내용 일단 모두 지운 후 추가하기
				
				FileDialog dlg=new FileDialog(Ex9FrameFile.this, "파일 불러오기", FileDialog.LOAD);
				dlg.setVisible(true);
				
				//취소 누를경우 메서드 종료
				if(dlg.getDirectory()==null)
					return;
				
				//파일 디렉토리+파일명 얻기
				String path=dlg.getDirectory()+dlg.getFile();
//				System.out.println(path);
				
				//파일 줄단위로 읽어서 메모장textarea에 가져오기
				FileReader fr=null;
				BufferedReader br=null;
				
				try {
					fr=new FileReader(path);
					br=new BufferedReader(fr);
					
					while(true)
					{
						String data=br.readLine();
						if(data==null)
							break;
						area.append(data+"\n");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						if(br!=null) br.close();
						if(fr!=null) fr.close();
					} catch (IOException e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
		//저장하기
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg=new FileDialog(Ex9FrameFile.this, "파일 불러오기", FileDialog.SAVE);
				dlg.setVisible(true);
				
				//취소 누를경우 메서드 종료
				if(dlg.getDirectory()==null)
					return;
				
				//파일 디렉토리+파일명 얻기
				String path=dlg.getDirectory()+dlg.getFile();
				
				//메모장에 입력한 데이터
				String data=area.getText();
				
				//파일저장
				FileWriter fw=null;
				try {
					fw=new FileWriter(path);
					//파일 저장 후 창제목 변경
					fw.write(data);
					
					Ex9FrameFile.this.setTitle(dlg.getFile());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						fw.close();
					} catch (IOException e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex9FrameFile("메모장");
	}

}
