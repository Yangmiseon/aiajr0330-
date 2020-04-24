package polyymorphism;

public class Audio extends Product {

	Audio(int price) {
		super(price);
	}

	@Override//쉬프트 알트 에스 : 변수없으니까 체크안하고 제네레이트
	public String toString() {
		return "Audio";
	}
	
	void music() {
		System.out.println("음악듣는다.");
	}

	

}
