package phoneBook;

import java.util.Scanner;

public class PhoneInfor {

	

		String name;
		String phoneNumber;
		String birthday;
		
		void phoneSave(String myName, String number, String day) {
			name = myName;
			phoneNumber = number;
			birthday = day;
		
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
			
			Scanner keyboard=new Scanner(System.in);
			
			
			System.out.print("당신의 이름을 입력하세요 ");
			String name1=keyboard.nextLine();
			
			System.out.println("안녕하세요 "+name1+'님');
			System.out.print("전화번호는 무엇입니까? ");
			
			
			String phoneNumber1=keyboard.nextLine();
			System.out.println("생일을 입력해주세요");
			
		
			System.out.println(p1.toString(name1,phoneNumber1));
			//System.out.println(p1.toString1(birthday1);
			
	}

}
