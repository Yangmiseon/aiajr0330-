package A200414;

public class MethodDefAdd {
	
	public static void main(String[] args) {
		//static은 코드가 시작될때 가상머신이 그시점에 메모리가 올라감
		//프로그램이 시작할때 코드가 메모리에 올라감
		//붙이지 않은 메서드는 인스턴트를 만들어서 메모리에 올려줘야 함.
		System.out.println("프로그램 시작");
		
		hiEveryone(7, 110.5);
		hiEveryone(20, 162.3);
		hiEveryone(17, 186.3);
		hiEveryone(25, 152.1);
		hiEveryone(15,178.5);
		hiEveryone(19, 150.8);
		byEveryone();
		
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 "+age+"세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 "+age+"세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 "+age+"세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 "+age+"세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 "+age+"세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 "+age+"세 입니다.");
		
		System.out.println("프로그램 종료");
		
	}
	
	//인사말 출력, 나이값을 받아서 나이를 출력하는 메서드
	static void hiEveryone(int age, double height) {
		System.out.println("안녕하세요.");
		
		if(age<10) {
			return;
		}
		System.out.println("제 나이는 "+ age+"세 입니다.");
		System.out.println("저의 키는 "+ height+"cm 입니다.");
	}
	public static void byEveryone() {
		System.out.println("다음에 뵙겠습니다.");
		}
	
}
