package cn.junyun.mall.model;
/*
 * 极光推送实体类
 */
public class JiGuangEntity extends Entity{
	private String www;

	public JiGuangEntity() {
		super();
	}

	public JiGuangEntity(String www) {
		super();
		this.www = www;
	}

	public String getwww() {
		return www;
	}

	public void setwww(String www) {
		this.www = www;
	}


}
