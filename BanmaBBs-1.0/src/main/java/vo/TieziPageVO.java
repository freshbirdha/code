package vo;

import java.util.List;

import entity.BanKuai;
import entity.TieZi;
import entity.User;

public class TieziPageVO {
	
	//所属板块
	private BanKuai banKuai;
	//发帖人信息
	private User user;
	//帖子详情
	private TieZi tiezi;
	
	//回复列表
	private List<HuifuVO>list;

	public TieziPageVO() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TieZi getTiezi() {
		return tiezi;
	}

	public void setTiezi(TieZi tiezi) {
		this.tiezi = tiezi;
	}

	public List<HuifuVO> getList() {
		return list;
	}

	public void setList(List<HuifuVO> list) {
		this.list = list;
	}

	public BanKuai getBanKuai() {
		return banKuai;
	}

	public void setBanKuai(BanKuai banKuai) {
		this.banKuai = banKuai;
	}
	
	
}
