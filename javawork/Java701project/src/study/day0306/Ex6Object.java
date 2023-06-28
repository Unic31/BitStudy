package study.day0306;


class Person
{
	static final String CITY="Seoul";//상수
	
	private String name;
	private String hp;
	
	//setter
	public void setName(String name)
	{
		this.name=name;
	}
	public void setHp(String hp)
	{
		this.hp=hp;
	}
	//getter //변수를 반환. 메소드를 가져오는게 아님
	public String getName()
	{
		return this.name;
	}
	public String getHp()
	{
		return this.hp;
	}
	//name,hp 동시에 수정할 메소드 setInfo(String name, String hp)
	public void setInfo(String name, String hp)
	{
//		this.name=name;
//		this.hp=hp;
		setName(name);
		setHp(hp);
	}
	
}
public class Ex6Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []변수명=new int[3];
		Person []per=new Person[3];//메모리 할당만 한것, 생성이 아니라서 초기값은 null
		
		for(int i=0;i<per.length;i++) { //이게 생성
			per[i]=new Person();
		}
		
		per[0].setName("캐서린");
		per[0].setHp("010-2222-3333");
		
		per[1].setName("마이클");
		per[1].setHp("010-3333-4444");
		
		per[2].setName("수지");
		per[2].setHp("010-5555-6666");
		
		//출력방법
		System.out.println("City\tName\tHP");
		for(int i=0;i<per.length;i++)
		{
			System.out.println(Person.CITY+"\t"+per[i].getName()+"\t"+per[i].getHp());
		}
		System.out.println("=".repeat(30));
		//출력방법2
		for(Person p:per)
			System.out.println(Person.CITY+"\t"+p.getName()+"\t"+p.getHp());
		
		
		
	}

}
