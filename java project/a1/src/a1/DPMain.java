package a1;

import java.sql.SQLException;
import java.util.Scanner;

public class DPMain {
		static Scanner sc= new Scanner(System.in);
		
	public static void main(String[] args) throws SQLException {
		DPManager2 dpm2 = new DPManager2();
		while (true) {
			System.out.println("1.모든정보 출력 2.친구 정보 입력 3.친구 검색 \n4.친구정보 수정"
					+ "5.친구 정보 삭제 6.프로그램 종료");
			int select = sc.nextInt();
			switch(select) {
			case 1://모든 정보 출력
				System.out.println("저장된 모든 정보를 출력합니다.");
				dpm2.AllInfo();
				break;
			case 2:	//친구정보입력
				System.out.println("친구 정보를 입력합니다.");
				dpm2.InfoInsert();
				break;
			case 3:	//친구정보검색
				System.out.println("저장된 친구를 검색합니다.");
				dpm2.SearchInfo();
				break;
			case 4:	//친구정보수정
				System.out.println("친구 정보를 수정합니다.");
				dpm2.EditInfo();
				break;
			case 5:	//친구정보삭제
				System.out.println("저장된 친구를 삭제합니다.");
				dpm2.DeleteInfo();
				break;
			case 6:
				System.out.println("종료합니다.");
				System.exit(0);
				break;
			}
		}
	}
}
