package Op200416;

public class Operation4 {


		//두개의 정수를 전달받는다.
		//두수의 사칙연산결과를 출력한다.
		//>>단 나눗셈은 몫과 나머지를 각각 출력해야한다.
		//이 메서드를 호출하는 메서드를 정의해보자.

	
		int add(int a, int b) {//덧셈
		int result = a+b;
		return result;
		
		
		}
		
		int multiply(int a, int b) {//곱셈
			int result = a*b;
			return result;
			
			
			}
		
		int subtract(int a, int b) {//뺄셈
			int result = a-b;
			return result;
			
			
			}
		double divide(double a, double b) {//나눗셈
			if(b!=0) 
				System.out.println(a + " 나누기 " + b + " : 몫" + (int)(a/b) + ", 나머지 " + (int)(a%b)); 
			else if(a!=0) 
				System.out.println("제수가 0이면 안 된다.");
			return 0;
	
			
			
			}
		
	
}


