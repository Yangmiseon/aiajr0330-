package phone;

public class PhoneInfor {

	// 변수 선언
		String pbName;
		String pbPhoneNumber;
		String pbBirthday;
		
		//생성자 : 이름, 전화번호, 생일 저장
		public PhoneInfor(String Name, String PhoneNumber, String Birthday){
			this.pbName = Name;
			this.pbPhoneNumber = PhoneNumber;
			this.pbBirthday = Birthday;
		}
		//생성자:이름,전화번호 저장
		public PhoneInfor(String Name, String PhoneNumber){
			this.pbName = Name;
			this.pbPhoneNumber = PhoneNumber;
		}
		
		public String toString() {
			
			return "제 이름은 "+ this.pbName+"이고, 전화번호는 "
			+this.pbPhoneNumber+"입니다.\n 생일은 "+this.pbBirthday+"입니다.";
		}
		
		
		
		public static void main(String[] args) {
		PhoneInfor pb = new PhoneInfor("양미선","01093602877","420");
		PhoneInfor pb1 = new PhoneInfor("양미","01084874898");
		System.out.println(pb);
		System.out.println(pb1);


		}
	}

	
