package dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import jdbc.JdbcUtils;

public class Demo2 {
	@Test
	public void fun1() {
		Stu s = new Stu(100, "zhangSan", 99, "male","shanghai",2000);
		addStu(s);
		
//		Stu s = load(100);
//		System.out.println(s);
	}
	
	public void addStu(Stu stu) {
		QR qr = new QR(JdbcUtils.getDataSource());//创建对象时给出连接池
		String sql = "insert into stu values(?,?,?,?,?,?)";//给出sql模板
		// 给出参数
		Object[] params = {stu.getSid(), stu.getSname(), stu.getAge(), stu.getGender(),stu.getProvince(),stu.getTuition()};
		// 调用update执行增、删、改！
		qr.update(sql, params);
	}
	
	public Stu load(int sid) {
		QR qr = new QR(JdbcUtils.getDataSource());//创建对象时给出连接池
		String sql = "select * from stu where sid=?";//给出sql模板
		Object[] params = {sid};
		
		RsHandler<Stu> rh = new RsHandler<Stu>() {
			public Stu handle(ResultSet rs) throws SQLException {
				if(!rs.next()) return null;
				Stu stu = new Stu();
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setAge(rs.getInt("age"));
				stu.setGender(rs.getString("gender"));
				stu.setProvince(rs.getString("province"));
				stu.setTuition(rs.getInt("tution"));
				return stu;
			}
		};
		return (Stu) qr.query(sql, rh, params);
	}
}
