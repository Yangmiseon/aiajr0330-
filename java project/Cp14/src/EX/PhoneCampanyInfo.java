package EX;

public class PhoneCampanyInfo extends PhoneInfo {
	
	String company; //회사이름
	String dept;		//부서이름
	String jop;			//직급

	public PhoneCampanyInfo(String name, String phoneNumber, String addr, 
			String email,String company,String dept,String jop) {
		super(name, phoneNumber, addr, email);
		this.company = company;
		this.dept = dept;
		this.jop = jop;
	}

	@Override
	public void showAllInfo() {
		super.showBasicInfo();
		System.out.println("회사이름 : "+company);
		System.out.println("부서이름 : "+dept);
		System.out.println("직급 : "+jop);
	}

}
