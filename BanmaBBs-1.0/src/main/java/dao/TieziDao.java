package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import entity.TieZi;
import util.JdbcUtils;

public class TieziDao {
	
	public List<TieZi>getTieziByBid(int bid,int pageIndex){
		List<TieZi> list = new ArrayList<>();
		
		if(pageIndex > 0) {
			pageIndex--;
		}else {
			pageIndex = 0; //默认显示第一页
		}
		try {
			/**select * from tiezi where bid = ? limit 0,5 //第一页
			 * select * from tiezi where bid = ? limit 5,5//第二页
			 * select * from tiezi where bid = ? limit 10,5 第三页
			 * 
			 */
			Connection connection = JdbcUtils.getConnection();
			String sql = "select * from tiezi where bid = ? limit ?,5";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, bid);
			st.setInt(2, pageIndex*5);
			ResultSet rSet = st.executeQuery();
			
			while(rSet.next()) {
				TieZi tieZi = new TieZi();
				tieZi.setBid(rSet.getInt("bid"));
				tieZi.setContent(rSet.getString("content"));
				tieZi.setTid(bid);
				tieZi.setCreateTime(rSet.getTimestamp("createTime"));
				tieZi.setTitle(rSet.getString("title"));
				tieZi.setUpdateTime(rSet.getTimestamp("updateTime"));
				tieZi.setUid(rSet.getInt("uid"));
				list.add(tieZi);
				
			}
			rSet.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
		
	}

	
	public TieZi getTiezibyTid(int tid) {
		
		TieZi tiezi = null;
		try {
			Connection connection = JdbcUtils.getConnection();
			String sql = "select * from tiezi where tid = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, tid);
			ResultSet rSet = st.executeQuery();
			
			while(rSet.next()) {
				tiezi = new TieZi();
				
				tiezi.setContent(rSet.getString("content"));
				tiezi.setCreateTime(rSet.getTimestamp("createTime"));
				tiezi.setTid(tid);
				tiezi.setBid(rSet.getInt("bid"));
				tiezi.setUid(rSet.getInt("uid"));
				tiezi.setUpdateTime(rSet.getTimestamp("updateTime"));
				tiezi.setTitle(rSet.getString("title"));
			}
			rSet.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tiezi;
		
	}
	
	
	public TieZi getLastUpdateTieZiByBid(int bid) {
		TieZi tiezi = null;
		try {
			Connection connection = JdbcUtils.getConnection();
			String sql = "select * from tiezi where bid = ? ORDER BY updateTime DESC LIMIT 0,1";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, bid);
			ResultSet rSet = st.executeQuery();
			
			while(rSet.next()) {
				tiezi = new TieZi();
				
				tiezi.setContent(rSet.getString("content"));
				tiezi.setCreateTime(rSet.getTimestamp("createTime"));
				tiezi.setTid(rSet.getInt("tid"));
				tiezi.setBid(rSet.getInt("bid"));
				tiezi.setUid(rSet.getInt("uid"));
				tiezi.setUpdateTime(rSet.getTimestamp("updateTime"));
				tiezi.setTitle(rSet.getString("title"));
			}
			rSet.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tiezi;
		
	}
	
	
	public long addTieZi(TieZi tiezi) {
		
	
		try {
			Connection connection = JdbcUtils.getConnection();
			
			String sql =  "insert tiezi (title,createTime,updateTime,content,uid,bid) values (?,?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp daTimestamp = new java.sql.Timestamp(date.getTime());
			
			//java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			
			
			st.setString(1, tiezi.getTitle());
			st.setTimestamp(2, daTimestamp);
			st.setTimestamp(3, daTimestamp);
			st.setString(4, tiezi.getContent());
			st.setInt(5, tiezi.getUid());
			
			st.setInt(6, tiezi.getBid());
			
			int cnt = st.executeUpdate();
			
			
			if(cnt != 1) {
				return -1;
			}
			
			try {
				ResultSet generatedKeys = st.getGeneratedKeys();
	            if (generatedKeys.next()) {
	            	long tid = generatedKeys.getLong(1);
	            	st.close();
	                return tid;
	            }
	            else {
	                return -1;
	            }
	        }catch (Exception e) {
				return -1;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;		
		
	}

	public boolean updateTiezi(TieZi tiezi) {
		try {
			Connection connection = JdbcUtils.getConnection();
			
			String sql =  "update tiezi set title=?,content=?,updateTime=? where tid=?";
			PreparedStatement st = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp daTimestamp = new java.sql.Timestamp(date.getTime());
			st.setString(1, tiezi.getTitle());
			st.setString(2, tiezi.getContent());
			st.setTimestamp(3, daTimestamp);
			st.setInt(4, tiezi.getTid());
			
			
			
			int cnt = st.executeUpdate();
			
			
			if(cnt != 1) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;	
		
		
	}

	public boolean delete(int tid) {
		
		try {
			Connection connection = JdbcUtils.getConnection();
			
			String sql =  "delete from tiezi where tid=?";
		
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, tid);

			int cnt = st.executeUpdate();		
			if(cnt != 1) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;	
		
		
	}


}
