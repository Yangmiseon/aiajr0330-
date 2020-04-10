package ex2;

public class DivOpnd {

	public static void main(String[] args) {
		
		/*   /연산자와 %연산자의 연산 방식
		   -> 피 연산자가 정수면 정수형 연산 진행
		   -> 피 연산자가 실수면 실수형 연산 진행, 단 %연산자 제외!
		   홀수, 짝수 등 배수검사에 주로 사용.
		 */
		
		//1.정수형 나눗셈  -> 결과출력
		int n1 = 7;
		int n2 = 3;
		
		int result = n1/n2;
		System.out.println("정수형 나눗셈: " +result);
		
		//2. 실수형 나눗셈  -> 결과출력
		
		float n3 = 7.0f;
		float n4 = 3.0f;
		
		float result1 = n3/n4;
		System.out.println("실수형 나눗셈: " +result1);
		
		//3.형 변환 나눗셈 ->결과출력
		float result3 = (float)n1/n2;
		System.out.println("형 변환 나눗셈: " +result3);
		System.out.println("형 변환 나눗셈: " +(float)n1/n2);
				
	}

}
