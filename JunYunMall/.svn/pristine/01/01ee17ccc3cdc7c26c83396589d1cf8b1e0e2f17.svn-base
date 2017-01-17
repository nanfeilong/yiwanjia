package cn.junyun.mall.activity.order.submit;

import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.adapter.myorderadapter.MakeSureOrderAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.MakeSureOrderEntity;
import cn.junyun.mall.model.MakeSureOrderInnerEntity;
import cn.junyun.mall.view.MyListView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

@ContentView(R.layout.activity_make_sure_order)
public class MakeSureOrderActivity extends BaseActivity {

	@ViewInject(R.id.use_bean_iv)
	private ImageView mUseBeanIv;// 使用万家豆
	@ViewInject(R.id.use_coupons_iv)
	private ImageView mUseCouponsIv;	// 使用优惠券
	@ViewInject(R.id.order_lv)
	private MyListView mOrderListView;	// 订单列表
	@ViewInject(R.id.scroll_view)
	private ScrollView mScrollV;	// 
	
	
	private ArrayList<MakeSureOrderEntity> mMakeSureOrderEntities = new ArrayList<MakeSureOrderEntity>();//订单结合
	private ArrayList<MakeSureOrderInnerEntity> mMakeSureOrderInnerEntities = new ArrayList<MakeSureOrderInnerEntity>();//订单内部列表集合
	private MakeSureOrderAdapter makeSureOrderAdapter;//确认订单适配器
	
	@Override
	protected void fillView() {
		mScrollV.smoothScrollBy(0, 0);
	}
	
	@Override
	protected void loadData() {
		
		
		initData();
		
		//初始化Adapter
		initAdapter();
		
	}
	
	
	
	
	
	/**
	 * 初始化Adapter的方法
	 */

	private void initAdapter() {
		 if(makeSureOrderAdapter == null){
			 makeSureOrderAdapter = new MakeSureOrderAdapter(mMakeSureOrderEntities, this);
			 mOrderListView.setAdapter(makeSureOrderAdapter);
		 }else{
			 makeSureOrderAdapter.notifyDataSetChanged();
		 }
		
	}







	/**
	 * 使用万佳豆点击按钮
	 */

	@Event(R.id.use_bean_iv)
	private void useBean(View v) {
		useBeanSwitch();
	}

	/**
	 * 使用优惠券点击按钮
	 */

	@Event(R.id.use_coupons_iv)
	private void useCoupons(View v) {
		useCouponsSwitch();
	}

	/**
	 * 使用万家豆切换效果
	 */

	private void useBeanSwitch() {
		mUseBeanIv.setImageResource(R.drawable.has_choose_icon);
		mUseCouponsIv.setImageResource(R.drawable.not_choose_icon);

	}

	/**
	 * 使用优惠券切换效果
	 */
	private void useCouponsSwitch() {
		mUseBeanIv.setImageResource(R.drawable.not_choose_icon);
		mUseCouponsIv.setImageResource(R.drawable.has_choose_icon);
	}
	
	/**
	 * 测试数据
	 */
	
	
	 private void initData(){
		 mMakeSureOrderInnerEntities.add(new MakeSureOrderInnerEntity("夏季款男装T恤迪欧发甲方", "黑色", "25寸", "150元"));
		 mMakeSureOrderInnerEntities.add(new MakeSureOrderInnerEntity("夏季款男装T恤迪欧发甲方", "黑色", "25寸", "150元"));
		 mMakeSureOrderInnerEntities.add(new MakeSureOrderInnerEntity("夏季款男装T恤迪欧发甲方", "黑色", "25寸", "150元"));
		 mMakeSureOrderInnerEntities.add(new MakeSureOrderInnerEntity("夏季款男装T恤迪欧发甲方", "黑色", "25寸", "150元"));
		 
		 
		 
		 mMakeSureOrderEntities.add(new MakeSureOrderEntity("天猫旗舰店", "圆通快递", mMakeSureOrderInnerEntities));
		 mMakeSureOrderEntities.add(new MakeSureOrderEntity("天猫旗舰店", "圆通快递", mMakeSureOrderInnerEntities));
		 mMakeSureOrderEntities.add(new MakeSureOrderEntity("天猫旗舰店", "圆通快递", mMakeSureOrderInnerEntities));
		 
		 
	 }
	 
	 /*
		 * 点击回退按钮
		 */
		@Event({R.id.back_iv,R.id.back_tv})
		private void back(View v) {
			finish();
		}

		
		
	 

}
