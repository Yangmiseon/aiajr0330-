package ex200420;

import java.util.Date;
import java.util.Scanner;

public class KeyborardScaning {

	public static void main(String[] args) {


		Scanner sc=new Scanner(System.in);
		Date date = new Date();
		
		System.out.println("숫자 입력해주세요");
		int num1= sc.nextInt();
		
		System.out.println("숫자 입력해주세요");
		int num2= sc.nextInt();
		
		System.out.println("숫자 입력해주세요");
		int num3= sc.nextInt();
		
		int sum=num1+num2+num3;
		System.out.printf("입력된 정수는 %d,%d,%d 입니다. 숫자들의 합은 %d입니다.",num1,num2,num3,sum);
				
	}

}
