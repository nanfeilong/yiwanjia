package cn.junyun.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
/**
 * 品牌街自适应
 *
 */
public class PinPaiJieView extends ImageView{


	public PinPaiJieView(Context context) {
		super(context);
	}
	public PinPaiJieView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public PinPaiJieView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	@SuppressWarnings("unused")

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		int childWidthSize = getMeasuredWidth();
		int childHeightSize = getMeasuredHeight();
		// 宽度
		widthMeasureSpec = MeasureSpec.makeMeasureSpec((int) (childWidthSize*1),
				MeasureSpec.EXACTLY);
		// 高度
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(
				(int) (childWidthSize*0.5), MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
