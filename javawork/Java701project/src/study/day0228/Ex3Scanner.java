package study.day0228;

import java.util.Scanner;

public class Ex3Scanner {

   public static void main(String[] args) {              //다시공부
      // TODO Auto-generated method stub
      Scanner sc=new Scanner(System.in);
      
//      int kor,eng;
//      System.out.println("Input Kor?");
//      kor=sc.nextInt();
//      System.out.println("Input Eng?");
//      eng=sc.nextInt();
//      
//      int sum=kor+eng;
//      System.out.println("두 과목의 합계는 "+sum+"점 입니다");
      
//      String name;
//      int age;
//      System.out.println("이름입력");
//      name=sc.nextLine();
//      System.out.println("나이입력");
//      age=sc.nextInt();
//      System.err.printf("%s님의 나이는 %d입니다",name,age);
      
      String name;
      int age;
      //숫자 입력 후 문자 입력 하는 경우에만 문제가 발생한다
      //nextLine으로 다 읽어버리고, 필요한 경우에만 int로 변환
      System.out.println("나이입력");
      age=sc.nextInt();
      
      //키보드 버퍼의 엔터 문자를 먼저 읽어서 없앤다
      sc.nextLine();
      
      System.out.println("이름입력");
      name=sc.nextLine();
      
      System.err.printf("%s님의 나이는 %d입니다",name,age);
   }

}