package Friend;

	/*
 	친구의 정보를 저장하기 위한 클래스
 	상속을 목적으로 기본 클래스 정의
 	기본 속성과 기능을 구성  
*/
public abstract class Friend implements Info {//Friend가 abstract가 되는 것임

	
	String name;		// 친구의 이름
	String phoneNum;	// 친구의 전화번호
	String addr;		// 친구의 주소
	
	// 생성자
	Friend(String name, String phoneNum, String addr){
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
	}
	
	void showBasicInfo() {
		System.out.println("이름 : "+ this.name);
		System.out.println("전화 : " + this.phoneNum);
		System.out.println("주소 : " + this.addr);
	}
	
	// 상속의 목적으로 오버라이딩 할 메서드
	// 기본 데이터와 하위클래스의 데이터를 출력하도록 오버라이딩 한다.
//	void  showData() {
//		
//	}
//	abstract void showData();
}
