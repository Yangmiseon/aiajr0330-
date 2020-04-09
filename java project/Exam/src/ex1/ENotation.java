package ex1;

public class ENotation {

	public static void main(String[] args) {
		//실수의 e표기법과 16진수 8진수 표현
		
		double e1 = 1.2e-3; //1.2 x 10의 -3승
		double e2 = 1.2e+3; //1.2 x 10의 3승
		
		int num1=0xA0E; //16진수
		int num2=0752; //8진수
		
		System.out.println(e1); //0.0012
		System.out.println(e2); //1200.0
		System.out.println(num1); //2574
		System.out.println(num2); //490
		

	}

}
