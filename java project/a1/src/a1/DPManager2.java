package a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class DPManager2 {
	
	DPDao dao = new DPDao();
	//친구 정보 모두 보기
	public void AllInfo() {
		
		List<PhoneInfo> piList = dao.PhoneInfoList();
		
		if(piList != null && !piList.isEmpty()) {
			for(int i=0; i<piList.size(); i++){
				System.out.printf("%6s", piList.get(i).getIdx()+"\t");
				System.out.printf("%12s", piList.get(i).getFr_Name()+"\t");
				System.out.printf("%12s", piList.get(i).getFr_phonenumber()+"\t");
				System.out.printf("%12s", piList.get(i).getFr_email()+"\t");
				System.out.printf("%12s", piList.get(i).getFr_address()+"\n");
			}
		}else {
			System.out.println("입력 데이터 없음");
		}
	}

	//친구 정보 입력
	public void InfoInsert() throws SQLException {
					
			
			System.out.println("이름 입력>>");
			DPMain.sc.nextLine();
			String fr_Name = DPMain.sc.nextLine();
			System.out.println("전화번호 입력>>");
			String fr_phonenumber = DPMain.sc.nextLine();
			System.out.println("이메일 입력>>");
			String fr_email = DPMain.sc.nextLine();
			System.out.println("주소 입력>>");
			String fr_address = DPMain.sc.nextLine();
			
			PhoneInfo phoneinfo = new PhoneInfo(0, fr_Name, fr_phonenumber, fr_email, fr_address);
			
			int resultCnt = 0;
			resultCnt = dao.PhoneInsert(phoneinfo);
			if(resultCnt >0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			}else {
				System.out.println("입력되지 않았습니다. 확인 후 다시 입력 하세요.");
			}
			
	}

	//친구 정보 검색
	public void SearchInfo() {
			
			System.out.println("검색할 친구이름 입력>>");
			DPMain.sc.nextLine();
			String searchName = DPMain.sc.nextLine();
			
			List<PhoneInfo> pinfo = dao.PhoneInfoSearch(searchName);

			for(PhoneInfo p :pinfo) {
				System.out.printf("%6s", p.getIdx()+"\t");
				System.out.printf("%12s", p.getFr_Name()+"\t");
				System.out.printf("%12s", p.getFr_phonenumber()+"\t");
				System.out.printf("%12s", p.getFr_email()+"\t");
				System.out.printf("%12s", p.getFr_address()+"\n");
			}
	}

	//친구 정보 수정
	public void EditInfo() {
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
					
			System.out.println("수정할 친구이름 입력>>");
			DPMain.sc.nextLine();
			String searchName=DPMain.sc.nextLine();
			
			int rowCnt = dao.PhoneinfoSearchCount(searchName, conn);
			
			if(rowCnt >0) {
				PhoneInfo pinfo = dao.PhoneInfoSaerchName(searchName, conn);
				
				if(pinfo == null) {
					System.out.println("찾으시는 이름의 정보가 없습니다.");
					return;
				}
			
			System.out.println("친구 정보를 수정합니다.");
			System.out.println("친구 이름: "+ pinfo.getFr_Name());
			System.out.println("친구 이름은 수정되지 않습니다.");
			
			
			System.out.println("전화번호: "+ pinfo.getFr_phonenumber());
			String fr_phonenumber = DPMain.sc.nextLine();
			System.out.println("주소: "+ pinfo.getFr_address());
			String fr_address = DPMain.sc.nextLine();
			System.out.println("이메일: "+ pinfo.getFr_email());
			String fr_email = DPMain.sc.nextLine();
			
			
			PhoneInfo newpinfo = new PhoneInfo(pinfo.getIdx(), pinfo.getFr_Name(), 
					fr_phonenumber, fr_email, fr_address);
			int resultCnt = dao.PhoneinfoEdit(newpinfo, conn);
			
			if(resultCnt>0) {
				
				System.out.println("정상적으로 수정 되었습니다.");
				System.out.println(resultCnt+"행이 수정되었습니다.");
			}else {
				System.out.println("입력 실패");
			}
			}else {
				System.out.println("찾으시는 이름의 정보가 존재하지않습니다.");
			}
			
			conn.commit();
		}catch (SQLException e) {
			
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("conn.close()");
					e1.printStackTrace();
				}
			}	
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
	//친구 정보 삭제
	public void DeleteInfo() {
		
			System.out.println("삭제할 친구이름 입력>>");
			DPMain.sc.nextLine();
			String searchName=DPMain.sc.nextLine();
			
			int resultCnt = dao.Phoneinfodelete(searchName);
			
			if(resultCnt<1) {
				System.out.println("삭제할 정보가 검색 결과가 없습니다.");
			}else {
				System.out.println(resultCnt + "행이 삭제 되었습니다.");
			}
}
}
