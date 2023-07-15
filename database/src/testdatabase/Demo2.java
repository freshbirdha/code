package testdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo2 {
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
		Statement stmt = con.createStatement();
	//	String sql = "insert into emp1 values(142,'xiaoli',20,18000)";
		String sql ="update emp1 set name='xiaogang', deptId=30,salary=25000 where id = 142";
		int r =stmt.executeUpdate(sql);
		System.out.println(r);
		
	}
	
	@Test
	public void fun2() throws ClassNotFoundException,SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","1234567890");
		
		//得到statement对象
		Statement stmt = con.createStatement();
		
		//调用statement的ResultSet rs = executeQuery(String querySql)
		ResultSet rSet = stmt.executeQuery("select * from emp");
		
		//System.out.println(rSet);
		
		/**
		 * 解析ResultSet ,即解析表格
		 * 1. 把光标移动到第一行，可以调用next()方法完成
		 * 
		 */
		while(rSet.next()) {//把光标向下移动一行，并判断下一行是否存在
			int empno = rSet.getInt(1);//通过列编号来获取该列的值
			String ename = rSet.getString("ename");//通过列名称来获取该列的值
			double sal = rSet.getDouble("sal");//
			System.out.println(empno + "," + ename + "," + sal);
			
		}
		
		/**
		 * 关闭资源
		 * 倒关
		 */
		
		rSet.close();
		stmt.close();
		con.close();
		
	}
	
	
	@Test
	public void fun3() throws ClassNotFoundException,SQLException {
				
		Connection con = null;//定义引用
		
		Statement stmt = null;
		
		ResultSet rSet = null;
		
		
		try {
		//获得连接
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","1234567890");
		
		//得到statement对象
		 stmt = con.createStatement();
		 
		//调用statement的ResultSet rs = executeQuery(String querySql)
		 rSet = stmt.executeQuery("select * from emp");
		 
			while(rSet.next()) {//把光标向下移动一行，并判断下一行是否存在
				System.out.println(rSet.getObject(1) + "," + rSet.getString("ename") + "," + rSet.getDouble("sal"));
				
			}
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//关闭
			if (rSet != null) rSet.close();
			if (stmt != null) stmt.close();
			if (con != null)  con.close();
		}
		
	}
	
		
	@Test
	public void fun4() throws Exception {
				
		Connection con = null;//定义引用
		
		Statement stmt = null;
		
		ResultSet rSet = null;
		
		
		try {
		//获得连接
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","1234567890");
		
		//得到statement对象
		 stmt = con.createStatement();
		 
		//调用statement的ResultSet rs = executeQuery(String querySql)
		 rSet = stmt.executeQuery("select * from emp");
		 
//			while(rSet.next()) {//把光标向下移动一行，并判断下一行是否存在
//				System.out.println(rSet.getObject(1) + "," + rSet.getString("ename") + "," + rSet.getDouble("sal"));
//				
//			}
		 
		 /** 获得结果集元数据:
			 * 1. 得到元数据:rs.getMetaDate(),返回值为ResultMetaData;
			 * 2. 获取结果集列数:int getColumnCount()
			 * 3. 获取指定列的列名:String getColumnName(int collndex)
			 * 
			 */
		 int count = rSet.getMetaData().getColumnCount();
		 while(rSet.next()) {//遍历行
			 for(int i = 1; i <=count; i++) {//遍历列
				 System.out.print(rSet.getString(i));
				 if (i < count) {//最后一行不加,
					 System.out.print(", ");
				 }
				
			 }
			 System.out.println();
		 }
		 
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//关闭
			if (rSet != null) rSet.close();
			if (stmt != null) stmt.close();
			if (con != null)  con.close();
		}
	
	}
	
}
