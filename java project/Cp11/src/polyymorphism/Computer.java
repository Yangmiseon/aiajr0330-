package polyymorphism;

public class Computer extends Product {

	Computer(int price) {
		super(price);
	}

	@Override
	public String toString() {
		return "Computer";
	}

	void progamming() {
		System.out.println("프로그래밍한다.");
	}
	
	
}
