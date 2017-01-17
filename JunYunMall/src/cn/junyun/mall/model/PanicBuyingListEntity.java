package cn.junyun.mall.model;
/**
 * 疯狂抢购中list的实体类
 * @author fxr
 *
 */
public class PanicBuyingListEntity extends Entity{
	// 左边商品图片
	private int panicIv1;
	//商品文字描述一
	private String panicTv1;
	//商品文字描述二
	private String panicTv2;
	//商品文字描述三*(已购数量)
	private String panicTv3;
	//商品文字描述四（优惠价格）
	private String panicTv4;
	//商品文字描述五原价
	private String panicTv5;
	public PanicBuyingListEntity(int panicIv1, String panicTv1, String panicTv2,
			String panicTv3, String panicTv4, String panicTv5) {
		super();
		this.panicIv1 = panicIv1;
		this.panicTv1 = panicTv1;
		this.panicTv2 = panicTv2;
		this.panicTv3 = panicTv3;
		this.panicTv4 = panicTv4;
		this.panicTv5 = panicTv5;
	}
	public PanicBuyingListEntity() {
		super();
	}
	public int getPanicIv1() {
		return panicIv1;
	}
	public void setPanicIv1(int panicIv1) {
		this.panicIv1 = panicIv1;
	}
	public String getPanicTv1() {
		return panicTv1;
	}
	public void setPanicTv1(String panicTv1) {
		this.panicTv1 = panicTv1;
	}
	public String getPanicTv2() {
		return panicTv2;
	}
	public void setPanicTv2(String panicTv2) {
		this.panicTv2 = panicTv2;
	}
	public String getPanicTv3() {
		return panicTv3;
	}
	public void setPanicTv3(String panicTv3) {
		this.panicTv3 = panicTv3;
	}
	public String getPanicTv4() {
		return panicTv4;
	}
	public void setPanicTv4(String panicTv4) {
		this.panicTv4 = panicTv4;
	}
	public String getPanicTv5() {
		return panicTv5;
	}
	public void setPanicTv5(String panicTv5) {
		this.panicTv5 = panicTv5;
	}
	@Override
	public String toString() {
		return "PanicBuyingListBean [panicIv1=" + panicIv1 + ", panicTv1="
				+ panicTv1 + ", panicTv2=" + panicTv2 + ", panicTv3="
				+ panicTv3 + ", panicTv4=" + panicTv4 + ", panicTv5="
				+ panicTv5 + "]";
	}

}
