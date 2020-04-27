package abstractInterface;

public class PersonalNumInfo {
	
	private String name;
	private String number;
	
	//생성자 통한 초기화
	PersonalNumInfo(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	//데이터 저장의 목적
	String getName() {
		return name;
	}

	String getNumber() {
		return number;
	}
}
