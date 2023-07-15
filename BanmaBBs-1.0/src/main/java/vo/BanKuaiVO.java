package vo;

import java.util.List;

public class BanKuaiVO {
	private int bid;
	private String name;
	private int pid;
	
	/**
	 * 子版块对象
	 */
	private List<BanKuaiVO>cList;
	
	
//帖子数量
	private int tieziCount;
	
//最后发帖、回复贴对象
//	private TieZi lasTieZi;
	private TieziVO lasTieZi;

	
	public BanKuaiVO() {
		super();
	}


	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}


	public List<BanKuaiVO> getcList() {
		return cList;
	}


	public void setcList(List<BanKuaiVO> cList) {
		this.cList = cList;
	}


	public int getTieziCount() {
		return tieziCount;
	}


	public void setTieziCount(int tieziCount) {
		this.tieziCount = tieziCount;
	}


	public TieziVO getLasTieZi() {
		return lasTieZi;
	}


	public void setLasTieZi(TieziVO lasTieZi) {
		this.lasTieZi = lasTieZi;
	}


//	public TieZi getLasTieZi() {
//		return lasTieZi;
//	}
//
//
//	public void setLasTieZi(TieZi lasTieZi) {
//		this.lasTieZi = lasTieZi;
//	}
	

}
