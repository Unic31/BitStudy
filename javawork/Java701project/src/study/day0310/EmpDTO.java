package study.day0310;

public class EmpDTO {
	private String name;
	private String busu;
	private int age;
	private int hp;

	public EmpDTO(String name, String busu, int age, int hp) {
		super();
		this.name = name;
		this.busu = busu;
		this.age = age;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusu() {
		return busu;
	}

	public void setBusu(String busu) {
		this.busu = busu;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
