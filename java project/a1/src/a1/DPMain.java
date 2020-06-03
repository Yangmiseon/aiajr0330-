package a1;

import java.util.Scanner;

public class DPMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while (true) {
			System.out.println("1.모든정보 출력 2.친구 정보 입력 3.친구 검색 \n4.친구정보 수정"
					+ "5.친구 정보 삭제 6.프로그램 종료");
			int select = sc.nextInt();
			switch(select) {
			case 1://모든 정보 출력
				DPManager.AllInfo();
				break;
			case 2:	//친구정보입력
				DPManager.InfoInsert();
				DPManager.AllInfo();
				break;
			case 3:	//친구정보검색
				DPManager.SearchInfo();
				break;
			case 4:	//친구정보수정
				DPManager.EditInfo();
				break;
			case 5:	//친구정보삭제
				DPManager.DeleteInfo();
				break;
			case 6:
				System.exit(0);
				break;
			}
		}

	}
	
	

}
