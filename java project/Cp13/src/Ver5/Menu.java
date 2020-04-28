package Ver5;

public class Menu {
	
	public static void showMenu() {
		//1번 입력, 2번 검색, 3번 삭제, 4번 수정, 5번 전체보기, 6번 종료
				//이패턴이 돌아야함
				//종료의 방법 - 메인메서드가 끝나면 끝return;
				//System.exit(0); 마지막이 끝나면 프로세스 종료
		System.out.println("===========");
		System.out.println("메뉴를 입력해주세요");
		System.out.println("1. 친구 정보 입력");
		System.out.println("2. 친구 정보 검색");
		System.out.println("3. 친구 정보 삭제");
		System.out.println("4. 친구 정보 수정");
		System.out.println("5. 친구 정보 전체보기");
		System.out.println("6. 종료");
		System.out.println("===========");
		
	}
	

}
