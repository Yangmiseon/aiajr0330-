package PBVer_2;

public class PhoneInfor {
	
	private String name;
	private String phoneNumber;
	private String birthday;
	
	
	PhoneInfor(String name, String phoneNumber, String birthday){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		}
	
	PhoneInfor(String name, String phoneNumber){
		this(name, phoneNumber,"입력값없음");
		}
	
	
	void showInfo() {
		System.out.println("이름 : "+this.name);
		System.out.println("전화번호 : "+this.phoneNumber);
		System.out.println("생일 : "+this.birthday);
		System.out.println("---------------------------------");
		}

}

