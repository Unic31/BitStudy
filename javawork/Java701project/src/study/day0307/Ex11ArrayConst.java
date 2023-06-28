package study.day0307;

class MyShop
{
	private String sangpum;
	private int su;
	private int dan;
	
	MyShop()
	{
//		sangpum="사과";
//		su=1;
//		dan=2000;
		this("사과",1,2000);
	}
	MyShop(String sangpum, int su, int dan)
	{
		this.sangpum=sangpum;
		this.su=su;
		this.dan=dan;
	}
	MyShop(String sangpum, int su)
	{
//		this.sangpum=sangpum;
//		this.su=su;
//		dan=1000;
		this(sangpum,su,1000);
	}
	public void writeMyShop()
	{
		System.out.println("품명:"+sangpum+"\t수량:"+su+"\t단가:"+dan);
	}
	
	
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}

	
	
	
}

public class Ex11ArrayConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyShop []my=new MyShop[4];
		my[0]=new MyShop();//사과,1,2000
		my[1]=new MyShop("딸기우유",2,1000);
		my[2]=new MyShop("눈깔사탕",5);//단가 전달 안됐을경우 기본 1000
		my[3]=new MyShop("초코렛",4,1200);
		
		System.out.println("**MyShop 초기값 출력**");
		for(MyShop s:my)
			s.writeMyShop();
		
		System.out.println("**0번지 데이터 수정**");
		my[0].setSangpum("참외");//상품명수정
		my[0].setSu(3);//수량 수정
		my[0].setDan(3500);//단가 수정
		for(MyShop s:my)
			s.writeMyShop();
		
	}

}
