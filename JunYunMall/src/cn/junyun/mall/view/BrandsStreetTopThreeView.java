package cn.junyun.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
/**
 *brands_street中头部广告位    第3格 
 *269:271（宽高）
 */
public class BrandsStreetTopThreeView extends ImageView{

	public BrandsStreetTopThreeView(Context context) {
		super(context);
	}
	public BrandsStreetTopThreeView(Context context, AttributeSet attrs
			) {
		super(context, attrs);
	}
	public BrandsStreetTopThreeView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	@SuppressWarnings("unused")

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		int childWidthSize = getMeasuredWidth();
		int childHeightSize = getMeasuredHeight();
		// 宽度
		widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize/2,
				MeasureSpec.EXACTLY);
		// 高度
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(
				(int) (childWidthSize/2*270/270), MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
