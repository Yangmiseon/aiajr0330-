package Ver5;

import java.util.InputMismatchException;

public class PhoneBookMain {

	public static void main(String[] args) {
		//폰인포 타입의 100개짜리 배열로 정의해두고 시작
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
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
			case MenuNum.INSERT:
				manager.createInfo();
				break;
			case MenuNum.SEARCH:
				manager.showInfo();
				break;
			case MenuNum.DELETE:
				manager.deleteInfo();
				break;
			case MenuNum.EDIT:
				manager.editInfo();
				break;
			case MenuNum.PRINT_ALL:
				manager.showAllInfo();
				break;
			case MenuNum.EXIT:
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
