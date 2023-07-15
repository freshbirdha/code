package dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DemoC3p0 {
	@Test
	public void fun1() throws SQLException {
		//创建连接池对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUser("root");
		dataSource.setPassword("1234567890");
		
		//池配置
		dataSource.setAcquireIncrement(5);
		dataSource.setInitialPoolSize(20);
		dataSource.setMinPoolSize(2);
		dataSource.setMaxPoolSize(50);
		
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}
}
