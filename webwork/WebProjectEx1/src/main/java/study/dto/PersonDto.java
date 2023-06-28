package study.dto;

public class PersonDto {
	private int num;
	private String name;
	private int year;
	private String add;
	private String job;
	private String photo;
	
	public PersonDto() {
		super();
	}
	public PersonDto(int num, String name, int year, String add, String job, String photo) {
		super();
		this.num = num;
		this.name = name;
		this.year = year;
		this.add = add;
		this.job = job;
		this.photo = photo;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
