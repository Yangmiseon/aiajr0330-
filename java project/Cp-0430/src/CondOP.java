
public class CondOP {

	public static void main(String[] args) {
		//숫자 두개를 받는다.
		int num1 =100, num2 = 50;
		
		//큰수, 차이 값을 저장 하는 변수
		
		int bigNum, diffNum; //큰 숫자, 차이가 나는 숫자.
		
		//큰수 구하기
		bigNum = (num1 > num2)? num1 : num2;
		//참이면 big = num1, 거짓이면 big = num2
		
		//두수의 차이 구하기 
		diffNum = (num1>num2)?num1-num2 : num2-num1;
		//1:2 일때 참이면 1, 거짓이면2
		
		System.out.println("큰수:" + bigNum);
		System.out.println("두 수의 차이" + diffNum);
	}

}
