package vo;

import java.util.Date;

public class TieziVO {
	/**
	 * 帖子id
	 */
	private int tid;
	
	
	/**
	 * 帖子标题
	 */
	private String title;
	

	private String userName;
	
	private int huifuCount;
	
	private Date updateTime;

	public TieziVO() {
		super();
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getHuifuCount() {
		return huifuCount;
	}

	public void setHuifuCount(int huifuCount) {
		this.huifuCount = huifuCount;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	



}
