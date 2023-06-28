package study.day0227;

public class Ex2StringType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2글자 이상 저장시 문자열 처리
		String s1=new String("Hello");//방법1
		String s2="Apple Mango"; //방법2
		String s4="  Happy  ";
		System.out.println(s1);
		System.out.println(s2);
		
		
		String s3=s1+100;//String+int=String : 문자열에서 + 는 나열
		System.out.println(s3);
		System.out.println("34+89="+34+89);//34+89=3489
		System.out.println("34+89="+(34+89));//34+89=123 괄호 안 int+int 먼저 처리한 뒤 String+int처리가 된다
		
		//String 클래스가 가진 메소드들
		System.out.println("s1의 length="+s1.length());//길이를 구하는 length()메소드
		System.out.println("s2의 length="+s2.length());
		System.out.println("s4의 length="+s4.length());//공백도 길이에 포함된다=9
		System.out.println("s4의 length="+s4.trim().length());//trim()은 앞 뒤 공백 제외 하고 길이(사이에 값은 안됨)=5
		
		//charAt(인덱스) : 문자열에서 인덱스 번지에 해당하는 문자(1글자) 반환
		//indexOf(문자) : 해당 문자가 어디에 있는지 인덱스값 반환, 위 아래가 완전 반대
		String msg="Have a Good Day";
		System.out.println(msg.charAt(7));//G
		System.out.println(msg.charAt(12));//D
		System.out.println(msg.indexOf('G'));//7
		System.out.println(msg.indexOf('D'));//12
		System.out.println(msg.indexOf('a'));//처음만난 a의 인덱스 반환, 1
		System.out.println(msg.lastIndexOf('a'));//마지막 a의 인덱스값 반환, 13
		
		//변수.startsWith("문자열"):변수가 "문자열"로 시작하면 true로 반환
		//변수.endsWith("문자열"):변수가 "문자열"로 끝나면 true 로 반환
		System.out.println(msg.startsWith("Have"));//true
		System.out.println(msg.startsWith("have"));//false
		
		System.out.println(msg.endsWith("Hello"));//false
		System.out.println(msg.endsWith("Day"));//true
		
		//substring(5):5번 인덱스부터 끝까지 반환
		//substring(1,10):1~(10-1) 인덱스에 해당하는 문자열 반환(1~9까지 반환)
		System.out.println(msg.substring(7));//7번(G)부터 끝까지 추출해서 반환
		System.out.println(msg.substring(7,10));//Goo (7~9까지만 추출)
		
		System.out.println(msg.toLowerCase());//전부 소문자로 반환
		System.out.println(msg.toUpperCase());//전부 대문자로 반환
		
		//replace : 일부 문자 또는 단어 변경 후 반환
		System.out.println(msg.replace('a', '*'));//H*ve * Good D*y
		System.out.println(msg.replace("Good", "Happy"));//Have a Happy Day
		
		//문자열 비교 : equals, compareTo
		String m1="Apple";
		String m2="apple";
		String m3="Orange";
		
		//==기본형에서는 값으로 비교, 클래스타입에서는 주소비교를 의미
		System.out.println(m1==m2);//주소비교 false
		//문자열같은 경우는 정확하게 값으로 비교하려면 위의 두 메소드를 사용
		System.out.println(m1.equals(m2));//false:m1이 m2와 같은지 비교(대소문자가 다를 경우 false)
		System.out.println(m1.equals("Apple"));//true
		System.out.println(m1.equalsIgnoreCase(m2));//대소문자 무시하고 철자만 비교:true
		
		//compareTo는 두 문자열의 아스키코드값의 차이를 반환
		System.out.println(m1.compareTo(m3));//A(65)-O(79) : -14(음수:m1이 작을경우)
		System.out.println(m1.compareTo("Apple"));//두 변수의 값이 완전히 같을경우 0 이 나온다
		System.out.println("computer".compareTo("command"));//'p'와 'm'을 비교 p(112), m(109):3(양수:앞의 값이 더 크다는것)
		
		//split(','): , 로 분리하여 배열 타입으로 반환
		String colors="red,blue,green,orange,pink,black";
		String []mycolor=colors.split(",");
		System.out.println("총"+mycolor.length+"개 분리함");
		//for문으로 출력(배열 갯수만큼 자동 반복)
		for(String ch:mycolor) {
			System.out.println(ch);//분리한 색상표 출력
		}
	}

}
