package ex20;
//셀렉트와 리절트 부분만 바뀌면 됨.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest2 {

	public static void main(String[] args)  {
		
		//자바의 sql에 있는 클래스 선택.
		Connection conn = null;
		ResultSet rs;
	
		
		//1. DB 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("Oracle 드라이버 로드 성공");
		
		//컨넥션연결
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user ="scott";
		String pw = "tiger";
		
		//2. 데이터 베이스에 접속. 겟컨넥트 메서드를 통해 컨넥션 객체를 가져오는거.
		conn=DriverManager.getConnection(url, user, pw);
		System.out.println("로드 성공");
		
		//트랜잭션 설정 3번이 정상적으로 처리되면 커밋해줘라.
		//conn.setAutoCommit(false);
		
		//3. sql로 데이터 처리..
		//Statement stmt = conn.createStatement();
		Statement stmt = conn.createStatement();
		
		System.out.println("회원의 이름을 입력해 주세요.");
		Scanner kb = new Scanner(System.in);
		String searchName = kb.nextLine();
		
		//String sql = "select empno, ename, job  from emp order by empno";
		String sql1 = "select b.bookname, b.price, b.price-o.saleprice as a from orders o, book b "
				+ " where o.bookid=b.bookid";

		
		//셀렉의 경과는 리절트셋이 받는다.
		//
		
		rs=stmt.executeQuery(sql1);
		
		
		System.out.println("-------------------------");
		System.out.println("사원번호\t사원이름\t직급");
		System.out.println("-------------------------");
		//resultset : next() >>행의 존재유무 확인
		while(rs.next()) {
			//컬럼이름을 사용하여 가져올 수 있다.
//			System.out.print(rs.getInt("deptno")+"\t");
//			System.out.print(rs.getString("dname")+"\t");
//			System.out.print(rs.getString("loc")+"\n");
			

			//숫자를(컬럼의 위치값) 이용해서도 데이터를 가져올 수 있다.
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\n");
		}
		rs.close();
		stmt.close();
		
		
		//commit:정상처리 완료 <<여러개 데이터 베이스 작업을 얘기함.
		//conn.commit();
		//4. DB close완료 처리.
		//여기서도 예외 처리를 해주어야 하는 것이 맞음.
		conn.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
//			try {
//				//3번이 오류가 나면 여기서 걸러짐. 그럼 롤백하라고하면됨.
//				//conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		}
	}

}
