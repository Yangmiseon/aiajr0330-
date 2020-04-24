package Friend;

//워크라는 변수를 가진 클래스 생성
public class HighFriend extends Friend{

	String work; //친구의 직업
	
	public HighFriend(String name, String phoneNum, String addr,String work) {
		super(name, phoneNum, addr);
		this.work = work;
	}

	@Override
	void showData() {
		showBasicInfo();//상속한거 먼저출력
		System.out.println("직업 : "+ work);//직접 참조로하지 앟아도 출력가능함.this안써도됨
		
	}

}
