package newPhone;

public class PInfoMain {

	public static void main(String[] args) {
		
		PInfoManager manager = new PInfoManager();
		PInfo info = null;
		
		while(true) {
		info = manager.create();
		manager.showAll();
		
		
		
		
		for(int i =0; i<manager.cnt; i++) {
			manager.pBooks[i].show();
			info.show();
			
		}
		
		
		
		
		}
		
			
			}
	}
		

