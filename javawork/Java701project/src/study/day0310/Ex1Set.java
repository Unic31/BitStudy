package study.day0310;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex1Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set인터페이스를 구현한 클래스를 HashSet:정렬안됨 비순차적,중복 허용 안함
		//								  TreeSet:정렬되어나옴, 중복허용x
		//제네릭스 : <String> : String 타입만 넣을수 있다는뜻
		Set<String> set1=new HashSet<>();
		Set<Integer> set2=new TreeSet<>();
		
		set1.add("apple");
		set1.add("oreange");
		set1.add("apple");
		set1.add("banana");
		//set1.add(3);//오류발생 - generics때문에 발생
		
		System.out.println("set1="+set1.size()+"개");//3개 ..apple는 1번으로 계산
		
		System.out.println("***출력1***");
		for(String s:set1)
			System.out.println(s);//추가한 순서대로 안나온다(비순차적)
		
		System.out.println("***출력2-iterator***");
		Iterator<String>iter=set1.iterator();
		while(iter.hasNext()/*==true*/)//hashNext():다음 테이터가 있을경우 true:ture인 동안 반복
		{
			String s=iter.next();//다음 데이터를 얻어서 출력
			System.out.println(s);
		}
		
		//set2:배열에 int를 넣은 후 set2에 넣기
		int []arr= {4,1,8,3,5,4,3};
		for(int a:arr)
			set2.add(a);
		
		System.out.println("set2="+set2.size()+"개");
		System.out.println("출력1");
		for(int s:set2)
			System.out.printf("%5d",s);
		

 	}

}
