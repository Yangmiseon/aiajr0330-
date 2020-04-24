package Friend;

public class FriendMain {

	public static void main(String[] args) {
		
		FriendInfoHandler handler = new FriendInfoHandler(10);
		
		while (true) {
			System.out.println("===메뉴를 선택하세요===");
			System.out.println("1. 고교친구 저장");
			System.out.println("2. 대학친구 저장");
			System.out.println("3. 친구 기본 정보 출력");
			System.out.println("4. 친구 전체 정보 출력");
			System.out.println("5. 종료");
			System.out.println("===============");
			
			int choice = handler.kb.nextInt();
			
			handler.kb.nextLine();//앞의 버퍼 클리어>패스되지 않도록.
			
			
			//값을 가지고 스위치 케이스 문
			
			switch (choice) {
			
			case 1:  case 2:
				handler.addFriend(choice);
				break;
				
			case 3:
				handler.showAllSimpleData();
				break;
				
				
			case 4:
				handler.showAllData();
				break;
				
			case 5:
				System.out.println("종료!");
				return;//메인메소드를 종료 브레이크 필요없음.
				
			}


		}
		

	}

}
