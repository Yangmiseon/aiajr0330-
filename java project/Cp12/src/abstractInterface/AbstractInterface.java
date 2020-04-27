package abstractInterface;

public class AbstractInterface {

	public static void main(String[] args) {
		
		//PersonalNumberStorage storage
		PesonalNumber storage = new PersonalNumberStorageImpl(100);
		storage.addPersonalInfo("202020-1234567", "didaltjs");
		storage.addPersonalInfo("202010-1368547", "박지성");
		
		//특적 데이터를 가지고 출력하는 코드를 만들 수 있다.
		System.out.println(storage.searchName("202020-1234567"));
		System.out.println(storage.searchName("202010-1368547"));

	}

	
}
