package fruit;

public class FruitBuyer {

	
		// 속성 : 변수
		//		보유한 나의 돈
		// 		사과의 개수
		int myMoney = 10000;
		int numOfApple = 0;		
		
		//구매 기능
		//1. 셀러 찾기 받기
		//2. 얼마를 지출해서 쓸지
		//3. 셀러에게 돈을 주고 판매 요청
		//4. 사과의 개수를 받은 사과의 개수만큼 증가시킨다.
		//5. 지출한 돈은 나의 돈에서 차감한다.
		//참조 변수 : 
	 void buyApple(FruitSeller seller, int money) {
			
			//구매한 사과의 개수
			
			int num = seller.saleApple(money);
			numOfApple += num;
			myMoney -= money;
		
	}


	

}
