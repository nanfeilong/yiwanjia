package cn.junyun.mall.view;
/*
 * 豆豆商城第4个图片
 * 
330:360
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class DouDouMall4 extends ImageView{
	public DouDouMall4(Context context) {
		super(context);
	}
	public DouDouMall4(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public DouDouMall4(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		int childWidthSize = getMeasuredWidth();
		int childHeightSize = getMeasuredHeight();
		// 宽度
		widthMeasureSpec = MeasureSpec.makeMeasureSpec((childWidthSize-10)/2,
				MeasureSpec.EXACTLY);
		// 高度
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(
				(int) (((childWidthSize-10)/2)*360/330), MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
