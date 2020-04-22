package PBVer_3;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneBookManager manager = new PhoneBookManager();
		PhoneInfor info = null;
		
		while (true) {
			
			info = manager.createInfo();
			info.showInfo();
		}
				

	}
	

}

