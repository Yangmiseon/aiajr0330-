package polyymorphism;

public class ScmMain {

	public static void main(String[] args) {
		// 상속관계에서 다형성
		//상위클래스 타입의 참조변수 = 하위클래스의 인스턴스
		//프로덕트의 멤버들을 출력가능
		//참조하고 있는 티비변수가 오버라이딩하고 있어서 티비가 보인다.
		Product p = new Tv(100); //이게 다형성
		//System.out.println(p);
		
		
		Tv tv = new Tv(10);
		Computer com = new Computer(20);
		Audio aud = new Audio(30);
		
		
		
		//제품들이 많아질때면 반복문을 이용.>> 제품들을 하나로 다루면좋겠음 >> 배열
		//같은 타입의 변수들을 묶어 사용
		//상위클래스로 형변환
		//프로덕트로 티비 컴 오디오의 주소값을가지게됨
		Product p1 = tv; //다형성의 형변환, (product)생략가능
		Product p2 = com;
		Product p3 = aud;
		
	
		
		//상위 클래스 타입의 배열 생성
		//프로덕트 타입임에도 티비컴오디오가 들어갈수있음
		Product[] products = new Product[3];
		products[0] = new Tv(100);
		products[1] = new Computer(600);
		products[2] = new Audio(100);
		
		//명시적인형변환. 상위 타입의 변수에서 하위타입의 변수로 바꿔줄때 명시적형변환
		//티비자리컴퓨터가오고 디스클레이를 프로그래밍으로 바꿔주면 에러표시는 없지만 실행하면 에러남
		//변수가 형변환가능한지 확인하는것이 instanceof연산자이다.
		
		
		//전달하는 배열에 컴퓨터가 있다면 프로그래밍을 하겠다.
		//형변환여부확인 후 형변환.
		for(int i=0; i<products.length; i++) {
			if(products[i] instanceof Computer) {
				((Computer)products[i]).progamming();
				}
			
		}
		
		System.out.println("==========================");
			int sum = tv.price+com.price+aud.price;
		
		int sumOfPrice = 0;
		int sumOfPoint = 0;
		
//		for(int i =0; i<products.length; i++) {
//			System.out.println(products[i]);//10번줄이랑 같은거
//			sumOfPrice+= products[i].price;
//			sumOfPoint+= products[i].bonusPoint;
//		}
		
		
		
//		System.out.println("전체 제품의 가격의 합은 : " + sumOfPrice);
//		System.out.println("전체 제품의 포인트의 합은 : " + sumOfPoint);
				
		
		//구매자가 제품을 구매하는 시뮬레이션
		//구매자 생성
		Buyer buyer = new Buyer();
		
//		//제품들 생성
		Tv product1 = new Tv(300);
		Computer product2 = new Computer(600);
		Audio product3 = new Audio(300);
//		
		//Tv구매
		buyer.buy(product1);
		//Computer구매
		buyer.buy(product2);
		//Audio구매
		buyer.buy(product3);
//		
//		System.out.println("현재 보유 금액 : " + buyer.money);
//		System.out.println("현재 포인트 : "+ buyer.bonusPoint);
		
		
		buyer.summary();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
