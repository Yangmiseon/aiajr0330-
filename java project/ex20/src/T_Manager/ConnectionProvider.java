package T_Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection get{
		Connection conn = null;
				// 2. 데이터베이스 연결

				// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
				// 주소 : localhost or 127.0.0.1
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String pw = "tiger";

				// Connection 객체 생성
			
	}return conn;

}
