package cn.junyun.mall.view;

import cn.junyun.mall.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 自定义底部菜单按钮
 * @author Administrator
 * @date 2016年6月24日
 * Created by wangxiaojing on 2016/6/25.
 */
public class CheckImageText extends LinearLayout implements Checkable {
    
    private boolean mChecked;
    private Drawable mTopImageDrawable;
    private Drawable mTopImageDrawableChecked;
    private int mDrawableWidth;
    private int mDrawableHeight;
    private int mTextSize;
    private String mText;
    private int mTextNomalColor;
    private int mCheckedTextColor;
    private int colorTextCheck=getResources().getColor(R.color.text_check);
    
    private ImageView mImageView;
    private TextView mTextView;
    
    public CheckImageText(Context context) {
        super(context);
    }
    
    public CheckImageText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.CheckImageTextStyle);
        mTopImageDrawable = typedArray.getDrawable(R.styleable.CheckImageTextStyle_imageDrawable);
        mTopImageDrawableChecked = typedArray.getDrawable(R.styleable.CheckImageTextStyle_imageDrawableChecked);
        mDrawableWidth = typedArray.getDimensionPixelOffset(R.styleable.CheckImageTextStyle_drawableWidth, 0);
        mDrawableHeight = typedArray.getDimensionPixelOffset(R.styleable.CheckImageTextStyle_drawableHeight, 0);
        mTextSize = typedArray.getDimensionPixelOffset(R.styleable.CheckImageTextStyle_textSize, 0);
        mText = typedArray.getString(R.styleable.CheckImageTextStyle_text);
        mTextNomalColor = typedArray.getColor(R.styleable.CheckImageTextStyle_textNomalColor, Color.WHITE);
        mChecked = typedArray.getBoolean(R.styleable.CheckImageTextStyle_checked, false);
        mCheckedTextColor = typedArray.getColor(R.styleable.CheckImageTextStyle_checkedTextColor, colorTextCheck);
        
        mImageView = new ImageView(context);
        mImageView.setLayoutParams(new LinearLayout.LayoutParams( mDrawableWidth, mDrawableHeight));
        mImageView.setImageDrawable(mChecked ? mTopImageDrawableChecked : mTopImageDrawable);
        mTextView = new TextView(context);
        mTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        mTextView.setText(mText);
        mTextView.setTextColor(mChecked ? mCheckedTextColor : mTextNomalColor);
        setChecked(mChecked);
        addView(mImageView);
        addView(mTextView);
    }
    public void toggle() {
        setChecked(!mChecked);
    }
    
    @Override
    public void setChecked(boolean checked) {
        if(mChecked != checked){
            mChecked = checked;
            mImageView.setImageDrawable(mChecked ? mTopImageDrawableChecked : mTopImageDrawable);
            mTextView.setTextColor(mChecked ? mCheckedTextColor : mTextNomalColor);
        }
    }
    
    @Override
    public boolean isChecked() {
        return mChecked;
    }
}
