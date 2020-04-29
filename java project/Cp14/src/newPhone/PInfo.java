package newPhone;

public class PInfo {
	
	private String name;
	private String pNum;
	private String add;
	private String birthday;
	
	PInfo(String name, String pNum, String add, String birthday){
		this.name = name;
		this.pNum = pNum;
		this.add = add;
		this.birthday = birthday;
	}
	
	void show() {
		System.out.println("이름 : "+this.name);
		System.out.println("전화번호 : "+this.pNum);
		System.out.println("주소 : "+this.add);
		System.out.println("생일 : "+this.birthday);
		
	}
	
	

}
