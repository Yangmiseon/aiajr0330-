package Ex;

public class Overriding {

	public static void main(String[] args) {
		
		//다형성 : 상위클래스 타입의 참조 변수에 하위 클래스의 인스턴스를 참조
		Speaker sp = new BaseEnSpeaker();
		//참조변수sp= BaseEnSpeaker의 멤버중
		 //>>스피커가 가지는 멤버만 사용한다.
		sp.showCurrentState();
		sp.setBaseRate(100);
		//여기까지가 다형성.
		

		System.out.println("---------------------------------------------");
		BaseEnSpeaker bs=new BaseEnSpeaker();
		bs.setVolume(10);
		bs.setBaseRate(20);
		
		bs.showCurrentState();
		
		System.out.println(bs);//toString 메소드 호출
	}

}
/*결과
볼륨크기:10
베이스 크기 :20
베이스 스피커
*/