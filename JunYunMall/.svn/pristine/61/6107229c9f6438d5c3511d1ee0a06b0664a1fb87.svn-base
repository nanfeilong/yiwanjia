package cn.junyun.mall.view;
/**
 * 新品上架阴影
 * 178:21
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class ArrivalHint extends View{

	public ArrivalHint(Context context) {
		super(context);
	}
	public ArrivalHint(Context context, AttributeSet attrs  ) {
		super(context, attrs );
	}
	public ArrivalHint(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
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
		heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) childWidthSize*21/178,
				MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
