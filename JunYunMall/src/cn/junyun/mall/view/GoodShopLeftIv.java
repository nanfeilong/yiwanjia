package cn.junyun.mall.view;
/**
 * 今日好点
 * 左一图片
 * 588:558（宽高比）
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class GoodShopLeftIv extends ImageView{

	public GoodShopLeftIv(Context context) {
		super(context);
	}
	public GoodShopLeftIv(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public GoodShopLeftIv(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		int childWidthSize = getMeasuredWidth();
		int childHeightSize = getMeasuredHeight();
		// 宽度
		widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize*196/360,
				MeasureSpec.EXACTLY);
		// 高度
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(
				(int) (childWidthSize*558/588), MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}
