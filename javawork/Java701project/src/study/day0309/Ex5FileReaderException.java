package study.day0309;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex5FileReaderException {

	static final String FILENAME = "C:\\bit701naver/member18.txt"; // 경로중 슬래쉬는 한번이나 두번 상관없지만 역슬래쉬는 두번

	public static void memberRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);// 경로가 틀려 파일이 생성 안되면 바로catch로 가기 때문에 br값이 null이 나온다
			System.out.println("파일 존재함");

			// 한줄 단위로 파일에서 읽기 위해서 BufferedReader로 변환
			br = new BufferedReader(fr);// BufferedReader뒤 변수는 리더타입만?
			while (true) {
				String name = br.readLine();
				if (name == null || name.length() == 0)// 빈줄도 데이터로 읽기 때문에 없으면 break;
					break;
				String addr = br.readLine();
				String hp = br.readLine();
				System.out.println("이름:" + name + ",주소:" + addr + ",핸드폰:" + hp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없어요" + e.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			//방법1(널포인트 주기)
			// 파일이 없을경우 br이 생성되기 전에 catch로 가면서 br이 NullPointerException이 발생
//			try {
//				System.out.println("자원들 모두 닫힘");
//				br.close();
//				fr.close();
//			} catch (IOException|NullPointerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("정상종료");
//			}
			
			// 방법2
			System.out.println("자원들 모두 닫힘");
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		memberRead();
	}

}
