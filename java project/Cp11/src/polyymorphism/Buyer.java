package polyymorphism;

public class Buyer {
	
	int money;		  //구매자의 보유금액
	int bonusPoint; //구매자의 보유포인트
	
	Product[] item ; //구매시에 담을 제품배열
	int numOfProduct = 0; //구매 제품 개수
	
	Buyer(){
		
		this.money = 1000;
		this.bonusPoint = 0;
		this.item = new Product[10];
		this.numOfProduct =0;
	}
//상속관계가아니라면 개별적으로 티비받아 구매 컴받아구매 이런식으로 해야함.
//제품들이 늘어나면 메서드도 늘어나야함. 확장의 문제가 생김
//상속의 관계로만들어 다형성을 이용.
//	void buy (Tv tv) {	
//	}
//	void buy (Computer com) {	
//	}
//	void buy (Audio aud) {	
//	}
	
	void buy (Product p) {	
		
		//구매 상품금액과 나의 보유금액 비교해서 구매여부 처리
		if(money < p.price) {
			System.out.println("잔액이 부족합니다. 구매할 수 없습니다.");
			return;
		}
		
		//구매처리-돈을 지불했다. 내돈은- 포인트는+
		this.money -= p.price; //보유한 금액-제품의 금액
		this.bonusPoint += p.bonusPoint; //제품을 구매함으로써 얻은 포인트추가
		item[numOfProduct++] = p;
		//numOfProduct++;
		
		
		System.out.println(p + "를 구매하셨습니다.");
				
	}
	//구매내역 출력>>배열참조
	void summary() {
		int sum = 0; //구매 제품의 총액.지역변수니까 여기서 바로 초기화
		int points = 0; //구매한 제품들의 포인트 총합
		
		String itemList=" "; //구매제품의 이름 목록
		
		for(int i=0; i<numOfProduct; i++) {
			itemList += item[i] + ", "; //아이템리스트 더하기 (아이템[i]+"")
			sum += item[i].price;
			points += item[i].bonusPoint;
			
		}
		
		System.out.println("구매목록 ==================");
		System.out.println("구매하신 제품은");
		System.out.println(itemList+"입니다.");
		System.out.println("구매하신 제품들의 총 금액은 "+sum+"입니다.");
		System.out.println("구매하신 제품들의 적립 포인트는 : "+points +"점 입니다.");

	}
	
	
	
}
