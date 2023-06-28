package study.day0308;

public class Student extends School {
	private String stuName;
	private String stuAddr;
	private int score;
	
	public Student() {
		super();//디폴트 생성자라 생략가능
	}

	public Student(String schoolName, String schoolLoc, String stuName, String stuAddr, int score) {
		super(schoolName, schoolLoc);//디폴트 아니라 생략 불가능
		this.stuName = stuName;
		this.stuAddr = stuAddr;
		this.score = score;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuAddr() {
		return stuAddr;
	}

	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAddr=" + stuAddr + "\nscore=" + score + ", \ntoString()="
				+ super.toString() + "]";
	}
	
	
	
}
