package phoneBook;


public class PhoneInfor {

	

		String name;
		String phoneNumber;
		String birthday;
		
		//이름, 전화번호 생일 모두 입력 생성자
		void PhoneInfor(String myName, String number, String day) {
			this.name = myName;
			this.phoneNumber = number;
			this.birthday = day;
		}
		//이름, 전화번호 입력 생성자
		void PhoneInfor(String myName, String number) {
			this.name = myName;
			this.phoneNumber = number;
		}
		
		public String toString(String name1, String phoneNumber1) {
			
			return "제 이름은 "+ this.name+"이고, 전화번호는 "
						+this.phoneNumber+"입니다.";
		}
		
		public String toString1(String birthday1) {
			
			return "제 생일은" +this.birthday+" 입니다.";
		}
		
		
		
		public static void main(String[] args) {
	
			PhoneInfor p1 = new PhoneInfor();
			java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.println("숫자를 입력하세요\n");
			p1.name = ' ';
			p1.phoneNumber = ' ';
			p1.birthday = ' ';
			PhoneInfor p2 = new PhoneInfor();
			p2.name = ' ';
			p2.phoneNumber = ' ';
			
	}

		
		
}
