package cn.junyun.mall.model;

public class BrandStreetEntity extends Entity{
	private int brandIv;

	public BrandStreetEntity(int brandIv) {
		super();
		this.brandIv = brandIv;
	}

	public BrandStreetEntity() {
		super();
	}

	public int getBrandIv() {
		return brandIv;
	}

	public void setBrandIv(int brandIv) {
		this.brandIv = brandIv;
	}

	@Override
	public String toString() {
		return "BrandStreetEntity [brandIv=" + brandIv + "]";
	}

}
