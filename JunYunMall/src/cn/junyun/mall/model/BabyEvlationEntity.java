package cn.junyun.mall.model;

/**
 * 宝贝评价
 * @author wang
 *
 */

public class BabyEvlationEntity  extends Entity{
	
	private String description;//评价描述
	private String name;//评价人昵称
	private String date;//评价时间
	private String colorAndSize;//颜色尺寸等
	
	public BabyEvlationEntity(String description, String name, String date,
			String colorAndSize) {
		super();
		this.description = description;
		this.name = name;
		this.date = date;
		this.colorAndSize = colorAndSize;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getColorAndSize() {
		return colorAndSize;
	}
	public void setColorAndSize(String colorAndSize) {
		this.colorAndSize = colorAndSize;
	}
	

}
