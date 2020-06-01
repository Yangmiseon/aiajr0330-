package T_Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DeptManager {
	DeptDao dao = new DeptDao();
	public void deptManager() {

		System.out.println("DEPT Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit  ");
		System.out.println("=========================================");

		int select = sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			deptList();
			break;
		case 2:
			System.out.println("부서 정보를 입력합니다.");
			//deptInsert();
			break;
		case 3:
			System.out.println("부서 정보를 검색합니다.");
			//deptSearch();
			break;
		case 4:
			System.out.println("부서 정보를 삭제합니다.");
			//deptDelete();
			break;
		case 5:
			System.out.println("부서 정보를 수정합니다.");
			//deptEdit();
			break;

		}


	}
	//출력용
	//%S 문자열 반환 %10s 무조건 10자리 반환
	public void deptList() {
		List<Dept> deptList = dao.deptList();
		if(deptList != null && deptList.isEmpty()) {
			for(int i=0; i<deptList.size(); i++) {
				System.out.printf("%5d", deptList.get(i).getDeptno()+"\t");
				System.out.printf("%12s", deptList.get(i).getDname()+"\t");
				System.out.printf("%12s", deptList.get(i).getLoc()+"\n");
			}
		}
		
	}
	
	
	
	
	
}
