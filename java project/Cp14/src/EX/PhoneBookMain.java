package EX;

import java.util.InputMismatchException;

public class PhoneBookMain {

	public static void main(String[] args) {
		//폰인포 타입의 100개짜리 배열로 정의해두고 시작
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while(true) {
				
			Menu.showMenu();
			int select = 0;
			try {
			select = manager.kb.nextInt();
			if(!(select>=MenuNum.INSERT && select<=MenuNum.EXIT)) {
				BadNumberException e = new BadNumberException("메뉴 범위를 벗어나는 범위입니다.\n 확인후 입력해 주세요.");
				//System.out.println("정상적인 메뉴 선택이 아닙니다.\n 메뉴를 다시 선택해 주세요.");
				throw e;//강제예외발생
			//continue;
			}
			
			}catch (InputMismatchException e){
				System.out.println("정상적인 입력이 아닙니다. 다시 선택해 주세요.");
				manager.kb.nextLine();//버퍼방지
				continue;
			}catch (BadNumberException e){//강제예외발생시 처리해주는거
				System.out.println("정상적인 입력이 아닙니다. 다시 선택해 주세요.");
				manager.kb.nextLine();//버퍼방지
				
				continue;
			}catch (Exception e){
				System.out.println("정상적인 입력이 아닙니다. 다시 선택해 주세요.");
				manager.kb.nextLine();//버퍼방지
				
				continue;
			}finally {//이렇게해주면 다 비워줌
			manager.kb.nextLine();
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
		}
		}
	}


