package ex20;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest5 {

	public static void main(String[] args){

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {

			//1. DB 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			//2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");


			//3. Statement

			//stmt = conn.createStatement();

			String sql = "insert into dept (deptno, dname, loc) "
					+ " values(?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, 70);
			pstmt.setString(2, "마케팅");
			pstmt.setString(3, "서울");
			
			int resultCnt =pstmt.executeUpdate();
			
			if(resultCnt>0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt+"행이 입력이되었습니다.");
			}else {
				System.out.println("입력 실패");
			}
			
			//int resultCnt = stmt.executeUpdate(sql);

			System.out.println( "부서목록");
			//resultSet>>결과 참조
			


	
//			pstmt.close();
//			conn.close();
//			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(rs != null) {//널값 먼저비교
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		}



	}

}
