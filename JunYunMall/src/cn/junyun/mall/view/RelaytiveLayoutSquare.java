package cn.junyun.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 宽高比例（1:1）-正方形
 */
public class RelaytiveLayoutSquare extends RelativeLayout {
	public RelaytiveLayoutSquare(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public RelaytiveLayoutSquare(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public RelaytiveLayoutSquare(Context context) {
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		int childWidthSize = getMeasuredWidth();
		int childHeightSize = getMeasuredHeight();
		// 宽度
		widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize,
				MeasureSpec.EXACTLY);
		// 高度
		heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) childWidthSize,
				MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}
