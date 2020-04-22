package PhoneBookVer_1;


/*Version 0.1 전화번호 관리 프로그램. 
PhoneInfor 라는 이름의 클래스를 정의해 보자. 
클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 
저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
• 이름            name              String
• 전화번호       phoneNumber     String
• 생년월일       birthday            String 

단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
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
			System.out.println("================= ");
//			if(this.birthday == null) {
//				System.out.println("생일 : 입력값이 없습니다");
//			}else {
//			System.out.println("생       일 : "+this.birthday);
//			
//			}1번일때는 이렇게 처리
		}
		
}/*1. 변수 선언
 	2. 쇼인포 볼 수 있는거 만들고
 	3. 생성자 만들기
 	4. 새로운 클래스 메인 만들기
 	*/
