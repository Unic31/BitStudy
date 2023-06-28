package study.day0303;

public class Ex1Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []ch; //배열 선언'만' 한것, 메모리 할당이 안되있어서 이상태로는 데이터 저장 불가
		ch=new char[4]; //메모리 할당. 총 4개의 char 문자를 저장 할 수 있다(연속적으로). 
						//할당과 동시에 초기값 지정. 데이터 안넣으면 (0, null)값 나옴
		
		//할당된 배열에 데이터를 넣기
		ch[0]='A';
		ch[1]='J';
		ch[2]='N';
		ch[3]='L';
				
		
		
		//출력 (1번방법)
		for(int i=0;i<ch.length;i++) {
			System.out.println(ch[i]+":"+(int)ch[i]);
		}
		System.out.println("=".repeat(20));
		
		//출력 (2번방법)
		for(char a:ch) {
			System.out.println(a+":"+(int)a);
		};//a에 ch배열이 담겨서 길이만큼 자동으로
		
	}

}
