package PhoneBookVer_3;


/*"프로그램 사용자로부터 데이터 입력"

프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이핵심.
단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
키보드로부터 데이터 입력 
↓
입력 받은 데이터로 인스턴스 생성
↓
생성된 인스턴스의 메소드 호출
*/

public class PhoneInfor {
		//변수선언
		//private : 변수의 직접참조를 막는다. 정보은닉. 메인페이지에 설명써둠
		private String name;  //친구의 이름
		private String phoneNumber;  //친구의 전화번호
		private String birthday;  //친구의 생일
		
		//생성자 : 초기화목적 >>생성자이름은 클래스이름과 같게해준다.
		PhoneInfor(String name, String phoneNumber, String birthday) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.birthday = birthday;
		}
		
		//생일은 저장할수도 안할수도
		PhoneInfor(String name, String phoneNumber) {
//			this.name = name;
//			this.phoneNumber = phoneNumber;
//			this(name, phoneNumber, null);1번
			this(name, phoneNumber, "입력값없음");//2번
			
		}
		
		//출력가능메서드
		void showInfo() {
			System.out.println("이      름 : "+this.name);
			System.out.println("전화번호 : "+this.phoneNumber);
			System.out.println("생       일 : "+this.birthday);//2번일때
			
//			if(this.birthday == null) {
//				System.out.println("생일 : 입력값이 없습니다");
//			}else {
			
//			System.out.println("생       일 : "+this.birthday);
//			
//			}1번일때는 이렇게 처리
		}
		
		//변수의 name을 직접 참조할 수 없으니 기능을 만들어줌
		//name속성 값과 전달받은 문자열을 비교해서 결과 반환
		boolean checkName(String name) {
			return this.name.equals(name);
							
				}
		
}
