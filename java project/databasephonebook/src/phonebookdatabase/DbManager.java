package phonebookdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbManager {

		
//모든 친구정보를 볼수있도록 만든다.
	static void AllInfo() {
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "SCOTT";
		String pw = "tiger";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			Statement smt = null;
			smt=conn.createStatement();
			String sql="select * from PHONEINFO_BASIC";
			
			ResultSet rs;
			rs=smt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\n");
			}
			conn.close();
			smt.close();
			
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
//정보입력을 만든다.
		
//정보수정을 만든다.
		
//정보삭제를 만든다.
		
//정보검색을 만든다.		
	
}
