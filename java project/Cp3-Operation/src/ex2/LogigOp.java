package ex2;

public class LogigOp {

	public static void main(String[] args) {
		
		// 2개의 정수형 숫자를 받고 비교.
		
		int num1 = 10; //사용자에게 받는 첫번째 숫자
		int num2 = 20;//사용자에게 받은 두번째 숫자
		
		//num1이 num2봐 큰지 확인 : 큰 경우-true, 작은 경우 -false
		boolean check1 = num1 > num2;
		
		//num1이 num2봐 같은지 확인 : 같은 경우-true, 다른 경우 -false
		boolean check2 = num1 == num2;
		
		if(check2) {
			System.out.println("num1의 값과 num2의 값이 같습니다.");
		}else {
			System.out.println("num1의 값과 num2의 값이 다릅니다.");
		}
		
		
		if(check1) {
			System.out.println("num1의 값이 num2의 값보다 큽니다.");
		}else {
			System.out.println("num1의 값이 num2의 값보다 작습니다.");
		}
		
		System.out.println("----------------------------------");
		/*성인 
		여성 중 
		기혼자에게만 
		메시지를 출력합니다.*/
		int age = 20;
		char gender = 'w';
		boolean mCheck = true;
		
		boolean result = age > 19 && gender=='w' && mCheck;
		
		if(result) {
			System.out.println("메시지를 보냅니다.");
		}

		
		int age1 = 20;
		char gender1 = 'M';
		boolean mCheck1 = true;
		
		boolean result1 = age1 > 19 && gender1=='w' && mCheck1;
		
		if(result1) {
			System.out.println("메시지를 보냅니다.");
		}else {
			System.out.println("메시지를 보내지 않습니다.");
		}
	}

}
