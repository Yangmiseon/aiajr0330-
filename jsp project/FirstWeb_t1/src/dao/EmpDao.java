package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Emp;

public class EmpDao {
	//외부에서 객체생성을 하는 것을 막는다.
	//생성자의 접근제어지시자 이용 : private
	
	private EmpDao() {
		
	}
	
	//스태틱을 하면 위에거랑 상관없이 변수가 생성되고 뉴가 실행됨.
	//사용할 인스턴스 하나를 생성한다.
	private static EmpDao dao = new EmpDao();
	
	//EmpDao 인스턴스의 참조값을 반환하는 매서드
	public static EmpDao getInstance() {
		return dao;
	}

	public List<Emp> getEmpList(Connection conn) throws SQLException {
		
		Statement stmt = null;
		ResultSet rs = null;

		List<Emp> empList = new ArrayList();

		
		
		
		// 3. Statement 생성
		stmt = conn.createStatement();

		String sql = "select * from emp02 order by ename desc";

		// select 의 결과 ResultSet 객체에 담는다.
		rs = stmt.executeQuery(sql);

		// 결과 출력
		while (rs.next()) {
			empList.add(new Emp(
					rs.getInt("empno"), 
					rs.getString("ename"), 
					rs.getInt("sal"), 
					rs.getString("job")));
		}
		
		return empList;
		
	}
}
