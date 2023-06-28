package study.day0308;

public class School {
	private String schoolName;
	private String schoolLoc;
	
	public School() {
		super();
	}

	public School(String schoolName, String schoolLoc) {
		super();
		this.schoolName = schoolName;
		this.schoolLoc = schoolLoc;
	}

	public String getSchoolName() { //값요구
		return schoolName;
	}

	public void setSchoolName(String schoolName) { //값변경
		this.schoolName = schoolName;
	}

	public String getSchoolLoc() {
		return schoolLoc;
	}

	public void setSchoolLoc(String schoolLoc) {
		this.schoolLoc = schoolLoc;
	}

	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + ", schoolLoc=" + schoolLoc + "]";
	}
	
	
	
		
	
}
