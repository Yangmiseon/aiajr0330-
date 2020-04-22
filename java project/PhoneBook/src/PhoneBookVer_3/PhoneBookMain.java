package PhoneBookVer_3;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		//폰북매니저 객체 필요
		PhoneBookManager manager = new PhoneBookManager();
		
		
		
		Scanner sc = new Scanner(System.in);	
		
		//반복
		while(true){
			
		Menu.showMenu();
		
		
		int selectNum = sc.nextInt();
		
		//비워주는 용도
		sc.nextLine();
		
		switch(selectNum) {
		case 1://사용자의 입력 데이터를 인스턴스 생성
//			PhoneInfor info = manager.createInstanse();
			//정보를 배열에 저장
//			manager.addInfo(info);
			manager.addInfo();
			break;
			
		case 2://이름으로 검색
			manager.searchInfo();
			break;
			
		case 3://이름으로 검색 후 삭제
			manager.deleteInfo();
			break;
			
		case 4://전체 리스트 출력 >> 저장된 개수. 전체개수아님
			manager.showAllData();
			break;
			
		case 5:
			System.exit(0);
				return;
		
			
		}
			
//		//사용자의 입력 데이터를 인스턴스 생성
//		info = manager.createInstanse();
//		//정보를 배열에 저장
//		manager.addInfo(info);
//		//전체 리스트 출력 >> 저장된 개수. 전체개수아님
//		manager.showAllData();
//		
//		manager.searchInfo();
//		//이름으로 검색 후 삭제
//		manager.deleteInfo();
//		manager.showAllData();
		
		
		System.out.println("===========");
		
		for(int i =0; i<manager.cnt; i++) {
			manager.pBooks[i].showInfo();
		}
		
		
		System.out.println("===========");

	}

}
}