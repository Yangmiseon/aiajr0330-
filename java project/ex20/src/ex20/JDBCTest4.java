package ex20;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest4 {

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

			String sql = "select * from dept where deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			rs=pstmt.executeQuery();
			
			//int resultCnt = stmt.executeUpdate(sql);

			System.out.println( "부서목록");
			//resultSet>>결과 참조
			while (rs.next()) {
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getString("loc")+"\n");
			}



			//4. 데이터베이스 연결 종료
			rs.close();
			pstmt.close();
			conn.close();
			

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
