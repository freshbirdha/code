package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.User;
import util.JdbcUtils;

public class UserDao {
	
	public boolean addUser(User user) {
		boolean flag = false;
		try {
			Connection connection = JdbcUtils.getConnection();
			
			String sql =  "insert user (username,password,sex,headImage,createTime) values (?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getSex());
			st.setString(4, user.getHeadImage());
			//java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp daTimestamp = new java.sql.Timestamp(date.getTime());
			st.setTimestamp(5, daTimestamp);
			
			int cnt = st.executeUpdate();
			st.close();
			
			if(cnt != 1) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public User getUserById(int uid) {
		User user = null;
		try {
			Connection connection = JdbcUtils.getConnection();
			String sql = "select * from user where uid = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, uid);
			ResultSet rSet = st.executeQuery();
			
			while(rSet.next()) {
				user = new User();
				user.setUsername(rSet.getString("username"));
				user.setCreateTime(rSet.getTimestamp("createTime"));
				user.setHeadImage(rSet.getString("headImage"));
			
				user.setSex(rSet.getString("sex"));
				user.setUid(uid);
			}
			rSet.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	
	
	public User getUserByUserNameAndPw(String username,String password) {
		User user = null;
		try {
			Connection connection = JdbcUtils.getConnection();
			String sql = "select * from user where username = ? and password = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rSet = st.executeQuery();
			
			while(rSet.next()) {
				user = new User();
				user.setUsername(username);
				user.setCreateTime(rSet.getTimestamp("createTime"));
				user.setHeadImage(rSet.getString("headImage"));
				user.setSex(rSet.getString("sex"));
				user.setUid(rSet.getInt("uid"));
			}
			rSet.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	
	
	
	
//	public static void main(String[] args) {
//		UserDao userDao = new UserDao();
//		User user = new User();
//		user.setHeadImage("3.jpg");
//		user.setUsername("bbb");
//		user.setPassword("123456");
//		user.setSex("男");
//		if(userDao.addUser(user)) {
//			System.out.println("添加成功");
//		}else {
//			System.out.println("添加失败");
//		}
//	}
		
}
