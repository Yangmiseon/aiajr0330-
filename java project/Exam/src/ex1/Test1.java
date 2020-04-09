package ex1;

public class Test1 {

	public static void main(String[] args) {
		/*1. 정수형 타입의 변수 num1변수를 선언하자
		 * 2. 변수 num1에 숫자 데이터 10을 저장하자
		 */
		
		int num1;
		num1=10; //변수 선언 후 처음 데이터 저장  -> 초기화
		
		
		/*3.정수형 타입의 변수 num2변수를 선언하고 숫자 20을 대입하자
		 */
		
		
		int num2 = 20; //변수 선언과 초기화가 한번에 정의
		
		
		/*4. 정수형 타입의 변수 num3을 선언하고 
		 *    변수 num1과 num2를 합하는 연산의 결과를
		 *    변수 num3에 대입한다.
		 */  
		
		
		int num3 = num1 + num2;
		/*OR
		 * int num3;
		 * num3=num1 + num2;
		 */
		
		// 5. 연산의 결과를 출력하자.
		System.out.println(num1 +"+" +num2+ "="  + num3);
		// 10+20 =30으로 출력됨

	}

}
