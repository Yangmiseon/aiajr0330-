package ex2;

public class SCE {

	public static void main(String[] args) {
		
		int a = ((25+5)+(36/4)-72)*5;
		int b = ((25+5)+(36-4)-72)/4;
		int c = (128/4)*2;
		
		boolean check1 = a > b;
		boolean check2 = b > c;
		if(check1) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		
		
		
		
		System.out.println("----------------------------------");
		
		int n1 = 3+6;
		int n2 = n1 + 9;
		int n3 = n2 + 12;
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
			
			
			
		
			
			
		
			//문제1
			int num1 = 10;
			int num2 = 20;
			int num3 = 30;
			
			num1 = num2 = num3;
			System.out.println(num1 = num2 = num3);
			//num3의 30이 num2에 대입되고, num1에 대입되어 30이 출력
			
			
			//문제2
			int a1 = (((25*5) + (36-4)) - 72)/5;
			System.out.println(a1);
	}

}
	

