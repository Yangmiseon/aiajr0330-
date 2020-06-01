package ex0529;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EMPManager {

	static Scanner sc = new Scanner(System.in);
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void main(String[] args) {
		
		System.out.println("Select Menu");
		System.out.println("----------------");
		System.out.println("1. EMP,  2. DEPT");
		System.out.println("----------------");
		
		int select = sc.nextInt();
		
		switch (select) {
		case 1:
			empManager();
			break;
		case 2:
			deptManager();
			break;
		}

	}

	private static void empManager() {
		System.out.println("EMP Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. insert  3. search  4. delete ");
		System.out.println("=========================================");
		
		int select = sc.nextInt();
		
		
		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			empList();
			break;
		case 2:
			System.out.println("사원 정보를 입력합니다.");
			empInsert();
			break;
		case 3:
			System.out.println("사원 정보를 검색합니다.");
			empSearch();
			break;
		case 4:
			System.out.println("사원 정보를 삭제합니다.");
			empDelete();
			empList();
			break;
		}
		
	}
	
	private static void empList() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);			

			Statement stmt = conn.createStatement();
			
			String sql = "select * from emp";			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\n");
			}
			
			rs.close();
			stmt.close();
			
			//4. close
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void empInsert() {		
		
		// 사용자 입력정보 변수
		System.out.println("사원 정보를 입력해주세요.");
		
		System.out.println("사원번호");
		int empno = sc.nextInt();
		System.out.println("사원이름");
		sc.nextLine();
		String ename = sc.nextLine();
		System.out.println("직급(업무)");
		String job = sc.nextLine();
		System.out.println("관리자");
		int mgr = sc.nextInt();
		System.out.println("입사일");
		sc.nextLine();
		String hiredate = sc.nextLine();
		System.out.println("급여");
		int sal = sc.nextInt();
		System.out.println("수당");
		int comm = sc.nextInt();
		System.out.println("부서번호");
		int deptno = sc.nextInt();
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);

			String sql = "insert into emp "
					+ " (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);
			
			int resultCnt = pstmt.executeUpdate();
	
			if(resultCnt>0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
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

	private static void empSearch() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			stmt = conn.createStatement();
			
			System.out.println("사원의 이름을 입력해주세요. >> ");
			sc.nextLine();
			String searchName = sc.nextLine();
			
			String sql = "select * from emp";
			String sql1 = "select * from emp where ename='"+searchName+"'";

			System.out.println("sql : "+ sql1);
			System.out.println();
			System.out.println();
			System.out.println();
			
			rs = stmt.executeQuery(sql1);
					
			System.out.println("사원 리스트 ");
			System.out.println("--------------------------");
			System.out.println("--------------------------");
	
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\n");
			}
			
			rs.close();
			stmt.close();
			
			//4. close
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void empDelete() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			stmt = conn.createStatement();
			
			System.out.println("사원의 번호 입력해주세요. >> ");
			sc.nextLine();
			int empno = sc.nextInt();
			
			String sql = "select * from emp";
			String sql1 = "delete from emp where empno="+empno;

			
			System.out.println("sql : "+ sql1);
			System.out.println();
			System.out.println();
			System.out.println();
			
			rs = stmt.executeQuery(sql1);
								
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//부서관리프로그램
	private static void deptManager() {
		System.out.println("DEPT Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. insert  3. search  4. delete ");
		System.out.println("=========================================");
		
		int select = sc.nextInt();
		
		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			deptList();
			break;
		case 2:
			System.out.println("부서 정보를 입력합니다.");
			deptInsert();
			break;
		case 3:
			System.out.println("부서 정보를 검색합니다.");
			deptSearch();
			break;
		case 4:
			System.out.println("부서 정보를 삭제합니다.");
			deptDelete();
			deptList();
			break;
		}		
	}
	
	private static void deptList() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from dept";			
			
			rs = stmt.executeQuery(sql);
						
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\n");

			}
			
			rs.close();
			stmt.close();
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deptInsert() {		
		
		System.out.println("사원 정보를 입력해주세요.");
		
		System.out.println("부서번호");
		int deptno = sc.nextInt();
		System.out.println("부서이름");
		sc.nextLine();
		String dname = sc.nextLine();
		System.out.println("거주지");
		String loc = sc.nextLine();
			
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);

			String sql = "insert into dept (deptno, dname, loc) "
					+ " values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			int resultCnt = pstmt.executeUpdate();
	
			if(resultCnt>0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
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

	private static void deptSearch() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			stmt = conn.createStatement();
			
			System.out.println("부서번호를 입력해주세요. >> ");
			sc.nextLine();
			String searchDeptno = sc.nextLine();
			
			String sql = "select * from dept";
			String sql1 = "select * from dept where deptno="+searchDeptno;

			
			System.out.println("sql : "+ sql1);
			System.out.println();
			System.out.println();
			System.out.println();
			
			rs = stmt.executeQuery(sql1);
					
			System.out.println("부서 검색 결과 ");
			System.out.println("--------------------------");
			System.out.println("--------------------------");
	
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\n");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deptDelete() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			stmt = conn.createStatement();
			
			System.out.println("부서 번호 입력해주세요. >> ");
			sc.nextLine();
			int deptno = sc.nextInt();
			
			String sql = "select * from dept";
			String sql1 = "delete from dept where deptno="+deptno;

			
			System.out.println("sql : "+ sql1);
			System.out.println();
			System.out.println();
			System.out.println();
			
			rs = stmt.executeQuery(sql1);
								
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	




}