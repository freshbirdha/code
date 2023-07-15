package vo;

import java.util.List;

public class IndexVO {
	List<BanKuaiVO> bVos;

	public IndexVO(List<BanKuaiVO> bVos) {
		super();
		this.bVos = bVos;
	}

	public IndexVO() {
		super();
	}

	public List<BanKuaiVO> getbVos() {
		return bVos;
	}

	public void setbVos(List<BanKuaiVO> bVos) {
		this.bVos = bVos;
	}
	
}
