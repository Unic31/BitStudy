package study.day0308;

interface InterB {
	public void paint();

	public void save();
}

abstract class AbstOne {
	public void show() {
		System.out.println("AnstOne-show");
	}

	abstract public void study();
}

class MyAnony {
	// InterB구현
	InterB a = new InterB() {

		@Override
		public void save() {
			// TODO Auto-generated method stub
			System.out.println("save");
		}

		@Override
		public void paint() {
			// TODO Auto-generated method stub
			System.out.println("paint");
		}
	};
	// AbstOne
	AbstOne b = new AbstOne() {

		@Override
		public void study() {
			// TODO Auto-generated method stub
			System.out.println("study");
		}
		
		@Override
		public void show() {
			super.show();
			System.out.println("익명 내부 클래스에서 나머지 show 처리");
		}
		
	};
}

public class Ex13AnonyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyAnony my=new MyAnony();
		my.a.paint();
		my.a.save();
		
		
		
		my.b.study();
		my.b.show();
	}

}
