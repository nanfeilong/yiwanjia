package cn.junyun.mall.model;

import java.util.ArrayList;

/**
 * 我的订单
 * @author Administrator
 *
 */
public class MyOrderAllEntity {

	//店名
	private String ShopName;
	//交易状态
	private String TransactionStatus;
	//商品详细
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities;
	
	
	public static  int MYORDER_FLAG_ALL = 100; //全部
	public static  int MYORDER_FLAG_WAIT_PAY_MONEY = 101; //待付款
	public static  int MYORDER_FLAG_WAIT_SEND_GOODS = 102; //待发货
	public static  int MYORDER_FLAG_WAIT_RECEIVS_GOODS = 103; //待收货
	public static  int MYORDER_FLAG_WAIT_COMMENT = 104; //待评价
	
	
	
	public MyOrderAllEntity(String shopName, String transactionStatus,
			ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities) {
		super();
		this.ShopName = shopName;
		this.TransactionStatus = transactionStatus;
		this.myOrderAllInnerEntities = myOrderAllInnerEntities;
	}
	
	
	
	public String getShopName() {
		return ShopName;
	}
	public void setShopName(String shopName) {
		ShopName = shopName;
	}
	public String getTransactionStatus() {
		return TransactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		TransactionStatus = transactionStatus;
	}
	public ArrayList<MyOrderAllInnerEntity> getMyOrderAllInnerEntities() {
		return myOrderAllInnerEntities;
	}
	public void setMyOrderAllInnerEntities(
			ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities) {
		this.myOrderAllInnerEntities = myOrderAllInnerEntities;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "MyOrderAllEntity [ShopName=" + ShopName
				+ ", TransactionStatus=" + TransactionStatus
				+ ", myOrderAllInnerEntities=" + myOrderAllInnerEntities + "]";
	}

	
	
	



}
