package dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

public class Demo1 {
	
	@Test
	public void fun1() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/exam");
		dataSource.setUsername("root");
		dataSource.setPassword("1234567890");
		
		dataSource.setMaxTotal(20);
		dataSource.setMinIdle(3);
		dataSource.setMaxWaitMillis(1000);
		
		Connection connection = dataSource.getConnection();
		System.out.println(connection.getClass().getName());
		
		connection.close();//把连接归还给池
	}
}
