package cn.junyun.mall.activity.myaccount;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.base.BaseActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@ContentView(R.layout.activity_address_new)
public class AddressNewActivity extends BaseActivity {
	/**
	 * 返回"箭头"点击方法
	 * @param view
	 * @date 2016年8月3日
	 */
	// 收货地址管理--->返回箭头
	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt;
	// 收货地址管理--->顶部“收货地址管理”标题
	@ViewInject(R.id.back_tv)
	private TextView mBackTv;
	//添加新地址--保存button
	@ViewInject(R.id.btnHeaderExtra)
	private Button mSaveAddressBt;


	@Override
	protected void fillView() {
		// TODO Auto-generated method stub
		super.fillView();
		Intent intent = getIntent();
		int edit  =	intent.getIntExtra("editAddress", 0);//如果获取不到，就给一个默认值0
		if(edit == 25){ //如果是点击“编辑”跳过来的，则将标题设置成“修改地址” 否则就是"添加新地址"
			mBackTv.setText(getResources().getString(R.string.str_tv_alter_address));// 设置成收货地址管理标题
		} else{
			mBackTv.setText(getResources().getString(
					R.string.str_tv_myaccount_new_address));// 设置添加新地址管理标题
		}
		mBackBt.setVisibility(View.VISIBLE);// 返回箭头可见
		mBackBt.setBackgroundResource(R.drawable.back);// 设置返回箭头图片
		mSaveAddressBt.setVisibility(View.VISIBLE);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		params.setMarginEnd(dip2px(12)); 
		mSaveAddressBt.setLayoutParams(params);
		mSaveAddressBt.setText("保存");
		mSaveAddressBt.setTextColor(Color.RED);
		mSaveAddressBt.setBackground(null);
	}



	/**
	 * 返回"箭头"点击方法
	 * @param view
	 * @date 2016年8月3日
	 */

	@Event(value = { R.id.btnHeaderBack, R.id.back_tv }, type = View.OnClickListener.class)
	private void mBackBt(View view) {
		finish();
	}
	/**
	 * 保存
	 * @param view
	 * @date 2016年8月31日
	 */
	@Event(R.id.btnHeaderExtra)
	private void mSaveAddressBt(View view) {
		toast("呵呵 哈哈");
	}
	/**
	 * 选择地区点击事件
	 * 
	 */
	@Event(R.id.rl_inthe_area)
	private void toSelectAddressActivity(View view) {
		startActivity(new Intent(this,ProviceAddressSelectActivity.class));
		
	}
	
	


}
