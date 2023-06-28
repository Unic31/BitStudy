package study.day0307;

class Person2{
	String name;
	public Person2() {
		
	}
	public Person2(String theName) {
		this.name=theName;
	}
	
	@Override
	public String toString() {
		return "Person2 [name=" + name + "]";
	}
}

class Employee2 extends Person2{
	String id;
	public Employee2() {
		super();
	}
	public Employee2(String name) {
		super(name);
	}
	public Employee2(String name, String id) {
		super(name);
		this.id=id;
	}
	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}

public class BookEmployeeTest {

	public static void main(String[] args) {
		Employee2 e=new Employee2("Kim","20210001");
		System.out.println(e);

	}

}
