package cn.junyun.mall.activity.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import com.hhl.library.FlowTagLayout;
import com.hhl.library.OnTagSelectListener;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.order.submit.MakeSureOrderActivity;
import cn.junyun.mall.activity.product.fragment.BabyEvlationFragment;
import cn.junyun.mall.activity.product.fragment.GoodsDetailFragment;
import cn.junyun.mall.adapter.product.TagAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.view.ScrollViewExtend;
import cn.junyun.mall.view.ScrollViewExtend.OnScrollListener;
import cn.junyun.mall.view.ScrollViewListener;
import cn.junyun.mall.view.ZoomOutPageTransformer;

@ContentView(R.layout.activity_product_detail)
public class ProductDetailActivity extends BaseActivity implements
		ScrollViewListener, OnScrollListener {

	@ViewInject(R.id.viewpager)
	private ViewPager mViewPager;// ViewPAger
	@ViewInject(R.id.parent_view)
	private RelativeLayout mParentView;// 父布局
	@ViewInject(R.id.indicatorLayout)
	private LinearLayout indicatorLayout;// 页面指示器
	@ViewInject(R.id.scrView)
	private ScrollViewExtend mScrollV;// ScrollView
	@ViewInject(R.id.layout_header)
	private RelativeLayout mLayoutHeader;// 头部标题
	@ViewInject(R.id.crsh_col_tv)
	private TextView mMoneyDelete;// 带删除线的金额
	@ViewInject(R.id.webview)
	private WebView mWebView;// webView

	@ViewInject(R.id.detail_bt)
	private Button mGoodsDetailBt;// 商品详情
	@ViewInject(R.id.evaluation_bt)
	private Button mBabyEvlationBt;// 宝贝评价

	@ViewInject(R.id.menu_layout1)
	private LinearLayout mBMenuLayout1;// 标题栏容器1
	@ViewInject(R.id.menu_layout2)
	private LinearLayout mBMenuLayout2;// 标题栏容器2
	@ViewInject(R.id.choose_color_and_size_layout)
	private LinearLayout mChooseColorSize;// 选择颜色分类
	@ViewInject(R.id.menu_layout)
	private LinearLayout mMenu;// 标题栏内容

	// 红色线条
	@ViewInject(R.id.evlation_line_view)
	private View mBabyEvlationLine;// 宝贝评价
	@ViewInject(R.id.detail_line_view)
	private View mmGoodsDetailBtLine;// 商品详情
	@ViewInject(R.id.spilt_top_line)
	private View mSpiltTopLine;// 底部线条
	@ViewInject(R.id.spilt_bottom_line)
	private View mSpiltBottomLine;// 顶部线条
	@ViewInject(R.id.spaceView)
	private View mspaceView;// 空View

	@ViewInject(R.id.product_detail_frame_layout)
	private FrameLayout mFrameLayout;// 容器

	/** 记录上一个点的位置 */
	private int prePos;// 0

	PopupWindow mPopupWindowForSku;// 颜色尺码选择弹窗

	private LayoutInflater mInflater;

	List<String> colordataSource = new ArrayList<String>();
	List<String> sizedataSource = new ArrayList<String>();

	private TagAdapter<String> mSizeTagAdapter;// 尺寸选择适配器
	private TagAdapter<String> mColorTagAdapter;// 颜色选择适配器

	private PopViewHodlerForSku mPopViewHodlerForSku;// 绑定POPUWindow里面的数据的ViewHOlder

	FragmentManager mFragmentManager;

	private GoodsDetailFragment mGoosDetailFragment;// 商品详情
	private BabyEvlationFragment mBabyEvlationFragment;// 宝贝评价

	private int layoutTop;

	private boolean menuHasFixed = false;// 标题栏是否已经固定
	
	

	@Override
	protected void fillView() {
		mLayoutHeader.getBackground().setAlpha(0);// 设置默认颜色
		mMoneyDelete.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		mInflater = LayoutInflater.from(this);

		mFragmentManager = getSupportFragmentManager();

	}

	@Override
	protected void loadData() {
		mViewPager.setAdapter(new MyPagerAdapter());
		mViewPager.setOffscreenPageLimit(4);
		mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());

		// 3.添加监听器
		mViewPager.setOnPageChangeListener(new PagerListener());
		// 设置页面指示器
		setPagerIndicator();

		// 刚进入此页面
		setTabSelection(0);

	}

	@Override
	protected void setListener() {

		mScrollV.setScrollViewListener(ProductDetailActivity.this);
		mScrollV.setOnScrollListener(this);

	}

	private int[] images = { R.drawable.img_1, R.drawable.img_2,
			R.drawable.img_3, R.drawable.img_4 };

	private class MyPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return images.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView imageView = new ImageView(ProductDetailActivity.this);
			imageView.setImageResource(images[position]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			container.addView(imageView);

			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((ImageView) object);
		}
	}

	/** 页面变化监听器 */
	class PagerListener implements ViewPager.OnPageChangeListener {
		@Override
		public void onPageSelected(int pos) {
			setIndicatorEnable(pos);

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

	}

	// 显示黑点或白点
	private void setIndicatorEnable(int pos) {
		indicatorLayout.getChildAt(prePos).setEnabled(false);// 显示黑点
		indicatorLayout.getChildAt(pos).setEnabled(true);// 显示白点
		prePos = pos;
	}

	private void setPagerIndicator() {
		indicatorLayout = (LinearLayout) findViewById(R.id.indicatorLayout);

		for (int i = 0; i < images.length; i++) {
			View v = new View(this);
			v.setEnabled(false);
			v.setBackgroundResource(R.drawable.pager_indicator_selector);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					20, 20);
			params.rightMargin = 20;
			v.setLayoutParams(params);
			indicatorLayout.addView(v);

			// 设置默认第一个点为亮点
			indicatorLayout.getChildAt(0).setEnabled(true);

		}

	}

	@Override
	public void onScrollChanged(ScrollViewExtend scrollView, int x, int y,
			int oldx, int oldy) {

		// 滑动事件监听
		if (mViewPager != null) {
			if (mViewPager.getHeight() > 0) {
				int lHeight = mViewPager.getHeight();
				if (y <= 0) {// 还原到默认值
					mLayoutHeader.getBackground().setAlpha(0);
				} else {
					if (y < lHeight) {// 递增颜色值
						int progress = (int) (new Float(y) / new Float(lHeight) * 255);
						mLayoutHeader.getBackground().setAlpha(progress);
					} else {// 保持颜色值不变
						mLayoutHeader.getBackground().setAlpha(255);
					}
				}

			}
		}

	}

	/**
	 * 选择颜色尺码点击按钮
	 */
	@Event(R.id.choose_color_and_size_layout)
	private void chooseColorAndSize(View v) {
		initSkuPopWindow();
	}

	/**
	 * 显示SKU选择
	 */
	public void initSkuPopWindow() {
		if (mPopupWindowForSku == null) {
			View view = mInflater.inflate(R.layout.layout_select_sku_for_pop,
					null);

			mPopViewHodlerForSku = new PopViewHodlerForSku(view);

			mPopupWindowForSku = new PopupWindow(view,
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.MATCH_PARENT, true);

			// 设置popuWindow为固定高度
			final RelativeLayout.LayoutParams parmas1 = new RelativeLayout.LayoutParams(
					mWidth, (mHeight * 2 / 3));
			final RelativeLayout.LayoutParams parmas2 = new RelativeLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

			parmas1.addRule(RelativeLayout.ABOVE,
					mPopViewHodlerForSku.ll_botttom.getId());
			parmas2.addRule(RelativeLayout.ABOVE,
					mPopViewHodlerForSku.ll_botttom.getId());

			ViewTreeObserver vto = mPopViewHodlerForSku.color_size_layout
					.getViewTreeObserver();

			// 获取Layout的高度
			vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

				@Override
				public boolean onPreDraw() {

					int layoutHeight = mPopViewHodlerForSku.color_size_layout
							.getMeasuredHeight();
					if (layoutHeight < (mHeight * 2 / 3)) {
						mPopViewHodlerForSku.color_size_layout
								.setLayoutParams(parmas2);
					} else {
						mPopViewHodlerForSku.color_size_layout
								.setLayoutParams(parmas1);
					}

					return true;
				}

			});

			mPopupWindowForSku.setOutsideTouchable(true);

			// 颜色
			mColorTagAdapter = new TagAdapter<String>(this);
			mPopViewHodlerForSku.mColorFlowTagLayout
					.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);
			mPopViewHodlerForSku.mColorFlowTagLayout
					.setAdapter(mColorTagAdapter);
			mPopViewHodlerForSku.mColorFlowTagLayout
					.setOnTagSelectListener(new OnTagSelectListener() {
						@Override
						public void onItemSelect(FlowTagLayout parent,
								List<Integer> selectedList, int position) {
							if (selectedList != null && selectedList.size() > 0) {
								mColorTagAdapter.setSelectTvColor(position);

								Toast.makeText(
										ProductDetailActivity.this,
										"选择了颜色:"
												+ parent.getAdapter()
														.getItem(0),
										Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(ProductDetailActivity.this,
										"没有选择标签", Toast.LENGTH_LONG).show();
							}
						}
					});

			// 尺寸
			mSizeTagAdapter = new TagAdapter<String>(this);
			mPopViewHodlerForSku.mSizeFlowTagLayout
					.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);
			mPopViewHodlerForSku.mSizeFlowTagLayout.setAdapter(mSizeTagAdapter);
			mPopViewHodlerForSku.mSizeFlowTagLayout
					.setOnTagSelectListener(new OnTagSelectListener() {
						@Override
						public void onItemSelect(FlowTagLayout parent,
								List<Integer> selectedList, int position) {
							if (selectedList != null && selectedList.size() > 0) {
								mSizeTagAdapter.setSelectTvColor(position);
								Toast.makeText(
										ProductDetailActivity.this,
										"选择了尺寸:"
												+ parent.getAdapter()
														.getItem(0),
										Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(ProductDetailActivity.this,
										"没有选择标签", Toast.LENGTH_LONG).show();
							}
						}
					});

		}

		initColorData();
		initSizeData();

		mPopupWindowForSku.showAtLocation(mParentView, Gravity.TOP, 0, 0);

	}

	/**
	 * 绑定PopuWindow
	 * 
	 * @author Administrator
	 * 
	 */

	class PopViewHodlerForSku {

		@ViewInject(R.id.size_flow_layout)
		private FlowTagLayout mSizeFlowTagLayout;// 尺码选择流布局
		@ViewInject(R.id.color_flow_layout)
		private FlowTagLayout mColorFlowTagLayout;// 颜色选择流布局
		@ViewInject(R.id.color_size_layout)
		private LinearLayout color_size_layout;// 父容器
		@ViewInject(R.id.ll_botttom)
		private LinearLayout ll_botttom;// 底部容器

		// 关闭popuWindow
		@Event(R.id.close_popuwindow_iv)
		private void back(View v) {

			colordataSource.clear();
			sizedataSource.clear();
			mPopupWindowForSku.dismiss();
		}

		public PopViewHodlerForSku(View v) {
			x.view().inject(this, v);
		}

	}

	/**
	 * 测试数据
	 */

	private void initColorData() {

		colordataSource.add("红色");
		colordataSource.add("黑色");
		colordataSource.add("花边色");
		colordataSource.add("深蓝色");
		colordataSource.add("彩虹的五颜六色的断点");
		colordataSource.add("白色");
		colordataSource.add("玫瑰红色");
		colordataSource.add("紫黑紫兰色");
		colordataSource.add("葡萄红色");
		colordataSource.add("彩虹红色");
		colordataSource.add("绿色");
		colordataSource.add("彩虹色");
		colordataSource.add("牡丹色");
		colordataSource.add("乌七八黑的颜色");

		mColorTagAdapter.onlyAddAll(colordataSource);
	}

	/**
	 * 初始化数据
	 */
	private void initSizeData() {

		sizedataSource.add("28 (2.1尺)");
		sizedataSource.add("29 (2.2尺)");
		sizedataSource.add("30 (2.3尺)");
		sizedataSource.add("31 (2.4尺)");
		sizedataSource.add("32 (2.5尺)........");
		sizedataSource.add("33 (2.6尺)");
		sizedataSource.add("34 (2.7尺)");
		sizedataSource.add("35 (2.8尺)");
		sizedataSource.add("36 (2.9尺)");
		sizedataSource.add("3特大号");
		sizedataSource.add("37 (3.0尺)");
		sizedataSource.add("超级大大大大大的号");
		sizedataSource.add("38 (3.1尺)");
		sizedataSource.add("39 (3.2尺)........");
		mSizeTagAdapter.onlyAddAll(sizedataSource);
	}

	/**
	 * cesh
	 */

	/**
	 * 跳转到确认订单那页面
	 */

	@Event(R.id.buy_now_bt)
	private void toProductDetailActivity(View v) {
		startActivity(new Intent(this, MakeSureOrderActivity.class));

	}

	/**
	 * 商品详情点击事件
	 */

	@Event(R.id.detail_bt)
	private void goodsDetail(View v) {

		setTabSelection(0);

		setMenue();
		// // 此两行代码用来控制ScrloView不滚动
		int currentY = mMenu.getScrollY();
		mScrollV.smoothScrollBy(0, currentY);

	}

	/**
	 * 宝贝评价
	 */

	@Event(R.id.evaluation_bt)
	private void babyEvelation(View v) {

		setMenue();
		setTabSelection(1);
		// // 此两行代码用来控制ScrloView不滚动
		int currentY = mMenu.getScrollY();
		mScrollV.smoothScrollBy(0, currentY);

	}

	/**
	 * 设置商品详情可见的方法
	 */
	private void setGoodsDtailsShow() {
		mGoodsDetailBt.setTextColor(this.getResources().getColor(
				R.color.color_e20d11));
		mmGoodsDetailBtLine.setVisibility(View.VISIBLE);
		mBabyEvlationBt.setTextColor(this.getResources().getColor(
				R.color.color_2b2b2b));
		mBabyEvlationLine.setVisibility(View.GONE);

	}

	/**
	 * 设置宝贝评价可见的方法
	 */
	private void setBabyEvlationShow() {
		mGoodsDetailBt.setTextColor(this.getResources().getColor(
				R.color.color_2b2b2b));
		mmGoodsDetailBtLine.setVisibility(View.GONE);
		mBabyEvlationBt.setTextColor(this.getResources().getColor(
				R.color.color_e20d11));
		mBabyEvlationLine.setVisibility(View.VISIBLE);
	}

	/**
	 * fragment切换效果
	 * 
	 * @param index
	 */

	private void setTabSelection(int index) {
		// 开启一个Fragment事务
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		transaction.setCustomAnimations(R.anim.push_left_in,
				R.anim.push_left_out, R.anim.back_left_in,
				R.anim.back_right_out);
		hideFragments(transaction);
		switch (index) {
		case 0: // 首页
			setGoodsDtailsShow();// 设置显示商品详情

			if (mGoosDetailFragment == null) { // 如果首页为空
				mGoosDetailFragment = new GoodsDetailFragment(); // 创建首页"界面"
				transaction.add(R.id.product_detail_frame_layout,
						mGoosDetailFragment);// 将创建的“首页”加添到要显示的layout中，并显示
			} else {
				transaction.show(mGoosDetailFragment); // 如果首页存在，则直接显示首页

			}
			break;
		case 1: // 分类
			setBabyEvlationShow();// 设置显示宝贝评价页面

			if (mBabyEvlationFragment == null) {
				mBabyEvlationFragment = new BabyEvlationFragment();
				transaction.add(R.id.product_detail_frame_layout,
						mBabyEvlationFragment);
			} else {
				transaction.show(mBabyEvlationFragment);

			}

			break;
		default:
			break;
		}
		transaction.commit();
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务 //判断页面是否已经创建，如果已经创建，则隐藏页面
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (mGoosDetailFragment != null) {
			transaction.hide(mGoosDetailFragment);
		}
		if (mBabyEvlationFragment != null) {
			transaction.hide(mBabyEvlationFragment);
		}
	}

	/*
	 * 点击回退按钮
	 */
	@Event(R.id.btnHeaderBack)
	private void back(View v) {
		finish();
	}

	@Override
	public void onScroll(int scrollY) {
		if (scrollY >= layoutTop - dip2px(50)) {// 标题栏已经固定
			if (mMenu.getParent() != mBMenuLayout2) {
				mBMenuLayout1.removeAllViews();

				mBMenuLayout2.addView(mSpiltTopLine);
				mBMenuLayout2.addView(mMenu);
				mBMenuLayout2.addView(mSpiltBottomLine);
				menuHasFixed = true;

			}
		} else {// 标题栏没有固定
			if (mMenu.getParent() != mBMenuLayout1) {
				mBMenuLayout2.removeAllViews();

				mBMenuLayout1.addView(mSpiltTopLine);
				mBMenuLayout1.addView(mMenu);
				mBMenuLayout1.addView(mSpiltBottomLine);

				menuHasFixed = false;
			}
		}

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			layoutTop = mChooseColorSize.getBottom();
		}
	}

	/**
	 * 设置framLayout在mBMenuLayout1的下面
	 */

	private void setBelowMenueLayout1() {
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		params.addRule(RelativeLayout.BELOW, mBMenuLayout1.getId());
		mFrameLayout.setLayoutParams(params);
	}

	/**
	 * 设置menulayout1的高度
	 */

	private void setHeight1() {
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.BELOW, mChooseColorSize.getId());
		mBMenuLayout1.setLayoutParams(params);

	}
	
	private void setHeight2() {
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				dip2px(60));
		params.addRule(RelativeLayout.BELOW, mChooseColorSize.getId());
		mBMenuLayout1.setLayoutParams(params);

	}

	// 设置标题栏

	private void setMenue() {
		if (menuHasFixed) {
			setBelowMenueLayout1();
			setHeight2();
		} else {
			setBelowMenueLayout1();
			setHeight1();
		}

	}

}
