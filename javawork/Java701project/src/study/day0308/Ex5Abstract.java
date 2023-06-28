package study.day0308;

abstract class AA {
	abstract public void play();
}

abstract class BB extends AA {
	abstract public void draw();
}

class CC extends BB {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("play");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("draw");
	}

}

public class Ex5Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BB b=new CC();
		b.play();
		b.draw();
	}

}
