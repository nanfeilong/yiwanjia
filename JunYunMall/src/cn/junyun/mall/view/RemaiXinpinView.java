package cn.junyun.mall.view;
/**
 * 今日特价模块的自适应
 * 图片比例（540:270）//宽高
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class RemaiXinpinView extends ImageView{

	public RemaiXinpinView(Context context) {
		super(context);
	}
	public RemaiXinpinView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public RemaiXinpinView(Context context, AttributeSet attrs, int defStyle) {
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
