package study.day0303;

public class Ex3Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr1 = {34,56,78,100,39};
		double []arr2 = {1.2,5.6,7.8,12.89,10.9};
		System.out.println(arr1.length);
		System.out.println(arr2.length);
		
		for(int i=0;i<arr1.length;i++) { //1번 출력법
			System.out.printf("%5d",arr1[i]);//5칸 단위로 출력, 빈자리수만큼 앞에서부터 공백
		}
		System.out.println();
		for(int a:arr1) { //2번 출력법
			System.out.printf("%5d",a);
		}
		System.out.println();
		System.out.println("=".repeat(30));
		
		for(int i=0;i<arr2.length;i++) {
			System.out.printf("%5.1f",arr2[i]); //5칸 단위로 출력, 빈자릿수만큼 앞에서 공백, 소숫점은 한칸(.1)
		}
		System.out.println();
		for(double a:arr2) {
			System.out.printf("%5.1f",a);
		}
		
		
		
		
	}

}
