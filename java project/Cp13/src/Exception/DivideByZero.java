package Exception;


//ArithmeticException예외발생 후 예외 처리>>0으로 나누었을때 발생하는 에러 타입
public class DivideByZero {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		
//		int num1 = 10;
//		int num2 = 0;
//		
//		int divide = num1/num2;
//		
//		System.out.println(divide);
//	} 이렇게 하면 예외 발생
	
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub

	
	int num1 = 10;
	int num2 = 0;
	
	try {
		//예외발생지점
		int divide = num1/num2;//num2에서 예외 발생 그러면 밑에 출력실행안하고 캐치문으로 들어가서 실행
		//나누기가 정상적으로 되었을때 출력이 되어야 하기 때문에 트라이 캐치문안으로 들어가야함
		System.out.println("연산의 결과는 : "+divide);
		
	} catch(ArithmeticException e) {
		System.out.println("0으로 나눌수 없습니다.");
		System.out.println(e.getMessage());
		e.printStackTrace();//어떤 오류인지 보고 싶을때
		
		return;
	} finally {//finally 블록은 무조건 실행된다!
	
		System.out.println("finally 영역 실행");
		}
		System.out.println("프로그램을 종료합니다");
	
	
	
	
} 
	

}
