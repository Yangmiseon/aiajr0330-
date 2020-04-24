package polyymorphism;

public class Tv extends Product{
	
//상속했을때는 생성자 만들어서 초기화하기. 
	Tv(int price) {
		super(price);
	}
	
	//프로덕트를 불러도 티비가 나옴. 오버라이딩중이어서
	public String toString() {
		return "Tv";
	}
	

	void display() {
		System.out.println("Tv를 시청합니다.");
	}
	
}
