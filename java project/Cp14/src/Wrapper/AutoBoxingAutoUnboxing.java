package Wrapper;

public class AutoBoxingAutoUnboxing {

	public static void main(String[] args) {


		Integer iValue = 10; //new Integer(10); Auto Boxing
		Double dValue = 3.14; //new Double(3.14); Auto Boxing
		System.out.println(iValue.toString());
		System.out.println(dValue.toString());
		//System.out.println(iValue); 이렇게만 해도 되지만 진짜 변수가 맞는지 궁금해! 할땐 투스트링
		
		int num1 = iValue; //Auto unBoxing처리가 된거다.
		double num2 = dValue;
		System.out.println(num1);
		System.out.println(num2);
	}

}
