package study.day0308;



public class Ex1Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1=new Student();//s1은 래퍼런스 변수라 주소가 나온다.
		System.out.println(s1);//s1.toString()과 같다.
		
		//s1에 값을 넣어보자
		s1.setSchoolName("강남고");//부모꺼지만 상속받아서 호출 됨. 본인꺼 없어야됨
		s1.setSchoolLoc("청담동");
		s1.setStuName("이미자");
		s1.setStuAddr("강남구");
		s1.setScore(99);
		System.out.println(s1);
		
		System.out.println("=".repeat(30));
		Student s2=new Student("역삼고","역삼동","강철수","역삼동",89);
		System.out.println(s2);
	}

}
