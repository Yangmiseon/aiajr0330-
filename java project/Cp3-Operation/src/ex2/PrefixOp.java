package ex2;

public class PrefixOp {

	public static void main(String[] args) {


		int num1 =7; //num1의 값은 7
		int num2 = ++num1; //num2는 8, num1의 값은 8
		int num3 = --num1; // num1 = 7, num2 = 8, num3=7
		
		System.out.println(++num1); //출력:8 num2=8, num3=7
		System.out.println(num2); // 출력num2=8
		System.out.println(--num2); // 출력num2=7
		System.out.println(num3); // 출력num3=7
	}

}
