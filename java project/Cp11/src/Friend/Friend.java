package Friend;


/*이클래스의 목적 : 친구의 정보를 저장하기 위한 클래스
//상속을 목적으로 기본 클래스 정의
 * 기본 속성과 기능을 구성
 * 친구정보(이름, 전번, 생일, 주소, 이메일, 직장,학교,학년, 반)
 * 친구정보-   대학친구   (이름, 전번, 주소, 이메일, 전공, 학년)
 * 		   	 -고등학교 친구(이름, 전번, 주소, 직장)
 * 공통된 것들을 묶어 상위개념과 하위개념으로 나누어 상속을 만들수있다.
 * 친구는 친구다 친구를 상위개념으로 볼수있고, 상위클래스로 출력해볼수있다.
 * 친구는 공통으로 들어가는 이름, 전버번, 주소를 넣어야 한다.기본기능.
 * 친구정보를 배열로 만들거임.
*/
public class Friend {
	
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
	void showData() {
		
	}
	
	
	

}
