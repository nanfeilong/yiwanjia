package cn.junyun.mall.activity.home.fragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.home.HomeTabActivity;
import cn.junyun.mall.activity.member.LoginActivity;
import cn.junyun.mall.activity.myaccount.MyAccountActivity;
import cn.junyun.mall.activity.myachievement.MyAchievementActivity;
import cn.junyun.mall.activity.mycollect.MyCollectActivity;
import cn.junyun.mall.activity.myfootprint.MyFootPrintActivity;
import cn.junyun.mall.activity.myproperty.MyPropertyActivity;
import cn.junyun.mall.activity.mywallet.MyWalletActivity;
import cn.junyun.mall.activity.order.ReturnGoodsActivity;
import cn.junyun.mall.base.BaseFragment;
import cn.junyun.mall.comutil.FileUtill;

/**
 * 我的商城
 */
@ContentView(R.layout.fragment_mymall)
public class MyMallFragment extends BaseFragment {
	//我的订单右侧箭头
	@ViewInject(R.id.iv_next_page)
	private ImageView mOrderIm;
	//待付款
	@ViewInject(R.id.btn_wait_pay_money)
	private Button mWaitPayMoneyBt; 
	//待发货
	@ViewInject(R.id.btn_wait_send_goods)
	private Button mWaitSendGoodsBt; 
	//待收货
	@ViewInject(R.id.btn_wait_receive_goods)
	private Button mWaitReceivesGoodsBt;
	 //待评价
	@ViewInject(R.id.btn_wait_comment)
	private Button mWaitCommentBt;
	//退换货
	@	ViewInject(R.id.btn_return_goods)
	private Button mReturnGoodsBt; 
	 //我的订单整个“item”添加点击
	@ViewInject(R.id.rlayout_mymall_order)
	private RelativeLayout mMyOrderRl;
	//我的商城---我的账户
	@ViewInject(R.id.rl_mymall_myaccount)
	private RelativeLayout mMyAccountRl;  
	//我的商城--我的钱包
	@ViewInject(R.id.rl_mymall_mywallet)
	private RelativeLayout mMyWalletRl;  
	//我的商城--我的财产
	@ViewInject(R.id.rl_mymall_myproperty)
	private RelativeLayout mMyPropertyRl;
	//我的商城--我的成就
	@ViewInject(R.id.rl_mymall_myachievement)
	private RelativeLayout mMyAchievementRl;
	//我的商城--我的收藏
	@ViewInject(R.id.rl_mymall_mycollect)
	private RelativeLayout mMyCollectRl;
	//我的商城--我的足迹
	@ViewInject(R.id.rl_mymall_myfootprint)
	private RelativeLayout mMyFootPrintRl;
	//圆形图片
	@ViewInject(R.id.iv_head)
	private  ImageView iv_head; 
	//顶部
	@ViewInject(R.id.relativeLayout_mymall_top)
	private RelativeLayout mMyMallTopRl;

	private Bitmap photo;  //保存头像的Bitmap对象
	private Bitmap photo1;  //保存修改传递过来的头像的Bitmap对象


	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		if(hidden){
			((HomeTabActivity)getActivity()).dismissProgressBar();   
		}
	}

	/**
	 * 作用是当界面加载时，默认显示上一次自定义的头像图片
	 */
	@Override
	protected void fillView() {
		// TODO Auto-generated method stub
		photo = FileUtill.readerByteArrayToSD(); //读取保存的图片
		if (photo != null) {
			iv_head.setImageBitmap(photo);
		}
		else {
			iv_head.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
		}
	}
	/**
	 * 我的商城--用户头像(如果没有登录的话点击可登录登录)
	 * @param view
	 * @date 2016年8月3日
	 */
	@Event(R.id.iv_head) 
	private void mLogin(View view){
		if(true){ //这里将来判断是否登录，如果没有登录点击则跳转登录界面
			Intent intent = new Intent(getActivity(), LoginActivity.class);
			startActivity(intent);
		}
	}


	/**
	 * 我的订单
	 * @param view
	 * @date 2016年8月2日
	 */
	@Event(R.id.rlayout_mymall_order)
	private void mMyOrderRl(View view){
		intentToMyOrderActivity(0);
	}
	/**
	 * 我的商城-->待付款
	 * @param v
	 * @date 2016年7月31日
	 */
	@Event(R.id.btn_wait_pay_money)
	private void waitPayMoneyClick(View view) {
		intentToMyOrderActivity(1);
	}
	/**
	 * 我的商城-->待发货
	 * @param v
	 * @date 2016年7月31日
	 */
	@Event(R.id.btn_wait_send_goods)
	private void waitSendGoodsClick(View view) {
		intentToMyOrderActivity(2);
	}

	/**
	 * 我的商城-->待收货
	 * @param view
	 * @date 2016年7月31日
	 */
	@Event(R.id.btn_wait_receive_goods)
	private void waitReceiveGoodsClick(View view) {
		intentToMyOrderActivity(3);
	}
	/**
	 * 我的商城-->待评价
	 * @param view
	 * @date 2016年7月31日
	 */
	@Event(R.id.btn_wait_comment)
	private void waitCommentClick(View view){
		intentToMyOrderActivity(4);
	}
	/**
	 * 我的商城-->退换货
	 * @param view
	 * @date 2016年7月31日
	 */
	@Event(R.id.btn_return_goods)
	private void returnGoodsClick(View view) {
		Intent intent = new Intent(getActivity(),ReturnGoodsActivity.class);
		startActivity(intent);
		
	}

	/**
	 * 我的商城---我的账户
	 * @param view
	 * @date 2016年8月9日
	 */
	@Event(R.id.rl_mymall_myaccount)
	private void mMyAccountRl(View view) {
		Intent intent = new Intent(getActivity(), MyAccountActivity.class);
		startActivityForResult(intent, 10);

	}
	/**
	 * 我的商城---我的钱包
	 * @param view
	 * @date 2016年8月17日
	 */
	@Event(R.id.rl_mymall_mywallet)
	private void mMyWalletRl(View view) {
		Intent intent = new Intent(getActivity(), MyWalletActivity.class);
		startActivity(intent);
	}

	/**
	 * 我的商城---我的财产
	 * @param view
	 * @date 2016年8月17日
	 */
	@Event(R.id.rl_mymall_myproperty)
	private void mMyPropertyRl(View view) {
		Intent intent = new Intent(getActivity(), MyPropertyActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 我的商城---我的成就
	 * @param view
	 * @date 2016年8月17日
	 */
	@Event(R.id.rl_mymall_myachievement)
	private void mMyAchievementRl(View view) {
		Intent intent = new Intent(getActivity(), MyAchievementActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 我的商城---我的收藏
	 * @param view
	 * @date 2016年8月23日
	 */
	@Event(R.id.rl_mymall_mycollect)
	private void mMyCollectRl(View view) {
		Intent intent = new Intent(getActivity(), MyCollectActivity.class);
		startActivity(intent);
	}
	/**
	 * 我的商城--我的足迹
	 * @param view
	 * @date 2016年8月23日
	 */
	@Event(R.id.rl_mymall_myfootprint)
	private void mMyFootPrintRl(View view) {
		Intent intent = new Intent(getActivity(), MyFootPrintActivity.class);
		startActivity(intent);
	}

	
	
	/**
	 * 更换头像方面的回调
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == 10&&	requestCode == 10){
				photo1 = data.getParcelableExtra("head");
				photo1 = FileUtill.readerByteArrayToSD(); //读取保存的图片
				if (photo1 != null) {
					iv_head.setImageBitmap(photo1);
				}
				else {
					iv_head.setImageBitmap(photo);
				}
		
			
		}
	}


}
