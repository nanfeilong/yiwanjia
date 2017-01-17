package cn.junyun.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * 图片比例（720:296）
 */
public class RelayoutMyMallTopa extends RelativeLayout {
	public RelayoutMyMallTopa(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public RelayoutMyMallTopa(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public RelayoutMyMallTopa(Context context) {
		super(context);
	}

	@SuppressWarnings("unused")
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// For simple implementation, or internal size is always 0.
		// We depend on the container to specify the layout size of
		// our view. We can't really know what it is since we will be
		// adding and removing different arbitrary views and do not
		// want the layout to change as this happens.
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		// Children are just made to fill our space.
		int childWidthSize = getMeasuredWidth();
		int childHeightSize = getMeasuredHeight();
		// 宽度
		widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize,
				MeasureSpec.EXACTLY);
		// 高度
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(
				(int) (childWidthSize*296 / 720), MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
	}
	
	

}
