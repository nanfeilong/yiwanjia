package cn.junyun.mall.model;

import android.widget.ImageView;
import android.widget.TextView;
/**
 * 首页上拉加载实体类
 * @author 冯昕睿
 *
 */
public class HomeListEntity extends Entity{
	//第一张图
	private int homeListOne;
	//小图标
	private int homeList;
	//文字
	private String homeListText;
	//第二张图
	private int homeListTwo;
	//第三张图
	private int homeListThree;
	//第四张图
	private int homeListFour;
	//第五张图
	private int homeListFive;
	//第六张图
	private int homeListSix;

	public HomeListEntity() {
		super();
	}

	public HomeListEntity(int homeListOne, int homeList, String homeListText,
			int homeListTwo, int homeListThree, int homeListFour,
			int homeListFive, int homeListSix) {
		super();
		this.homeListOne = homeListOne;
		this.homeList = homeList;
		this.homeListText = homeListText;
		this.homeListTwo = homeListTwo;
		this.homeListThree = homeListThree;
		this.homeListFour = homeListFour;
		this.homeListFive = homeListFive;
		this.homeListSix = homeListSix;
	}
	public int getHomeListOne() {
		return homeListOne;
	}
	public void setHomeListOne(int homeListOne) {
		this.homeListOne = homeListOne;
	}
	public int getHomeList() {
		return homeList;
	}
	public void setHomeList(int homeList) {
		this.homeList = homeList;
	}
	public String getHomeListText() {
		return homeListText;
	}
	public void setHomeListText(String homeListText) {
		this.homeListText = homeListText;
	}
	public int getHomeListTwo() {
		return homeListTwo;
	}
	public void setHomeListTwo(int homeListTwo) {
		this.homeListTwo = homeListTwo;
	}
	public int getHomeListThree() {
		return homeListThree;
	}
	public void setHomeListThree(int homeListThree) {
		this.homeListThree = homeListThree;
	}
	public int getHomeListFour() {
		return homeListFour;
	}
	public void setHomeListFour(int homeListFour) {
		this.homeListFour = homeListFour;
	}
	public int getHomeListFive() {
		return homeListFive;
	}
	public void setHomeListFive(int homeListFive) {
		this.homeListFive = homeListFive;
	}
	public int getHomeListSix() {
		return homeListSix;
	}
	public void setHomeListSix(int homeListSix) {
		this.homeListSix = homeListSix;
	}

	@Override
	public String toString() {
		return "HomeListEntity [homeListOne=" + homeListOne + ", homeList="
				+ homeList + ", homeListText=" + homeListText
				+ ", homeListTwo=" + homeListTwo + ", homeListThree="
				+ homeListThree + ", homeListFour=" + homeListFour
				+ ", homeListFive=" + homeListFive + ", homeListSix="
				+ homeListSix + "]";
	}
}
