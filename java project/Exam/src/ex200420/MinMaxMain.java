package ex200420;

import java.util.Scanner;

public class MinMaxMain {

	public static void main(String[] args) {
		
	//Student [] 변수명 = new Student[ 배열의 길이 ] ;
	//	int[]arr = new int[10];
		
		 Scanner mms = new Scanner(System.in);
		 
		 System.out.println("사이즈를 선택하기");
		 int size = mms.nextInt();
		 
		 int[] arr = new int[size];
		 int count = 0;
		 
		 for(int i=0; i<arr.length; i++) {
			 System.out.println("요소입력");
			 arr[i] = mms.nextInt();
		 }
		 
		 
		 MinMax mmn = new MinMax();
		  mmn.miniValue(arr);
		  System.out.println(mmn.miniValue(arr));
		  
		  MinMax mmx = new MinMax();
		  mmx.maxiValue(arr);
		  System.out.println(mmx.maxiValue(arr));
		  
		  
	}
	

}
