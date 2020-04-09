package ex1;

public class Test3 {

	public static void main(String[] args) {
	
		double num1, num2, result;
		num1 = 1.000001;
		num2 = 2.000001;
		result = num1 +num2;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(result); //부동 소수점의 표현은 항상 오차가 발생
	
		
		double num3 = num1 * 1000000; // 정수로 표현
		double num4 = num2 * 1000000;
		double result1 = num3 +num4;
		System.out.println(result1/1000000); 
		// 연산 후 1000000 나누어 소주점 표현
		
	
	
	}

}
