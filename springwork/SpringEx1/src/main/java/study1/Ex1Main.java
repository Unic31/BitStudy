package study1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자바 방식으로 호출
		MessageInter m1=new Message1();//인터페이스 상속받은 클래스
		m1.sayHello("캔디");
		
		MessageInter m2 = new Message2();
		m2.sayHello("안쏘니");
		
		
		//스프링 방식으로 호출
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
		MessageInter m3 = (Message1)context.getBean("mes1");//방법1
		MessageInter m33 = (Message1)context.getBean("mes1");//방법1
		
		
		MessageInter m4 = context.getBean("mes2",Message2.class);//방법2
		
		m3.sayHello("이영자");
		m33.sayHello("이영자3");
		//scope="singletone" 인 경우 두 주소가 서로 같다(기본값)
		//scope="prototype" 인 경우는 두 주소가 다르다
		System.out.println("주소비교:"+m3.hashCode()+":"+m33.hashCode());
		m4.sayHello("강호동");
	}

}
