package ex1;

public class SuffixConst {

	public static void main(String[] args) {
		
		
		double e1=7.125;
		float e2 = 7.125F; // F는 float형 상수표현
		/*기본적으로 실수는 double를 사용.
		 *  float형 변수가 너무 작아 저장이 안되기 때문에 
		 *  float형 변수에 접미사 F를 붙여줌.
		 * 기본적으로 double변수에 실수를 저장하고, 계산속도도 빠름.
		 * 
		 */
		
		long n1 = 10000000000L; // L은 long의 상수표현
		//  범위를 벗어나므로 저장이 안됨. 뒤에 L을 붙여줌
		long n2 = 150;
		
		System.out.println(e1); //7.125
		System.out.println(n1); //1000000

	}

}
