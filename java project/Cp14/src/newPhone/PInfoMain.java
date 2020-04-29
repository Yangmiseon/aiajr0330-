package newPhone;

public class PInfoMain {

	public static void main(String[] args) {
		
		PInfoManager manager = new PInfoManager();
		PInfo info = null;
		
		while(true) {
		info = manager.create();
		manager.addInfo(info);
		manager.addInfo();
		manager.showAll();
		info.show();
		
		
		}

	}
		

}
