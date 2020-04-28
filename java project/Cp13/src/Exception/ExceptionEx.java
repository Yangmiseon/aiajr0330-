package Exception;

import java.util.Scanner;

public class ExceptionEx {

	public static void main(String[] args) {
	
		
		 
		 try { 
			 int age = readAge();
			 System.out.println("나이는 "+age+"세 입니다.");
			 }
			
		 
		 
//		try { 
//			// 강제적으로 예외를 발생시킴 
//					   	 // throw new Exception("고의로 발생시켰음."); 
//						 // 위의 두 줄을 한 줄로 줄여 쓸 수 있다. 
//			} 
		catch (AgeInputException e) { 
				System.out.println("에러 메시지 : " + e.getMessage()); 
				e.printStackTrace();
				
			} 
			catch (Exception e) { 
				System.out.println("에러 메시지 : " + e.getMessage()); 
				e.printStackTrace(); 
				
				} 
		 		System.out.println("프로그램이 정상 종료되었음."); 
				}
	
	
		static int readAge() throws AgeInputException{//AgeInputException 니가해!
			Scanner kb = new Scanner(System.in);
			 System.out.println("나이를 입력하시오");
			 int age = kb.nextInt();
			
			 if(age<0) {
				 AgeInputException e = new AgeInputException(); 
				 throw e; 
				
			
				 
			 }
			 
			 return age;
		
		}
}


		

