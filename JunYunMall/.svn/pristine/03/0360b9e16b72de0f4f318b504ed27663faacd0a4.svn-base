package cn.junyun.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

public class AddressListView  extends ListView{
	
	private int mMaxOverDistance = 100;
	private Context mContext;
	
	public AddressListView(Context context ) {
		super(context);
		mContext = context;
		initView();
		
	}
	public AddressListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView();
	}

	public AddressListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		initView();
	}
	
	
	
	 @Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
			int scrollY, int scrollRangeX, int scrollRangeY,
			int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
		// TODO Auto-generated method stub
		return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX,
				scrollRangeY, maxOverScrollX, mMaxOverDistance, isTouchEvent);
	}
	 
	 private void initView(){
		 DisplayMetrics metris = mContext.getResources().getDisplayMetrics();
		 float density = metris.density;
		 mMaxOverDistance = (int)(density*mMaxOverDistance);
		 
		 
	 }

}
