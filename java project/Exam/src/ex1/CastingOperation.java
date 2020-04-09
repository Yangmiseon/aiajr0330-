package ex1;

public class CastingOperation {

	public static void main(String[] args) {
		//대문자 A의 유니코드값과 Z의 유니코드값을 구하라

		char ch1='A'; // 문자 타입의 변수 ch1선언, 초기화
		char ch2='Z'; 
		
		int num1 = ch1; //형변환 해주는 1번방법
		int num2 = (int)ch2; //형변환 해주는 2번방법
		
		System.out.println(num1); //변환된 유니코드 값이 출력 65
		System.out.println(num2); //90
		
		
		//작은 타입으로 명시적으로 처리가능 유니코드65가 A라는걸 알고 있어서
		//유니코드 65의 문자를 출력하세요
		int code = 65; // 코드값 선언
		char ch3 = (char) code; //변환
		System.out.println(ch3); // A
				

	}

}
