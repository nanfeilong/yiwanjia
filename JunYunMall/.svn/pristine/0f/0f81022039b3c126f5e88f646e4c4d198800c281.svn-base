package cn.junyun.mall.base;


import java.lang.reflect.Field;

import org.xutils.x;

import cn.junyun.mall.activity.order.MyOrderActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Fragment的基类
 * 
 * @version 1.0
 * 
 */



public abstract class BaseFragment extends Fragment {
	public View mView;
	protected Long mLastDoTime = System.currentTimeMillis();

	public ProgressBar mProgressBar;

	private boolean injected = false;
	public int mWidth;// 屏幕的宽度，
	public int mHeight;//屏幕的高度
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		WindowManager wm = getActivity().getWindowManager();

		DisplayMetrics metric = new DisplayMetrics();

		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		mWidth = metric.widthPixels; // 屏幕宽度（像素）
		mHeight = metric.heightPixels;//屏幕高度（像素）

		fillView();
		setListener();
		loadData();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (!injected) {
			x.view().inject(this, this.getView());
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


		injected = true;
		return x.view().inject(this, inflater, container);

	}


	protected void fillView() {
	}

	protected void setListener() {
	}

	protected void loadData() {
	}


	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public int dip2px(float dpValue) {
		final float scale = getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 防止二次点击
	 *
	 * @return
	 */
	protected boolean isTooFaster() {
		Long betweenTime = System.currentTimeMillis() - mLastDoTime;
		mLastDoTime = System.currentTimeMillis();
		return betweenTime < 1000;
	}

	/**
	 * 吐丝的方法
	 * @param msg
	 */
	protected void toast(String msg) {
		if(TextUtils.isEmpty(msg.trim())){
			return;
		}
		Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 跳转到我的订单activity并且传递索引值的方法
	 * @param position
	 * @date 2016年8月9日
	 */
	protected void intentToMyOrderActivity(int position) {
		Intent intent = new Intent(getActivity(),MyOrderActivity.class);
		intent.putExtra("myorder_position", position);
		startActivity(intent);
	}
	
	
	/**
	 * 获取状态栏高度的方法
	 * @return 
	 * @date 2016年8月7日
	 */
	public int getStatusBarHeight() {  
		Class<?> c = null;  
		Object obj = null;  
		Field field = null;  
		int x = 0, sbar = 0;  
		try {  
			c = Class.forName("com.android.internal.R$dimen");  
			obj = c.newInstance();  
			field = c.getField("status_bar_height");  
			x = Integer.parseInt(field.get(obj).toString());  
			sbar = getResources().getDimensionPixelSize(x);  
		} catch (Exception e1) {  
			e1.printStackTrace();  
		}  

		return sbar;  
	}  

	

}
