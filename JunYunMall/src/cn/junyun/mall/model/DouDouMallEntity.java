package cn.junyun.mall.model;
/*
 * 豆豆商城实体类
 */
public class DouDouMallEntity extends Entity{
	//豆豆商城图片
	private int douDouMallIv;
	//豆豆商城兑换豆豆数量
	private String douDou;
	//原件
	private String yuanJian;
	//兑换物品名称
	private String douDouName;
	public DouDouMallEntity() {
		super();
	}
	public DouDouMallEntity(int douDouMallIv, String douDou, String yuanJian,
			String douDouName) {
		super();
		this.douDouMallIv = douDouMallIv;
		this.douDou = douDou;
		this.yuanJian = yuanJian;
		this.douDouName = douDouName;
	}
	public int getDouDouMallIv() {
		return douDouMallIv;
	}
	public void setDouDouMallIv(int douDouMallIv) {
		this.douDouMallIv = douDouMallIv;
	}
	public String getDouDou() {
		return douDou;
	}
	public void setDouDou(String douDou) {
		this.douDou = douDou;
	}
	public String getYuanJian() {
		return yuanJian;
	}
	public void setYuanJian(String yuanJian) {
		this.yuanJian = yuanJian;
	}
	public String getDouDouName() {
		return douDouName;
	}
	public void setDouDouName(String douDouName) {
		this.douDouName = douDouName;
	}
	@Override
	public String toString() {
		return "DouDouMallEntity [douDouMallIv=" + douDouMallIv + ", douDou="
				+ douDou + ", yuanJian=" + yuanJian + ", douDouName="
				+ douDouName + "]";
	}	


}
