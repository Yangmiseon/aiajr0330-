package ex200420;

import java.util.Scanner;

public class MinMax {

	
	// 최소값 반환
	 public static int miniValue1(int[] arr) { 
		 int min = arr[0];
	  for(int i=0; i<arr.length; i++) {
	   if(arr[i]<min)
	   min=arr[i];
	  }
	  return min;
	 }

	 // 최대값 반환
	 public static int maxValue(int[] arr) { 
	  int max=0;
	  for(int i=0; i<arr.length; i++) {
	   if(arr[i]>max);
	   max=arr[i];
	  }
	  return max;
	 } 
	 
	 
	 
	 public static void main(String[] args) {
	  //원본 배열 생성
	
      Scanner sc = new Scanner(System.in);
      System.out.println("정수를 입력해주세요.");
      int a = sc.nextInt();
    
      int[] arr = new int[a];
	  //결과 저장 할 배열 선언
	  int min = arr[0];
	  int max = arr[0];
	  
	  
     
      for(int i=0; i<arr.length;i++){
        arr[i] = sc.nextInt();
      }

	  //메서드를 호출하고 결과를 min, \max에 저장
	  min=miniValue1(arr);
	  max=maxValue(arr);
	//  
	  for(int x=0; x<arr.length; x++) 
	  System.out.print(arr[x]+" ");
	  
	  System.out.println();
	  System.out.print("--------------- ");
	  System.out.println();

	  System.out.println(min);
	  System.out.println(max);

	 }

}
		
		

