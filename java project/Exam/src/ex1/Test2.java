package ex1;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 문제1.
		 다음 두문장을 출력하는 프로그램을 작성해 보자.
		 System.out.println("2+5=" + 2+5);
	   	 System.out.println("2+5=" + (2+5));
		 * 
		 */
	
		System.out.println("2+5="+(2+5) + ", "   + 2+5);
		System.out.println("2+5=" + (2+5));
		
		
		/*문제2
		 * 숫자 15를 총 5회 출력하는 프로그램을 작성해 보자.
		 * 단 총 5회에 걸쳐서 출력이 이루어 져야 하고,
		 * 이를 위해서 구성이 되는 다섯 문장 모두 달라야 한다.
		 */
		System.out.println(15); //정수의 출력
		System.out.println(10+5); //덧셈 결과 출력 -연산
		System.out.println("1"+"5"); //숫자조합출력
		System.out.println( 1+"5"); //"1"+"5"
		System.out.println("15"); //문자열 출력
		System.out.println( 3*5);//곱셉 결과 출력 - 연산
		System.out.println( "" +1+5);
		
	}

}
