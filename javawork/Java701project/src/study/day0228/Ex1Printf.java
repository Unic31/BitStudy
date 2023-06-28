package study.day0228;

import java.util.Date;

public class Ex1Printf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printf:변환기호를 이용해서 출력
		//Date클래스는 jdk1.1에서 deprecate(권장하지않음, 더 좋은게 있음). 대신 Calendar를 쓰기를 권장
		Date date=new Date();//현재 날짜나 시간을 구하기 위한 클래스
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day=date.getDate();
		
		System.out.printf("%d-%02d-%02d\n",year,month,day);// %02d가 두자리중 남는걸 0을 채워라 라는 의미?
															// %2d는 남는자리가 공백으로 채워짐
		System.out.printf("%10d-%02d-%02d\n",year,month,day);//%10d:10칸중 우측정렬로 출력(남는자리는 공백으로 채움)
		
		int h=date.getHours();
		int m=date.getMinutes();
		int s=date.getSeconds();
		System.out.printf("현재시간 %02d:%02d:%02d\n",h,m,s);
		
		String msg="Bitcamp";
		System.out.printf("*%s*\n",msg);
		System.out.printf("*%20s*\n",msg);//20칸에 출력(우측정렬)
		System.out.printf("*%-20s*\n",msg);//20칸에 출력(좌측정렬)
		
		double d=23.45678;
		System.out.printf("*%f*\n",d);
		System.out.printf("*%3.3f*\n",d);//전체 자리수 3(부족할경우 1열부터 출력)
		System.out.printf("*%10.2f*\n",d);//전체자리수 10(우측에 출력, 남는자리 공백으로 출력
		System.out.printf("*%-10.2f*\n",d);//전체자리수 10(좌측에 출력, 남는자리 공백으로 출력
		System.out.printf("*%010.2f*\n",d);//전체자리수 10(우측에 출력, 남는 자리는 0으로 출력
	}

}
