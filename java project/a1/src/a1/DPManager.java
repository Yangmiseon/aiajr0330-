package a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DPManager {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs=null;
	static Statement stmt=null;
	static Scanner sc = new Scanner(System.in);
	//친구 정보 모두 보기
	static void AllInfo() {

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";
		conn = DriverManager.getConnection(url, user, pw);
		stmt = conn.createStatement();
		String sql = "select * from phoneinfo_basic";
		rs=stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.print(rs.getString(5)+"\t");
			System.out.print(rs.getString(6)+"\n");
		}
		
		rs.close();
		stmt.close();
		conn.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	//친구 정보 입력
	static void InfoInsert() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);
			
			
			System.out.println("친구 정보를 입력합니다.");
			System.out.println("이름 입력>>");
			String fr_Name = sc.nextLine();
			System.out.println("전화번호 입력>>");
			String fr_Phonenumber = sc.nextLine();
			System.out.println("이메일 입력>>");
			String fr_email = sc.nextLine();
			System.out.println("주소 입력>>");
			String fr_address = sc.nextLine();
			
			String sql = "insert into phoneinfo_basic "
					+ " (idx, fr_Name, fr_Phonenumber,fr_email,fr_address) "
					+ " values(pb_basic_idx_seq.nextval, ?, ?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, fr_Name);
			pstmt.setString(2, fr_Phonenumber);
			pstmt.setString(3, fr_email);
			pstmt.setString(4, fr_address);
			
			int resultCnt =pstmt.executeUpdate();
			
			if(resultCnt>0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt+"행이 입력이되었습니다.");
			}else {
				System.out.println("입력 실패");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//친구 정보 검색
	static void SearchInfo() {
		
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
	static void EditInfo() {
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
	static void DeleteInfo() {
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
