package study.day0228;

public class Ex5Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//증감연산자 ++, --
		//a++, ++a : 단항으로 사용시 전치, 후치 모두 같다.
		//다른 연산자오 사용시 전치는 1순위, 후치는 끝순위로 계산된다
		
		int a,b,m,n;
		a=b=5;
		++a;
		b++;
		System.out.printf("a=%d,b=%d\n",a,b);//둘다 6
		
		m=++a*3; //먼저 a가 증가 후 3을 곱한값을 m으로 대입한다 7*3
		n=b++*3; //먼저 3을 곱한값을 n에 대입 후 b가 증가된다 6*3
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
				
		a=b=3;
		System.out.println(a++);//출력 후 증가3
		System.out.println(++b);//증가 후 출력4
		
		
	}

}
