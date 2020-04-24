package PhoneBookVer_3;

public class PhoneCompaanyInfor extends PhoneInfor { //회사명
	
	String company; //회사명

	public PhoneCompaanyInfor(String name, String phoneNumber, String birthday, String company) {
		super(name, phoneNumber, birthday);
		this.company = company;
	}

	@Override
	void showInfo() {
		
		super.showInfo();
		System.out.println("회사명 : "+company);
	}



}
