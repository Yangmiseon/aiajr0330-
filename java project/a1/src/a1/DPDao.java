package a1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import manager.ConnectionProvider;

public class DPDao {

	//전체정보출력
	public List<PhoneInfo> PhoneInfoList(){
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PhoneInfo> phoneinfo = new ArrayList<>();
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from phoneinfo_basic";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PhoneInfo pinfo = new PhoneInfo(
						rs.getInt("idx"), 
						rs.getString("fr_Name"), 
						rs.getString("fr_phonenumber"), 
						rs.getString("fr_email"), 
						rs.getString("fr_address"));
				phoneinfo.add(pinfo);
			}
			stmt.close();
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phoneinfo;
	}
	
	//친구정보입력
	public int PhoneInsert(PhoneInfo phoneinfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			String sql = "insert into phoneinfo_basic "
					+ "(fr_Name, fr_phonenumber, fr_email, fr_address) "
					+ "values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneinfo.getFr_Name());
			pstmt.setString(2, phoneinfo.getFr_phonenumber());
			pstmt.setString(3, phoneinfo.getFr_email());
			pstmt.setString(4, phoneinfo.getFr_address());
			
			resultCnt = pstmt.executeUpdate();
			
			rs.close();
			pstmt.close();
			conn.close();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return resultCnt;
	}
	
	//친구정보검색
	public List<PhoneInfo> PhoneInfoSearch(String fr_Name){
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PhoneInfo> list = new ArrayList<PhoneInfo>();
		
		try {
			conn = ConnectionProvider.getConnection();
			
			String sql = "select*from phoneinfo_basic where fr_Name like '%'||?||'%'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fr_Name);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new PhoneInfo(
						rs.getInt("idx"), 
						rs.getString("fr_Name"), 
						rs.getString("fr_phonenumber"), 
						rs.getString("fr_email"), 
						rs.getString("fr_address")));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
 	public int PhoneinfoSearchCount(String searchName, Connection conn) {
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int rowCnt = 0;
		
		try {
			String sql ="select count(*) from phoneinfo_basic where fr_Name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				rowCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowCnt;
	}
	
	public PhoneInfo PhoneInfoSaerchName(String searchName, Connection conn){
		PhoneInfo phoneinfo=null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			String sql = "select * from phoneinfo_basic where fr_Name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				phoneinfo = new PhoneInfo(
						rs.getInt("idx"), 
						rs.getString("fr_Name"), 
						rs.getString("fr_phonenumber"), 
						rs.getString("fr_email"), 
						rs.getString("fr_address"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phoneinfo;
	}
	
	//친구정보수정
	public int PhoneinfoEdit(PhoneInfo newphoneinfo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;
		
		try {
			String sql = "update phoneinfo_basic set fr_phonenumber=?, "
					+ "fr_email=?, fr_address=? where fr_Name=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newphoneinfo.getFr_phonenumber());
			pstmt.setString(2, newphoneinfo.getFr_email());
			pstmt.setString(3, newphoneinfo.getFr_address());
			pstmt.setString(4, newphoneinfo.getFr_Name());
			
			resultCnt = pstmt.executeUpdate();
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	//친구정보삭제
	public int Phoneinfodelete(String fr_Name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			String sql = "delete from phoneinfo_basic where fr_Name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fr_Name);
			
			resultCnt = pstmt.executeUpdate();
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
	}
}
