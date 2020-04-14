package A200414;

public class Method1 {

	public static void main(String[] args) {
		//String[] args < 매개 변수
		//메서드의 위치는 class블록에 위치하고 정의함.
		//메서드를 사용하기 위해서는 인스턴스(객체)를 생성한 후 사용가능
		//메서드 코드를 메모리에 로드한다라는 개념
		//인스턴스 생성(객체 생성)
		 MyMath math = new MyMath();//객체 만드는 방식 > 
		 //new만드는 과정이 메모리가 있다고 하면  MyMath 기반으로 하는 메모리에 담는다.
		 //주소값이 0x00이라는 주소값을 가지게됨
		 //메모리 공간에 집합처럼 만들어 지게 되고 주소값이 뉴로 들어감
		 //그 주소값을 참소변수MyMath math <여기에 저장
		 //math만 알고 있으면 객체안의 add메서드를 찾아가서 사용할수 있음
		 //코드의 중복을 막을 수 있음.
		 
		 
		 long result = math.add(10, 100); //이렇게 넣어주면 메모리 공간에 있던 add를 찾아 넣어준다.
		 System.out.println(result);
		 System.out.println(math.add(10000000, 200000000000000L));
	}
	int add() {
		return 10; //이것도 메서드. 메서드의 선언부. 
		
	}
}
