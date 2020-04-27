package abstractInterface;

//약속한 메서드를 구현해야하는 것을 표현
public class PersonalNumberStorageImpl implements PersonalNumberStorage {

	//사용자 이름과 주민번호를 입력하는 기능. 저장하기위한 배열
	PersonalNumInfo[] perArr;
	int numOfperInfo;
	
	//생성자 통해서 초기화
	PersonalNumberStorageImpl(int num){
		perArr = new PersonalNumInfo[num];
		numOfperInfo = 0;
	}
	
	@Override//이름과 주민번호 저장
	public void addPersonalInfo(String perNum, String name) {

		perArr[numOfperInfo] = new PersonalNumInfo(name, perNum);
		numOfperInfo++;
	}

	@Override//주민번호 기반으로 찾아서 출력
	public String searchName(String perNum) {
		
		for(int i=0; i<numOfperInfo; i++) {
			if(perArr[i].getNumber().equals(perNum)) {
				return perArr[i].getName();
			}
		}

		return null;
	}

}
