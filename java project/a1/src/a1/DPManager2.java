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
	public void InfoInsert() {
					
			System.out.println("친구 정보를 입력합니다.");
			
			System.out.println("이름 입력>>");
			String fr_Name = DPMain.sc.nextLine();
			System.out.println("전화번호 입력>>");
			String fr_phonenumber = DPMain.sc.nextLine();
			System.out.println("이메일 입력>>");
			String fr_email = DPMain.sc.nextLine();
			System.out.println("주소 입력>>");
			String fr_address = DPMain.sc.nextLine();
			
			PhoneInfo phoneinfo = new PhoneInfo(idx, fr_Name, fr_phonenumber, fr_email, fr_address);
			
			int resultCnt = 0;
			try {
			resultCnt = dao.PhoneInsert(phoneinfo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(resultCnt >0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			}else {
				System.out.println("입력되지 않았습니다. 확인 후 다시 입력 하세요.");
			}
			
	}

	//친구 정보 검색
	public void SearchInfo() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			
			System.out.println("검색할 친구이름 입력>>");
			String fr_Name=sc.nextLine();
			
			String sql = "select * from phoneinfo_basic where fr_Name='"+fr_Name+"'";
			pstmt=conn.prepareStatement(sql);
			
			int resultCnt =pstmt.executeUpdate();
			
			if(resultCnt>0) {
				System.out.println("검색 결과 출력");
				rs=pstmt.executeQuery();
				while (rs.next()) {
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getString(3)+"\t");
					System.out.print(rs.getString(4)+"\t");
					System.out.print(rs.getString(5)+"\t");
					System.out.print(rs.getString(6)+"\n");

				}
			
			}else {
				System.out.println("입력 실패");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//친구 정보 수정
	public void EditInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			
			System.out.println("수정할 친구이름 입력>>");
			String fr_Name=sc.nextLine();
			
			String sql = "update phoneinfo_basic " + 
					"set fr_Phonenumber=?, fr_email=?, fr_address=? where fr_Name='"+fr_Name+"'"; 
			pstmt=conn.prepareStatement(sql);
			System.out.println("친구 정보를 수정합니다.");
			System.out.println("전화번호 입력>>");
			String fr_Phonenumber = sc.nextLine();
			System.out.println("이메일 입력>>");
			String fr_email = sc.nextLine();
			System.out.println("주소 입력>>");
			String fr_address = sc.nextLine();
			
			pstmt.setString(1, fr_Phonenumber);
			pstmt.setString(2, fr_email);
			pstmt.setString(3, fr_address);
			
			
			int resultCnt =pstmt.executeUpdate();
			
			if(resultCnt>0) {
				
				System.out.println("정상적으로 수정 되었습니다.");
				System.out.println(resultCnt+"행이 수정되었습니다.");
			}else {
				System.out.println("입력 실패");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	//친구 정보 삭제
	public void DeleteInfo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			
			System.out.println("삭제할 친구이름 입력>>");
			String fr_Name=sc.nextLine();
			
			String sql = "delete from phoneinfo_basic where fr_Name='"+fr_Name+"'";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
