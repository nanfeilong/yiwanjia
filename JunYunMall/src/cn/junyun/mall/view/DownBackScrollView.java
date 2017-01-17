package cn.junyun.mall.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.MonthDisplayHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * 我的商城界面 下拉弹回效果
 * @author NanFeiLong
 * @date 2016年8月16日
 */
public class DownBackScrollView extends ScrollView {
	// 根布局视图
	private View mRootView;
	// 原始根视图对应的位置
	private int mpreY = 0;
	private Rect mNormalRect;

	public DownBackScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public DownBackScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public DownBackScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 该方法不能去掉 会报空指针
	 */
	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		mRootView = getChildAt(0);
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		float curY = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			try {
				if(mRootView != null) {
					mNormalRect = new Rect(mRootView.getLeft(), mRootView.getTop(),
							mRootView.getRight(), mRootView.getBottom());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case MotionEvent.ACTION_MOVE:
			try {
				int delta = (int) ((curY - mpreY) * 0.25);
				if (delta > 0) {
					mRootView.layout(mRootView.getLeft(), mRootView.getTop()
							+ delta, mRootView.getRight(), mRootView.getBottom()
							+ delta);
				}else{
					mRootView.layout(mRootView.getLeft(), mRootView.getTop(), mRootView.getRight(), mRootView.getBottom());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case MotionEvent.ACTION_UP:
			try {
				int curTop = mRootView.getTop();
				mRootView.layout(mNormalRect.left, mNormalRect.top,mNormalRect.right, mNormalRect.bottom);
				TranslateAnimation animation = new TranslateAnimation(0, 0, curTop - mNormalRect.top, 0);
				animation.setDuration(200);
				mRootView.startAnimation(animation);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

		mpreY = (int) curY;
		return super.onTouchEvent(event);
	}

}
