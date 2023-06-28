package study.dto;

public class ProjectDto {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String photo;
	private String food;
	private String price;
	private String star;
	private int count;

	public ProjectDto() {
		super();
	}

	public ProjectDto(int num, String writer, String title, String content, String photo, String food, String price,
			String star, int count) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.food = food;
		this.price = price;
		this.star = star;
		this.count = count;
	}
	

	public ProjectDto(String writer, String title, String content, String photo, String food, String price,
			String star) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.photo = photo;
		this.food = food;
		this.price = price;
		this.star = star;
	}

	public int getNum() {
		return num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
