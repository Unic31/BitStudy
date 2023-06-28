package study.day0306;

class Orange{
	private String stuName;
	private String stuNum;
	private int javaScore;
	private int springScore;
	
	//setter method - 값 변경(return은 void)
	public void setStuName(String stuName) //set다음 대문자
	{
		this.stuName=stuName;
	}
	public void setStuNum(String stuNum)
	{
		this.stuNum=stuNum;
	}
	public void setJavaScore(int javaScore)
	{
		this.javaScore=javaScore;
	}
	public void setSpringScore(int springScore)
	{
		this.springScore=springScore;
	}
	//getter method - 값 반환
	public String getStuName() //get다음 대문자
	{
		return this.stuName;//this.생략가능	
	}
	public String getStuNum() 
	{
		return this.stuNum;
	}
	public int getJavaScore()
	{
		return this.javaScore;
	}
	public int getSpringScore()
	{
		return this.springScore;
	}
	
	//java, spring 점수를 한번에 변경하고 싶을때
	public void setScore(int javaScore, int springScore)
	{
		this.javaScore=javaScore;
		this.springScore=springScore;
	}
	
	//두 과목의 합계를 반환하는 메소드
	public int getTotal()
	{
		return javaScore+springScore;
	}
	
	//두 과목의 평균을 반환하는 메소드
	public double getAverage()//
	{
		return getTotal()/2.0;//수식 중 하나라도 더블이면 더블로 나오기 때문에 2가 아니라 2.0
	}
	public String getGrade()
	{
//		if(getAverage()>=90) {
//			return "Very Good";
//		}else if(getAverage()>=80) {
//			return "Good";
//		}else {
//			return "Try";
//		}
		
		double a=this.getAverage();
		String grade;
		if(a>=90)
			grade="Very Good";
		else if(a>=80)
			grade="Good";
		else
			grade="Try";
		return grade;
	
		
	}
	
}



public class Ex5Object {
	
	public static void orangeWrite(Orange o)//변수 암거나
	{
		System.out.println(o.getStuName()+" 님의 정보");
		System.out.println("학번 : "+o.getStuNum());
		System.out.println("자바 점수 : "+o.getJavaScore());
		System.out.println("스프링 점수 : "+o.getSpringScore());
		System.out.println("두 과목의 합계 : "+o.getTotal());
		System.out.println("두 과목의 평균 : "+o.getAverage());
		//평균 이상이90이상이면 "Very Good", 80이상이면 "Good", 나머지는 "Try"
		System.out.println("해당 학생의 등급 : "+o.getGrade());
		System.out.println("=".repeat(20));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange or1=new Orange();
		or1.setStuName("홍길동");
		or1.setStuNum("s123456");
		or1.setJavaScore(90);
		or1.setSpringScore(97);
		
		Orange or2=new Orange();
		or2.setStuName("강호동");
		or2.setStuNum("s111223");
		or2.setScore(100, 98);
		
		orangeWrite(or1);
		orangeWrite(or2);
	}

}
