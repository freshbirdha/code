package entity;



public class BanKuai {
	private int bid;
	private String name;
	private int pid;
	
	

	public BanKuai(int bid, String name, int pid) {
		super();
		this.bid = bid;
		this.name = name;
		this.pid = pid;
	}
	

	public BanKuai() {
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




}
