package abstractInterface;

//class앞에 abstract키워드가 있는 경우 이 클래스는 추상클래스임을 의미 한다.
//추상클래스는 미완성된 클래스를 의미한다.
//class의 멤버중 추상 메서드를 하나라도 포함하고 있는 경우 > 추상클래스
//추상 메서드 > 미완성된 메서드.
public abstract class Player {
	
	int currentPos;
	
	Player(){
		
	}

	
	//추상 메서드 : abstract 반환형 메서드이름(매개변수); <<이런형식으로 작성
	abstract void play(int pos);
	
	//추상메서드
	abstract void stop();

	void play() {
		play(currentPos);
	}
//Player를 상속하면 play와 stop을 오버라이딩을 통해 완성시킴 그때 인스턴스생성이 가능해짐
}
