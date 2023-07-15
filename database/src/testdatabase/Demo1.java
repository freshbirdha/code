package testdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class Demo1 {
	@Test
	public void fun1() throws ClassNotFoundException,SQLException {
		/**
		 * jdbc四大配置参数
		 * > driverClassName:com.mysql.jdbc.Driver
		 * > url:jdbc:mysql://localhost:3306/mydb
		 * > username:root
		 * > password:1234567890
		 */
		
		//Class.forName("com.mysql.jdbc.Driver");
		//String url = "jdbc:mysql://localhost:3306/mydb";
		//String username = "root";
		//String password = "1234567890";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234567890");
		System.out.println(con);
		
	}
}
