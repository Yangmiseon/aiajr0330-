package abstractInterface;


/*추상클래스 만들기
*/
public abstract class Friend {
	
	String name;				//친구 이름
	String phoneNum;	//친구의 전화번호
	String addr;				//친구의 주소
	
	Friend(String name,	String phoneNum, String addr){
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
	}
	
	void showBasicInfo() {//상속하게 되면 기본으로 가져가게됨
		System.out.println("이름 : "+ this.name);
		System.out.println("전화번호 : "+ this.phoneNum);
		System.out.println("주소 : "+ this.addr);

	}
	
	 //상속의 목적으로 오버라이딩하기
	// 기본데이타와  하위 클래스의 데이터를 출력하도록 오버라이딩한다.
//	void showData() {
//	}
	//추상 메서드 생성
	//매개변수안받고 보이드로 처리 > 매서드의 성격이 다 나옴
	abstract void showData();
	
	
	

}
