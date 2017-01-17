package cn.junyun.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
/*
 * 新品上架
 * 533:553
 */
public class ArrivalView extends ImageView{

	public ArrivalView(Context context) {
		super(context);
	}
	public ArrivalView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public ArrivalView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
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
		heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) childWidthSize*553/533,
				MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
