package cn.junyun.mall.base;

import org.xutils.x;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.junyun.mall.R;

public abstract class BaseActivity extends FragmentActivity {
	private Context mContext;

	protected Long mLastDoTime = System.currentTimeMillis();

	private FrameLayout mRootFrameLayout;
	public ProgressBar mProgressBar;

	// @ViewInject(R.id.btnHeaderExtra)
	Button mExtraButton; // 右自定义按钮

	// @ViewInject(R.id.btnHeaderBack)
	Button mBackButton; // 左自定义按钮

	// @ViewInject(R.id.tvHeaderTitle)
	TextView mTitle; // 自定义标题

	public int mWidth;// 屏幕的宽度，
	public int mHeight;// 屏幕的高度

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		mContext = this;

		WindowManager wm = this.getWindowManager();

		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		mWidth = metric.widthPixels; // 屏幕宽度（像素）
		mHeight = metric.heightPixels;// 屏幕高度（像素）

		// 再次绑定View，凡是继承此Activity就不需要再次绑定
		x.view().inject(this);
		fillView();
		loadData();
		setListener();

		//透明状态栏  
			//	getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

		//		/*
		//		 *透明状态栏。  4.4.2以上使用
		//		 */
		//		if(Build.VERSION.SDK_INT>=19){
		//			//透明状态栏  
		//			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); 
		//		}

	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	/**
	 * 创建title赋值
	 */
	public void setTitle(String title) {
		if (!TextUtils.isEmpty(title) && mTitle != null) {
			mTitle.setText(title);
		}
	}

	/**
	 * your <code>findViewById(int id)</code> in here.
	 */

	protected void fillView() {

		mExtraButton = (Button) findViewById(R.id.btnHeaderExtra);
		mBackButton = (Button) findViewById(R.id.btnHeaderBack);
		mTitle = (TextView) findViewById(R.id.tvHeaderTitle);

	}

	protected void setListener() {
	}

	/*
	 * 加载数据
	 */
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
	 * 吐丝的方法
	 * 
	 * @param msg
	 */
	public void toast(String msg) {
		if (TextUtils.isEmpty(msg) || TextUtils.isEmpty(msg.trim())) {
			return;
		}
		Toast.makeText(this, msg, 1).show();
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
	 * 在屏幕中间显示风火轮
	 */
	public void showProgressBar() {
		mRootFrameLayout = (FrameLayout) findViewById(android.R.id.content);
		FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.gravity = Gravity.CENTER;
		mProgressBar = new ProgressBar(mContext);
		mProgressBar.setLayoutParams(layoutParams);
		mProgressBar.setVisibility(View.VISIBLE);
		mRootFrameLayout.addView(mProgressBar);
	}

	/**
	 * 隐藏风火轮
	 */
	public void dismissProgressBar() {
		if (null != mProgressBar && null != mRootFrameLayout) {
			mRootFrameLayout.removeView(mProgressBar);
		}
	}

	@Override
	public void finish() {
		super.finish();
		dismissProgressBar();
	}
}
