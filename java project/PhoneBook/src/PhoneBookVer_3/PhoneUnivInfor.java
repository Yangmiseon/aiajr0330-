package PhoneBookVer_3;

public class PhoneUnivInfor extends PhoneInfor {
	
	String major; //친구의 전공

	String year; // 친구의 학년
	
	public PhoneUnivInfor(String name, String phoneNumber, String birthday, String major, String year) {
		super(name, phoneNumber, birthday);
		this.major = major;
		this.year = year;
	}

	@Override
	void showInfo() {
	
		super.showInfo();//상속한거 출력
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+ year);
	}
	
	

	

}
