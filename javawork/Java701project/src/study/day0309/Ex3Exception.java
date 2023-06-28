package study.day0309;

public class Ex3Exception {

	
	public static void excepTest() {
		System.out.println("안녕하세요");
		
		try {
			Thread.sleep(2000);//2초 딜레이
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("2초뒤 반가워요");
	}
	
	public static void excepTest2() throws InterruptedException
	{
		System.out.println("하나");
		Thread.sleep(2000);
		System.out.println("2초뒤 둘");
		Thread.sleep(3000);
		System.out.println("3초뒤 셋");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		excepTest();
		
		//excepTest2();//위에 메소드 throws 하는순간 자동으로 에러걸림
		try {
			excepTest2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
