package vo;

import java.util.List;

import entity.BanKuai;

public class ListPageVO {
	
	List<TieziVO> list;
	
	private BanKuai banKuai;
	
	public List<TieziVO> getList() {
		return list;
	}

	public void setList(List<TieziVO> list) {
		this.list = list;
	}

	public BanKuai getBanKuai() {
		return banKuai;
	}

	public void setBanKuai(BanKuai banKuai) {
		this.banKuai = banKuai;
	}
	
}
