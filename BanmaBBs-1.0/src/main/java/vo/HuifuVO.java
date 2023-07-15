package vo;

import entity.HuiFu;
import entity.User;

public class HuifuVO {
	private User user;
	private HuiFu huifu;

	public HuifuVO() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HuiFu getHuifu() {
		return huifu;
	}

	public void setHuifu(HuiFu huifu) {
		this.huifu = huifu;
	}

}
