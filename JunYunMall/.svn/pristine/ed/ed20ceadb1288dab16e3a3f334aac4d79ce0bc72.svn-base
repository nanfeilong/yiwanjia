package cn.junyun.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
/**
 * 豆豆商城换购item上的图片
 * @author Administrator
 *330:330
 */

public class DouDouHuanGouIv extends ImageView{


	public DouDouHuanGouIv(Context context, AttributeSet attrs) {
		super(context, attrs );
	}
	public DouDouHuanGouIv(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	public DouDouHuanGouIv(Context context) {
		super(context);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		int childWidthSize = getMeasuredWidth();
		int childHeightSize = getMeasuredHeight();
		// 宽度
		widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize*32/100,
				MeasureSpec.EXACTLY);
		// 高度
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(
				(int) (childWidthSize*32/100), MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}


}
