package fruit;

public class FruitSeller {

	
		// 속성>>변수로 표현
		//		사과의 개수
		//		수입
		//		사과의 가격
		//멤버 변수, 인스턴스 변수
		
		int numOfApple = 20; 	//사과의 개수
		int myMoney = 0; 		//income수입 
		final int price = 1000;  // 사과의 가격 ,사과가격이 바뀌면 안되니까 파이널!
		
		
		//판매 기능 : 메서드
		//1. 돈을 받는다. >>매개변수 돈을 표현해야 하니 int money로 표현
		//2. 받은 돈의 사과의 개수를 구한다.
		//3. 나의 사과 개수에서 반환해야 하는 사과의 개수를 빼준다.
		//4. 받은 금액은 나의 수입으로 더해준다.
		//5. 사과의 개수를 반환한다.
		//       >>반환 데이터 int return사과의 개수
	int saleApple (int money) {
		int num = money/price;
		numOfApple -= num;
		myMoney += money; //마이머니는 마이머니+머니
			
		return  num;
		}
		
	}


