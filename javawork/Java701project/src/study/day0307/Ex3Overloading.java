package study.day0307;

class Orange{
	public static int add(int a, int b)
	{
		return a+b;
	}
	public static double add(double a, double b)
	{
		return a+b;
	}
	public static float add(float a, float b)
	{
		return a+b;
	}
	public static String add(String a, String b)
	{
		return a+b;
	}

	
	
}

public class Ex3Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("5+6="+Orange.add(5,6));
		System.out.println("3.2+2.5="+Orange.add(3.2,2.5));
		System.out.println("2.4f+1.2f="+Orange.add(2.4f,1.2f));
		System.out.println("Apple+Orange="+Orange.add("Apple","Orange"));
	}

}
