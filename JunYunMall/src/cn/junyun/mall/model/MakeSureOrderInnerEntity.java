package cn.junyun.mall.model;
/**
 * 
 * 确认订单
 * wang
 */

public class MakeSureOrderInnerEntity extends Entity {
	private String name;
	private String color;
	private String size;
	private String price;
	public MakeSureOrderInnerEntity(String name, String color, String size,
			String price) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	

}
