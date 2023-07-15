package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.BanKuai;
import util.JdbcUtils;

public class BanKuaiDao {
	public BanKuai getBanKuaiById(int bid) {

		BanKuai banKuai = null;
		
		try {
			Connection connection = JdbcUtils.getConnection();
			String sql = "select * from bankuai where bid = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, bid);
			ResultSet rSet = st.executeQuery();
			
			while(rSet.next()) {
				banKuai = new BanKuai();
				banKuai.setBid(bid);
				banKuai.setName(rSet.getString("bname"));
				banKuai.setPid(rSet.getInt("pid"));
			}
			
			rSet.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return banKuai;
		
	}
	
	
	public List<BanKuai> getBanKuaiByPid(int pid){
		List<BanKuai> list = new ArrayList<>();
		
		try {
			Connection connection = JdbcUtils.getConnection();
			String sql = "select * from bankuai where pid = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, pid);
			ResultSet rSet = st.executeQuery();
			
			while(rSet.next()) {
				
				BanKuai banKuai = new BanKuai();
				banKuai.setBid(rSet.getInt("bid"));
				banKuai.setName(rSet.getString("bname"));
				banKuai.setPid(pid);
				list.add(banKuai);
			}
		
			rSet.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
