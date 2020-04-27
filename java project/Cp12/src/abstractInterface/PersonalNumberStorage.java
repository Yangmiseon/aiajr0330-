package abstractInterface;


//요구사항: 추가해주는거, 주민번호이용해서 찾는거
public abstract class PersonalNumberStorage {
	
	public abstract void addPersonalInfo(String perNum, String name);
	public abstract String searchName(String perNum);
}
