package EX;

//PhoneInfo 클래스를 상속해서 새로운 클래스를 정의
public class PhoneUnivInfor extends PhoneInfo{

	String major;			//친구의 전공
	String grade;			//친구의 학년
	
	PhoneUnivInfor(String name, String phoneNumber, String addr, String email,String major, String grade) {
		super(name, phoneNumber, addr, email);
		this.grade = grade;
		this.major = major;
	}

	@Override
	public void showAllInfo() {
		super.showBasicInfo();
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+grade);
	}
	
	

}
