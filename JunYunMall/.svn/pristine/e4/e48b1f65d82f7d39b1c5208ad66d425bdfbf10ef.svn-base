package cn.junyun.mall.view;
/**
 * homeList第四章图片自适应
 * 357:372宽高比
 * 
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class HomeListIvFourView extends ImageView{

	public HomeListIvFourView(Context context) {
		super(context);
	}
	public HomeListIvFourView(Context context, AttributeSet attrs
			) {
		super(context, attrs);
	}
	public HomeListIvFourView(Context context, AttributeSet attrs,
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
		widthMeasureSpec = MeasureSpec.makeMeasureSpec((int) (childWidthSize*0.333333),
				MeasureSpec.EXACTLY);
		// 高度
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(
				(int) (childWidthSize*0.3333333*372/357), MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
