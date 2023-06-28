package study.day0307;

public class BookTelevisionTest {
	int channel;
	int volume;
	boolean onOff;
	
	BookTelevisionTest()
	{
	
	}
	
	BookTelevisionTest(int c,int v,boolean o){//생성자 정의
		channel=c;
		volume=v;
		onOff=o;
	}
	void pirnt() {
		System.out.println("채널은"+channel+"이고 볼륨은"+volume+"입니다.");
	}
	
	public static void main(String[] args) {
		
		
		BookTelevisionTest myTv=new BookTelevisionTest();
		myTv.channel = 7;
		myTv.volume = 10;
		myTv.onOff = true;
		
		BookTelevisionTest yourTv = new BookTelevisionTest();
		yourTv.channel=9;
		yourTv.volume=10;
		yourTv.onOff=true;
		System.out.println("나의 텔레비전의 채널은 "+myTv.channel+"이고 볼륨은 "+myTv.volume+"입니다");
		System.out.println("너의 텔레비전의 채널은 "+yourTv.channel+"이고 볼륨은 "+yourTv.volume+"입니다");
		
		BookTelevisionTest myTv2 = new BookTelevisionTest(7, 8, true);
		myTv2.pirnt();
		
		BookTelevisionTest yourTv2 = new BookTelevisionTest(11, 20, false);
		yourTv2.pirnt();
		

	}

}
