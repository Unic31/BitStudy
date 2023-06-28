package study.day0307;

class Rect {
	int width, height;
	
	public Rect(int w,int h)
	{
		this.width=w;
		this.height=h;
	}
	double getArea() {
		return (double)width*height;
	}
}
