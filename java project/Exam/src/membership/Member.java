package membership;


//회원 정보를 저장하기 위한 클래스 생성
public class Member {
		
		//static안됨. 변수를 하나씩 참조한다는의미가되니까!
		//인스턴스변수
		String memberId;
		String memberName;
		String memberEmail;
		
		//생성자 : 생성자 이름은 클래스로 >> 초기화 목적
		//this는 나자신을 가리키는 참조변수. 변수들끼리 이름이 같으니까 this를 사용하여 알려줌.
		Member(String memberId, String memberName, String memberEmail){//지역변수
			this.memberId = memberId;
			this.memberName = memberName;
			this.memberEmail = memberEmail;
		}
		
		void showInfo() {//this를 안써도 되지만 정확도를 높여주기 위해 사용하는 것이 좋음
			System.out.println("아이디 : "+this.memberId);
			System.out.println("이   름 : "+this.memberName);
			System.out.println("이메일 : "+this.memberEmail);

		}

		@Override//디버깅용
		public String toString() {
			return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberEmail=" + memberEmail + "]";
		}
}
