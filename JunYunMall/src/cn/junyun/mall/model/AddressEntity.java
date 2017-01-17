package cn.junyun.mall.model;

/**
 * 
 * 城市名
 *
 */

public class AddressEntity extends Entity{
	/**
	 * 
	 */
	private String cityName;
	

	public AddressEntity(String cityName) {
		super();
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

}
