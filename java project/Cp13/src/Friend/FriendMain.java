package Friend;

import java.util.InputMismatchException;

public class FriendMain {
public static void main(String[] args) {
		
		FriendInfoHandler handler = FriendInfoHandler.getInstance();
		
		while(true) {
			System.out.println("=== 메뉴를 선택해 주세요 =========");
			System.out.println(" "+Menu.INSERT_HIGH+" . 고교 친구 저장");
			System.out.println(" "+Menu.INSERT_UNIV+" . 대학 친구 저장");
			System.out.println(" "+Menu.PRINT_BASIC+" . 기본 정보 출력");
			System.out.println(" "+Menu.PTINT_ALL+" . 전체 정보 출력");
			System.out.println(" "+Menu.EXIT+" . 종료");
			System.out.println("=============================");
			
			int choice=0;
			try {
				 choice =  handler.kb.nextInt();
				 //비정상적인 처리가 되면 InputMismatchException에 전달하여 밑에 캐치에서 처리
				 //
			}catch(InputMismatchException e) {
				System.out.println("정상적인 입력이 아닙니다. 다시 선택해 주세요.");
				handler.kb.nextLine();
				continue;
			}
			
			
			
			handler.kb.nextLine(); // 앞의 버퍼 클리어
			
			switch(choice) {
			case Menu.INSERT_HIGH: case Menu.INSERT_UNIV:
				handler.addFriend(choice);
				break;
			case Menu.PRINT_BASIC:
				handler.showAllSimpleData();
				break;
			case Menu.PTINT_ALL:
				handler.showAllData();
				break;
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
			
		}

}
}
