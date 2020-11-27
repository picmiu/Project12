package co.miu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";
	
	public Connection conn;
	
	public DAO() {
			
			try {
		         Class.forName(driver); //드라이버 로드 
		         conn = DriverManager.getConnection(url, user, password);
		         System.out.println("연 결 성 공 ㅋ");
		         
		      }catch(ClassNotFoundException | SQLException e) {
		         e.printStackTrace(); //어떤 오류가 떴는지 알수있음
		         System.out.println("DB 연 결 실 패 ㅋ 떼잉");
		      }

	}
}
