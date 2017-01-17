package cn.junyun.mall.view;

import cn.junyun.mall.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ImageViewCircle extends ImageView {
	/**
	 * 缩放类型
	 * 按比例扩大图片的size居中显示，使得图片长(宽)等于或大于View的长(宽) 
	 */
	private static final ScaleType SCALE_TYPE = ScaleType.CENTER_CROP;
	/**
	 * 
	 * 位图配置
	 * ARGB_8888代表
	 * A:透明度:8
	 * R:红色:8
	 * G:绿:8
	 * B:蓝:8
	 * 表示图片每个像素点占8+8+8+8 = 32位
	 * ARGB_4444 代表16位ARGB位图
	 * RGB_565 代表8位RGB位图
	 * ALPHA_8就是Alpha由8位组成
	 * 位图位数越高代表其可以存储的颜色信息越多，当然图像也就越逼真。也会更占内存
	 * 根据内存优化和用途选择合适的
	 */
	private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.RGB_565;
	private static final int COLORDRAWABLE_DIMENSION = 1;

	private static final int DEFAULT_BORDER_WIDTH = 0; //默认边框宽度
	private static final int DEFAULT_BORDER_COLOR = Color.BLACK;//默认边框颜色

	private final RectF mDrawableRect = new RectF();
	private final RectF mBorderRect = new RectF();

	private final Matrix mShaderMatrix = new Matrix();
	private final Paint mBitmapPaint = new Paint();
	private final Paint mBorderPaint = new Paint();

	private int mBorderColor = DEFAULT_BORDER_COLOR;
	private int mBorderWidth = DEFAULT_BORDER_WIDTH;

	private Bitmap mBitmap;
	private BitmapShader mBitmapShader;// 位图渲染
	private int mBitmapWidth;// 位图宽度
	private int mBitmapHeight;// 位图高度

	private float mDrawableRadius;// 图片半径
	private float mBorderRadius;// 带边框的的图片半径

	private boolean mReady;
	private boolean mSetupPending;
	

	public ImageViewCircle(Context context) {
		super(context);
	}

	public ImageViewCircle(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	//自定义view 必须要写的方法
	public ImageViewCircle(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		//图片压缩方式
		super.setScaleType(SCALE_TYPE);
		//res/values/attrs/...
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageViewCircle, defStyle, 0);
		//图片边框线条粗细// 获取边界的宽度
		mBorderWidth = a.getDimensionPixelSize(R.styleable.ImageViewCircle_border_width, DEFAULT_BORDER_WIDTH);
		//图片边框线条颜色// 获取边界的颜色
		mBorderColor = a.getColor(R.styleable.ImageViewCircle_border_color, DEFAULT_BORDER_COLOR);
		// 回收TypedArray,以便后面重用
		a.recycle();

		mReady = true;

		if (mSetupPending) {
			setup();
			mSetupPending = false;
		}
	}

	@Override
	public ScaleType getScaleType() {
		//获取图片缩放方式 并返回
		return SCALE_TYPE;
	}

	/**
	 * 设置图片缩放方式
	 */
	@Override
	public void setScaleType(ScaleType scaleType) {
		if (scaleType != SCALE_TYPE) {//如果不等于我们指定的方式
			throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (getDrawable() == null) {
			return;
		}
		// 绘制圆形图片
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, mDrawableRadius, mBitmapPaint);
		if(mBorderWidth != 0){// 如果边框不为0，则绘制带边框的圆形图片
			canvas.drawCircle(getWidth() / 2, getHeight() / 2, mBorderRadius, mBorderPaint);
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		setup();
	}

	public int getBorderColor() {
		return mBorderColor;
	}

	public void setBorderColor(int borderColor) {
		if (borderColor == mBorderColor) {
			return;
		}

		mBorderColor = borderColor;
		mBorderPaint.setColor(mBorderColor);
		invalidate();
	}

	public int getBorderWidth() {
		return mBorderWidth;
	}

	public void setBorderWidth(int borderWidth) {
		if (borderWidth == mBorderWidth) {
			return;
		}

		mBorderWidth = borderWidth;
		setup();
	}

	@Override
	public void setImageBitmap(Bitmap bm) {
		super.setImageBitmap(bm);
		mBitmap = bm;
		setup();
	}

	@Override
	public void setImageDrawable(Drawable drawable) {
		super.setImageDrawable(drawable);
		mBitmap = getBitmapFromDrawable(drawable);
		setup();
	}

	@Override
	public void setImageResource(int resId) {
		super.setImageResource(resId);
		mBitmap = getBitmapFromDrawable(getDrawable());
		setup();
	}
	/**
	 * Drawable转Bitmap
	 * @param drawable
	 * @return
	 */
	private Bitmap getBitmapFromDrawable(Drawable drawable) {
		if (drawable == null) {
			return null;
		}

		if (drawable instanceof BitmapDrawable) {
			return ((BitmapDrawable) drawable).getBitmap();
		}

		try {
			Bitmap bitmap;

			if (drawable instanceof ColorDrawable) { //如果drawable 是 ColorDrawable的一个实例，返回true
				bitmap = Bitmap.createBitmap(COLORDRAWABLE_DIMENSION, COLORDRAWABLE_DIMENSION, BITMAP_CONFIG);
			} else { //如果drawable 不是 ColorDrawable的一个实例，或者为null，则返回flase
				bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
			}

			Canvas canvas = new Canvas(bitmap);
			drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
			drawable.draw(canvas);
			return bitmap;
		} catch (OutOfMemoryError e) {
			return null;
		}
	}

	private void setup() {
		if (!mReady) {
			mSetupPending = true;
			return;
		}

		if (mBitmap == null) {
			return;
		}
		// 构建渲染器
		mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
		// 设置反锯齿
		mBitmapPaint.setAntiAlias(true);
		// 设置画笔渲染器
		mBitmapPaint.setShader(mBitmapShader);
		// 设置画笔样式
		mBorderPaint.setStyle(Paint.Style.STROKE);
		mBorderPaint.setAntiAlias(true);
		mBorderPaint.setColor(mBorderColor);
		mBorderPaint.setStrokeWidth(mBorderWidth);
		// 得到位图宽高
		mBitmapHeight = mBitmap.getHeight();
		mBitmapWidth = mBitmap.getWidth();
		// 设置含边框显示区域
		mBorderRect.set(0, 0, getWidth(), getHeight());
		// 计算半径
		mBorderRadius = Math.min((mBorderRect.height() - mBorderWidth) / 2, (mBorderRect.width() - mBorderWidth) / 2);
		// 设置图片显示区域：即View的大小区域减去边界的大小
		mDrawableRect.set(mBorderWidth, mBorderWidth, mBorderRect.width() - mBorderWidth, mBorderRect.height() - mBorderWidth);
		// 计算图片区域的半径
		mDrawableRadius = Math.min(mDrawableRect.height() / 2, mDrawableRect.width() / 2);

		updateShaderMatrix();
		invalidate();
	}

	private void updateShaderMatrix() {
		float scale;
		float dx = 0;
		float dy = 0;

		mShaderMatrix.set(null);
		// 如果位图的高度*显示图片区域的高度 大于 位图高度 * 图片区域宽度
		if (mBitmapWidth * mDrawableRect.height() > mDrawableRect.width() * mBitmapHeight) {
			// 按高计算缩放比例
			scale = mDrawableRect.height() / (float) mBitmapHeight;
			dx = (mDrawableRect.width() - mBitmapWidth * scale) * 0.5f;
		} else {
			// 按宽计算缩放比例
			scale = mDrawableRect.width() / (float) mBitmapWidth;
			dy = (mDrawableRect.height() - mBitmapHeight * scale) * 0.5f;
		}
		// shaeder的变换矩阵，我们这里主要用于放大或者缩小。
		mShaderMatrix.setScale(scale, scale);
		// 平移
		mShaderMatrix.postTranslate((int) (dx + 0.5f) + mBorderWidth, (int) (dy + 0.5f) + mBorderWidth);
		// 设置变换矩阵
		mBitmapShader.setLocalMatrix(mShaderMatrix);
	}

}
