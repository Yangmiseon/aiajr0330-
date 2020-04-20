package Op200417;

public class AbsMain {

	public static void main(String[] args) {
		java.util.Scanner s = new java.util.Scanner(System.in);
		  System.out.println("숫자를 입력하세요\n");
		  int num3=s.nextInt();
		  int num4=s.nextInt();
		

		Abs ms = new Abs();
		
		System.out.println(ms.num1(num3));
		System.out.println(ms.num2(num4));

	}

}
