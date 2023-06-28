package study.day0310;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex6ListVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List 인터페이스를 구현한 클래스
//		Vector<String> list1=new Vector<>();//일단 10개로 할당
//		Vector<String> list1=new Vector<>(5);//일단 5개로 할당. 초과될경우 2배로 늘어난다
		Vector<String> list1=new Vector<>(5,3);//일단 5개로 할당. 초과될경우 3개씩 늘어난다
		System.out.println("size는 실제 데이터가 들어있는 갯수"+list1.size());//0
		System.out.println("capacity는 할당 갯수:"+list1.capacity());//10 - Vector만이 갖고있는 메소드
		
		list1.add("장미꽃");
		list1.add("안개꽃");
		list1.add("장미꽃");
		list1.add("국화꽃");
		
		System.out.println(list1.size());
		
		List<String> list2=new Vector<>();
		//나열된 문자열이 List 타입으로 변환되서 리턴해주는 메소드
		list2=Arrays.asList("빨강생","분홍색","검정색","노랑색","오렌지색");
		System.out.println(list2.size());
		
		System.out.println("**list1 출력1**");
		int n=1;
		for(String s:list1)
			System.out.println(n++ +":"+s);
		
		System.out.println("**list2 출력2**");
		for(int i=0;i<list2.size();i++) {
			String s=list2.get (i);//i번지의 데이터를 꺼낸다
			System.out.println(i+1+":"+s);
		}
		
		System.out.println("**list2 출력3**");
		n=1;
		Iterator<String> iter=list2.iterator();
		while(iter.hasNext())
		{
			String s=iter.next();
			System.out.println(n++ +":"+s);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
