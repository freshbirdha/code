package entity;

import java.util.Date;
/**
 * 帖子实体类
 * @author USER
 *
 */
public class TieZi {
	
	
	
	
	/**
	 * 帖子id
	 */
	private int tid;
	
	
	/**
	 * 帖子标题
	 */
	private String title;
	
	
	/**
	 * 帖子创建时间
	 */
	private Date createTime;
	
	
	/**
	 * 帖子最后修改时间
	 */
	private Date updateTime;
	
	
	/**
	 * 帖子内容
	 */
	private String content;
	
	
	/**
	 * 发帖人ID
	 */
	private int uid;
	
	
	/**
	 * 帖子所属版块id
	 */
	private int bid;
	
	

	public TieZi() {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
}
