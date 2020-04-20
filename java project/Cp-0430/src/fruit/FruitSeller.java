package fruit;
/*작성자 : 양미선
 * 작성일 : 2020-04-17
 * 수정내용 : 변수의 명시적 초기화 변경, 현재 데이터 출력메서드 생성showResult()
 */
public class FruitSeller {
	
	// 속성 => 변수
	//    사과의 개수
	//    수입
	//    사과의 가격
	// 맴버 변수, 인스턴스 변수
//	int numOfApple = 20;	// 사과의 개수
//	int myMoney = 0;		// 수입
//	final int price = 1000;		// 사과의 가격
	
	//수정
	int numOfApple = 20;	// 사과의 개수
	int myMoney = 0;		// 수입
	final int APPLE_PRICE;		// 사과의 가격 상수니까 대문자.
	
	
	
	//생성자 - default가 아닌 내용이 있는 생성자
	FruitSeller(){//생성자는 이름이 같으니 매개 변수 혹은 개수, 타입에 따라 결정
//		numOfApple = 20;
//		myMoney = 0;
//		APPLE_PRICE = 1000;
		this(20,0,1000); //또다른 생성자를 호출. 변수 3개 여서 3개를 받을 수 있는 곳으로 감.
	}
	
	FruitSeller(int price){//이렇게도 표현가능함
		this(20,0,price); 
	}
	
	public FruitSeller(//소스>컨스트럭터>제네레이트
				int numOfApple, int myMoney, int aPPLE_PRICE) {//툴을 이용한 호출
		
		this.numOfApple = numOfApple;
		this.myMoney = myMoney;
		APPLE_PRICE = aPPLE_PRICE;
	}

//	FruitSeller(int num, int money, int price){//this가 가리키는곳
//		numOfApple = num;//파랑색은 인스턴스변수, 까망은 지역변수
//		myMoney = money;
//		APPLE_PRICE = price;
//	}
//	FruitSeller(int numOfApple, int myMoney, int price){
//		this.numOfApple =numOfApple; //앞뒤로 지역변수, 앞에는 heap영역으로 뒤에는stack 영역
//		this.myMoney = myMoney;//this를 붙여주면 파랑색으로 바뀌어 영역으로 구분이 됨
//		APPLE_PRICE = price;
//	}
//	
	
	
	
	// 판매 기능 : 메서드
	// 1. 돈을 받는다. --> 매개변수 int money
	// 2. 받은 돈의 사과의 개수를 구한다.
	// 3. 나의 사과 개수에서 반환해야하는 사과의 개수를 빼준다.
	// 4. 받은 금액은 나의 수입으로 더해준다.
	// 5. 사과의 개수를 반환한다. 
	//    --> 반환 데이터 int return 사과의 개수
	int saleApple(int money) {
		int num = money/APPLE_PRICE;
		//numOfApple = numOfApple - num;
		numOfApple -= num;
		myMoney += money;   // myMoney = myMoney + money
		return num;		
	}
	
	
	//지표 출력 매개 변수 없이 출력만.
	void showResult() {
		System.out.println("현재 보유금액 : "+myMoney+"이고, 현재 보유한 사과의 개수는 "+numOfApple+"개 입니다.");
	}
	
	
	
	
	
	
	
	
	
}
