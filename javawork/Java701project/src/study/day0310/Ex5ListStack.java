package study.day0310;

import java.util.List;
import java.util.Stack;

public class Ex5ListStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//push,pop : FristInLastOut 구조(먼저 들어간게 나중에 나오는 구조)
		Stack<String> list1=new Stack<>();
		list1.push("사과");
		list1.push("바나나");
		list1.push("사과");
		list1.push("오렌지");
		
		System.out.println(list1.size());
		
		while(!list1.isEmpty())
			System.out.println(list1.pop());
	}

}
