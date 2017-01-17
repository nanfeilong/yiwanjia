package cn.junyun.mall.view;
/*
 * 豆豆商城第5	个图片
 * 330:360
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class DouDouMall5 extends ImageView{
	public DouDouMall5(Context context) {
		super(context);
	}
	public DouDouMall5(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public DouDouMall5(Context context, AttributeSet attrs, int defStyle) {
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
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(

				(int) ((childWidthSize-10)*360/330), MeasureSpec.EXACTLY);

				//(int) ((childWidthSize)*360/330), MeasureSpec.EXACTLY);

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
