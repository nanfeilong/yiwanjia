package cn.junyun.mall.model;
//热卖商品
public class BestSellerEntity extends Entity{
	//顶部图案
	private int bestSellerIv;
	//文字描述
	private String bestSellTv1;
	//XX（人数）
	private String bestSellTv2;
	//金额
	private String bestSellTv4;
	public BestSellerEntity() {
		super();
	}
	public BestSellerEntity(int bestSellerIv, String bestSellTv1,
			String bestSellTv2, String bestSellTv4) {
		super();
		this.bestSellerIv = bestSellerIv;
		this.bestSellTv1 = bestSellTv1;
		this.bestSellTv2 = bestSellTv2;
		this.bestSellTv4 = bestSellTv4;
	}
	public int getBestSellerIv() {
		return bestSellerIv;
	}
	public void setBestSellerIv(int bestSellerIv) {
		this.bestSellerIv = bestSellerIv;
	}
	public String getBestSellTv1() {
		return bestSellTv1;
	}
	public void setBestSellTv1(String bestSellTv1) {
		this.bestSellTv1 = bestSellTv1;
	}
	public String getBestSellTv2() {
		return bestSellTv2;
	}
	public void setBestSellTv2(String bestSellTv2) {
		this.bestSellTv2 = bestSellTv2;
	}
	public String getbestSellTv4() {
		return bestSellTv4;
	}
	public void setbestSellTv4(String bestSellTv4) {
		this.bestSellTv4 = bestSellTv4;
	}
	@Override
	public String toString() {
		return "BestSellerEntity [bestSellerIv=" + bestSellerIv
				+ ", bestSellTv1=" + bestSellTv1 + ", bestSellTv2="
				+ bestSellTv2 + ", bestSellTv4=" + bestSellTv4 + "]";
	}

}
