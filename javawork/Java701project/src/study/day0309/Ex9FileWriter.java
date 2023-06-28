package study.day0309;

import java.io.FileWriter;
import java.io.IOException;

public class Ex9FileWriter {
	
	static final String FILENAME = "C:\\bit701naver/memo.txt";//memo.txt가 없을경우 새로 만들고 있을경우 덮어씀
	
	public static void memoWrite()
	{
		FileWriter fw=null;//Write는 버퍼 필요 없는듯
		
		try {
			fw=new FileWriter(FILENAME,true);//기존 파일에 추가
			
			fw.write("이름:이영자\n");
			fw.write("주소:서울시 강동구\n");
			fw.write("핸드폰:010-7777-3333\n");
			fw.write("======================\n");
			
			System.out.println("파일탐색기에서 memo.txt를 확인 하세요");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		memoWrite();
	}

}
