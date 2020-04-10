package ex2;

public class PrefixOp2 {

	public static void main(String[] args) {


		int num1 =7; //num1의 값은 7
		int num2 = num1++; //num2는 7, num1의 값은 8
		int num3 = num1--; //  num2 = 7, num3=8, num1 = 7
		
		System.out.println(num1++); //출력:7 num1=8 num2=7, num3=8
		System.out.println(num2); // 출력num2=7
		System.out.println(num2--); // 출력:7 출력num2=6
		System.out.println(num3); // 출력num3=8
	}

}
