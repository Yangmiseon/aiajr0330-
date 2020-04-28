package Ver5;

import java.util.InputMismatchException;

public class PhoneBookMain {

	public static void main(String[] args) {
		//폰인포 타입의 100개짜리 배열로 정의해두고 시작
		PhoneBookManager manager = new PhoneBookManager(100);
		
		while(true) {
			try {	
			Menu.showMenu();
			int select = manager.kb.nextInt();
			manager.kb.nextLine();
			
			if(!(select>0 && select<7)) {
				System.out.println("정상적인 메뉴 선택이 아닙니다.\n 메뉴를 다시 선택해 주세요.");
			continue;
			}
			switch(select) {
			case 1:
				manager.createInfo();
				break;
			case 2:
				manager.showInfo();
				break;
			case 3:
				manager.deleteInfo();
				break;
			case 4:
				manager.editInfo();
				break;
			case 5:
				manager.showAllInfo();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}catch (InputMismatchException e){
			System.out.println("정상적인 입력이 아닙니다. 다시 선택해 주세요.");
			manager.kb.nextLine();
			continue;
		}
		}
	}

}
