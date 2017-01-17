package cn.junyun.mall.activity.order;

import org.xutils.view.annotation.ContentView;
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
 * 申请退款
 * @author NanFeiLong
 * @date 2016年8月31日
 */
@ContentView(R.layout.activity_apply_for_refund)
public class ApplyForRefundActivity extends BaseActivity {
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

	@Override
	protected void fillView() {
		// TODO Auto-generated method stub
		super.fillView();
		mBackTv.setText(getResources().getString(R.string.str_tv_alter_address));// 设置成收货地址管理标题
		mBackBt.setVisibility(View.VISIBLE);// 返回箭头可见
		mBackBt.setBackgroundResource(R.drawable.back);// 设置返回箭头图片
	}

}
