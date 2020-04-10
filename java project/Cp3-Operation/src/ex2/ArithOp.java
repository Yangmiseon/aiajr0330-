package ex2;

public class ArithOp {

	public static void main(String[] args) {
		//숫자 2개를 받고 더하기 빼기 연산 결과를 출력
		//1.숫자 2개를 받는다. -> 변수선언
		int n1 = 7;
		int n2 = 3;
		
		//2. 덧셈 연산 -> 결과를 출력하자.
		int result = n1 + n2;
		System.out.println("덧셈 결과: " +result);
		
		//3. 뺄셈 연산 - > 결과 출력
		result = n1 - n2;
		System.out.println("뺄셈 결과: " +result);
		
		
		//4. 곱의 연산 -> 결과 출력
		result = n1 * n2;
		System.out.println("곱셈 결과: " +result);
		
		//5. 나눗셈의 연산 ->결과 출력
		result = n1 / n2;
		System.out.println("나눗셈 결과: " +result);
		
		//6. 나머지의 연산 -> 결과출력
		result = n1 % n2;
		System.out.println("나머지 결과: " +result);

	}

}
