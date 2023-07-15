package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcUtils {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		try {
				
			String url = "jdbc:mysql://localhost:3306/banmaluntan";
			
			String user = "root";
			
			String password = "1234567890";
			
			return (Connection) DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
