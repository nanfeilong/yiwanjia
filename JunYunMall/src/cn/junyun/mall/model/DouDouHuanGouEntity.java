package cn.junyun.mall.model;
/*
 * 豆豆换购entity
 */
public class DouDouHuanGouEntity extends Entity{
	//豆豆换购图案
	private int douDouHuanGouIv;
	//豆豆换后标题
	private String douDouHuanGouName;
	//豆豆换购所需豆豆数量
	private String douDouHuanGouXu;
	//豆豆换购原价
	private String douDouYuanJia;
	//已经换购人数
	private String douDouHuanGouRenShu;
	public DouDouHuanGouEntity() {
		super();
	}
	public DouDouHuanGouEntity(int douDouHuanGouIv, String douDouHuanGouName,
			String douDouHuanGouXu, String douDouYuanJia,
			String douDouHuanGouRenShu) {
		super();
		this.douDouHuanGouIv = douDouHuanGouIv;
		this.douDouHuanGouName = douDouHuanGouName;
		this.douDouHuanGouXu = douDouHuanGouXu;
		this.douDouYuanJia = douDouYuanJia;
		this.douDouHuanGouRenShu = douDouHuanGouRenShu;
	}
	public int getDouDouHuanGouIv() {
		return douDouHuanGouIv;
	}
	public void setDouDouHuanGouIv(int douDouHuanGouIv) {
		this.douDouHuanGouIv = douDouHuanGouIv;
	}
	public String getDouDouHuanGouName() {
		return douDouHuanGouName;
	}
	public void setDouDouHuanGouName(String douDouHuanGouName) {
		this.douDouHuanGouName = douDouHuanGouName;
	}
	public String getDouDouHuanGouXu() {
		return douDouHuanGouXu;
	}
	public void setDouDouHuanGouXu(String douDouHuanGouXu) {
		this.douDouHuanGouXu = douDouHuanGouXu;
	}
	public String getDouDouYuanJia() {
		return douDouYuanJia;
	}
	public void setDouDouYuanJia(String douDouYuanJia) {
		this.douDouYuanJia = douDouYuanJia;
	}
	public String getDouDouHuanGouRenShu() {
		return douDouHuanGouRenShu;
	}
	public void setDouDouHuanGouRenShu(String douDouHuanGouRenShu) {
		this.douDouHuanGouRenShu = douDouHuanGouRenShu;
	}
	@Override
	public String toString() {
		return "DouDouHuanGouEntity [douDouHuanGouIv=" + douDouHuanGouIv
				+ ", douDouHuanGouName=" + douDouHuanGouName
				+ ", douDouHuanGouXu=" + douDouHuanGouXu + ", douDouYuanJia="
				+ douDouYuanJia + ", douDouHuanGouRenShu="
				+ douDouHuanGouRenShu + "]";
	}

}
