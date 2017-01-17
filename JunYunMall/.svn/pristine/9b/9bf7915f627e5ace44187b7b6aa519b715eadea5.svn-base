package cn.junyun.mall.activity.myproperty;

import org.xutils.view.annotation.ContentView;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.base.BaseActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * 我的商城--我的财产
 * @author Administrator
 * @date 2016年8月17日
 */
@ContentView(R.layout.activity_my_property)
public class MyPropertyActivity extends BaseActivity {

	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt; //我的订单--->返回箭头
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;//我的订单--->顶部“我的订单”标题

	@Override
	protected void fillView() {
		// TODO Auto-generated method stub
		super.fillView();
		mBackTv.setText(getResources().getString(R.string.str_tv_mymall_myproperty));//设置成我的财产标题
		mBackBt.setVisibility(View.VISIBLE);//返回箭头可见
		mBackBt.setBackgroundResource(R.drawable.back);//设置返回箭头图片
	}


	/**
	 * 返回"箭头"点击方法
	 * @param view
	 * @date 2016年8月3日
	 */

	@Event(value={R.id.btnHeaderBack,R.id.back_tv},type=View.OnClickListener.class)
	private void mBackBt(View view) {
		finish();
	}

}
