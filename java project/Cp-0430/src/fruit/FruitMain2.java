package fruit;

public class FruitMain2 {

	public static void main(String[] args) {
		// 바이어가 셀러1한테도 사고 2한테도 사고, 데이터변동확인
		
		
		
		//seller1 객체 생성
		 FruitSeller seller1 = new FruitSeller(30, 0, 1000);
		
		 
		 //seller2 객체 생성
		 FruitSeller seller2 = new FruitSeller(20, 0, 1500);

		 
		 //seller3 객체 생성
		 FruitSeller seller3 = new FruitSeller();

		 
		 
		 //buyer 객체 생성		 FruitBuyer buyer = new FruitBuyer();이렇게 하면 5000원가진 바이어가 생성되는거임

		 FruitBuyer buyer = new FruitBuyer(10000, 0);
		 
		 //seller1 에게 구매
		 buyer.buyApple(seller1, 3000);
		 
		 System.out.println("판매자 1의 현황");
		 seller1.showResult();
		 
		 System.out.println("구매자의 현황");
		 buyer.showResult1();
		 
		 
		 //seller2 에게 구매
		 buyer.buyApple(seller2, 3000);
		 
		 System.out.println("판매자 2의 현황");
		 seller2.showResult();
		 
		 System.out.println("구매자의 현황");
		 buyer.showResult1();
		 
		 
		 //seller3 에게 구매
		 buyer.buyApple(seller3, 4000);
		 
		 System.out.println("판매자 3의 현황");
		 seller3.showResult();
		 
		 System.out.println("구매자의 현황");
		 buyer.showResult1();
		 
	}

}
