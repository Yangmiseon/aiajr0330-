package tv;

public class Tvmain {

	public static void main(String[] args) {

		// Tv 인스턴스 생성
		Tv tv = new Tv();
		
		System.out.println("--------------------------");
		System.out.println("Tv의 속성값: 인스턴스 생성"
				+ "");
		System.out.println("Tv의 color: "+ tv.color);
		System.out.println("Tv의 전원: "+ tv.power);
		System.out.println("Tv의 채널: "+ tv.channel);

		//채널값을 직접넣을 수도 있음
		
		tv.channel = 11;
		System.out.println("Tv의 채널: "+ tv.channel);

		tv.channelUp();
		System.out.println("Tv의 채널: "+ tv.channel);

		tv.channerChange
		
		(100);
		System.out.println("Tv의 채널: "+ tv.channel);

	}

}
