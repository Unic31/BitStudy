package study.day0228;

public class Ex2MainArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[1]+args[0]);
		//"100"을 문자열 100을 계상 가능한 숫자 100으로 변환
		int su1=Integer.parseInt(args[0]);//형태는 숫자인데 문자 타입인걸 변환(이런게 staitc메소드, new로 호출하지 않음)
		int su2=Integer.parseInt(args[1]);
		System.out.println(su1+su2);
		
		
	}
	
	

}
