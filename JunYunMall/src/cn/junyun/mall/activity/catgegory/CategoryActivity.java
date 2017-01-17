package cn.junyun.mall.activity.catgegory;

import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.origamilabs.library.views.PullToRefreshStaggeredGridView;
import com.origamilabs.library.views.StaggeredGridView;
import com.origamilabs.library.views.StaggeredGridView.OnItemClickListener;

import cn.junyun.mall.R;
import cn.junyun.mall.activity.product.ProductDetailActivity;
import cn.junyun.mall.adapter.categoryadapter.CateGorySecondAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.CategoryLeftEntity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

@ContentView(R.layout.activity_second_category_layout)
public class CategoryActivity extends BaseActivity {

	@ViewInject(R.id.default_tv)
	private TextView mDefaultTv;// 默认
	@ViewInject(R.id.sales_tv)
	private TextView mASalesTv;// 销量
	@ViewInject(R.id.sentiment_tv)
	private TextView mSentimentTv;// 人气
	@ViewInject(R.id.price_tv)
	private TextView mPriceTv;// 价格
	@ViewInject(R.id.commodity_list_price_asc_iv)
	private ImageView mPriceAscIv;// 价格升序
	@ViewInject(R.id.commodity_list_price_desc_iv)
	private ImageView mPriceDescIv;// 价格降序
	@ViewInject(R.id.btnHeaderBack)
	private Button mBtnHeaderBack;// 回退箭头
	@ViewInject(R.id.btnHeaderExtra)
	private Button mBtnHeaderExtra;// 最右边按钮
	@ViewInject(R.id.search_et)
	private EditText mSearchEt;// 搜索框
	
	@ViewInject(R.id.back_tv)
	private TextView mBackTv;// 回退标题

	@ViewInject(R.id.staggeredGridView)
	private PullToRefreshStaggeredGridView mPullToRefreshStaggerdGridView;// //分类GridView

	private StaggeredGridView mGv;

	private CateGorySecondAdapter mCateGorySecondAdapter;// 二级分类Adapter

	ArrayList<CategoryLeftEntity> mCategorys = new ArrayList<CategoryLeftEntity>();// gridView数据集合
	ArrayList<CategoryLeftEntity> mAllCategorys = new ArrayList<CategoryLeftEntity>();// gridView数据集合

	ArrayList<TextView> mTvs = new ArrayList<TextView>();// 存储TextView 的集合

	private boolean mPriceSortState = true;// 价格排序状态

	private int mPageIndex = 1;

	@Override
	protected void fillView() {
		
		initHeader();

		mTvs.add(mDefaultTv);
		mTvs.add(mASalesTv);
		mTvs.add(mSentimentTv);
		mTvs.add(mPriceTv);

		mGv = mPullToRefreshStaggerdGridView.getRefreshableView();

		new GetDataTask().execute();

	}

	@Override
	protected void setListener() {

		mPullToRefreshStaggerdGridView.setMode(Mode.BOTH);
		mPullToRefreshStaggerdGridView
				.setOnRefreshListener(new OnRefreshListener<StaggeredGridView>() {

					@Override
					public void onRefresh(
							PullToRefreshBase<StaggeredGridView> refreshView) {
						String str = DateUtils.formatDateTime(
								CategoryActivity.this,
								System.currentTimeMillis(),
								DateUtils.FORMAT_SHOW_TIME
										| DateUtils.FORMAT_SHOW_DATE
										| DateUtils.FORMAT_ABBREV_ALL);
						if (refreshView.isShownHeader()) {
							// 设置刷新标签
							mPullToRefreshStaggerdGridView
									.getLoadingLayoutProxy()
									.setRefreshingLabel("正在刷新");
							// 设置下拉标签
							mPullToRefreshStaggerdGridView
									.getLoadingLayoutProxy().setPullLabel(
											"下拉刷新");
							// 设置释放标签
							mPullToRefreshStaggerdGridView
									.getLoadingLayoutProxy().setReleaseLabel(
											"释放开始刷新");
							// 设置上一次刷新的提示标签
							refreshView.getLoadingLayoutProxy()
									.setLastUpdatedLabel("最后更新时间:" + str);
							new GetDataTask().execute();
						}
						if (refreshView.isShownFooter()) {
							mPageIndex++;
							// 设置刷新标签
							mPullToRefreshStaggerdGridView
									.getLoadingLayoutProxy()
									.setRefreshingLabel("正在加载");
							// 设置下拉标签
							mPullToRefreshStaggerdGridView
									.getLoadingLayoutProxy().setPullLabel(
											"上拉加载");
							// 设置释放标签
							mPullToRefreshStaggerdGridView
									.getLoadingLayoutProxy().setReleaseLabel(
											"释放加载更多数据");

							// Log.e("onPullUpToRefresh 方法 ", "执行了");
							new GetDataTask().execute();
						}

					}
				});

		/**
		 * 跳转到商品详情页面
		 */
		mGv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(StaggeredGridView parent, View view,
					int position, long id) {

				startActivity(new Intent(CategoryActivity.this,
						ProductDetailActivity.class));

			}
		});

	}

	/**
	 * 设置头部标题的方法
	 */
	
	

	@Override
	protected void loadData() {
		super.loadData();

		setTextViewChecked(0);

		int margin = getResources().getDimensionPixelSize(R.dimen.dp_value_5);

		mGv.setItemMargin(margin); // set the GridView margin

	}

	/**
	 * 初始化分类适配器
	 * 
	 * @param beans
	 */

	private Parcelable state;// gridview当前的状态

	private void initAdapterLeft() {

		if (mCateGorySecondAdapter == null) {
			mCateGorySecondAdapter = new CateGorySecondAdapter(
					(ArrayList<CategoryLeftEntity>) mCategorys, this);
			mGv.setAdapter(mCateGorySecondAdapter);

		} else {
			state = mGv.onSaveInstanceState();
			mCateGorySecondAdapter.notifyDataSetChanged();
			mPullToRefreshStaggerdGridView.onRefreshComplete();
			mGv.onRestoreInstanceState(state);

		}

	}
	
	//初始化Header
	
	private void initHeader(){
		mSearchEt.setVisibility(View.VISIBLE);
		mBtnHeaderExtra.setVisibility(View.VISIBLE);
		mBtnHeaderExtra.setBackgroundDrawable(getResources().getDrawable(R.drawable.search));
		mBtnHeaderBack.setVisibility(View.VISIBLE);
		mBtnHeaderBack.setBackgroundResource(R.drawable.back);
	}

	/**
	 * 测试数据
	 */

	private void testData() {

		/**
		 * 测试右侧商品分类数据
		 */
		mCategorys.add(new CategoryLeftEntity("衬衫"));
		mCategorys.add(new CategoryLeftEntity("针织"));
		mCategorys.add(new CategoryLeftEntity("啼血"));
		mCategorys.add(new CategoryLeftEntity("雪纺衫"));
		mCategorys.add(new CategoryLeftEntity("短外套"));

	}

	/**
	 * 默认排序
	 */
	@Event(R.id.default_tv)
	private void defaults(View v) {

		setTextViewChecked(0);

	}

	/**
	 * 销量排序
	 */
	@Event(R.id.sales_tv)
	private void sales(View v) {
		setTextViewChecked(1);

	}

	/**
	 * 人气排序
	 */
	@Event(R.id.sentiment_tv)
	private void sentiment(View v) {
		setTextViewChecked(2);

	}

	/**
	 * 价格排序
	 */
	@Event(R.id.price_layout)
	private void price(View v) {
		setTextViewChecked(3);

		priceSortState();// 价格排序状态切换

		if (mPriceSortState) {
			mPriceSortState = false;
		} else {
			mPriceSortState = true;
		}

	}

	// 设置默认 销量，人气，价格 按钮的颜色显示效果
	private void setTextViewChecked(int position) {

		for (int i = 0; i < mTvs.size(); i++) {
			if (position == i) {
				mTvs.get(i).setTextColor(
						getResources().getColor(R.color.color_e20d11));

			} else {
				mTvs.get(i).setTextColor(
						getResources().getColor(R.color.color_969696));
			}
			// 如果没有点击价格排序，则将排序箭头设置为灰色
			if (position != 3) {
				mPriceAscIv.setImageResource(R.drawable.iv_asc_arrow_up);
				mPriceDescIv.setImageResource(R.drawable.iv_desc_arrow_down);
			}

		}

	}

	/**
	 * 设置价格升序排序切换状态
	 */

	private void priceSortState() {
		if (mPriceSortState) {
			mPriceAscIv.setImageResource(R.drawable.iv_asc_arrow_up_red);
			mPriceDescIv.setImageResource(R.drawable.iv_desc_arrow_down);
		} else {
			mPriceAscIv.setImageResource(R.drawable.iv_asc_arrow_up);
			mPriceDescIv.setImageResource(R.drawable.iv_desc_arrow_down_red);
		}

	}

	/*
	 * 点击回退按钮
	 */
	@Event(R.id.btnHeaderBack)
	private void back(View v) {
		finish();
	}

	private class GetDataTask extends
			AsyncTask<Void, Void, ArrayList<CategoryLeftEntity>> {
		@Override
		protected ArrayList<CategoryLeftEntity> doInBackground(Void... params) {
			testData();
			return mCategorys;
		}

		@Override
		protected void onPostExecute(ArrayList<CategoryLeftEntity> result) {
			if (result != null) {
				// mAllCategorys.addAll(result);
				initAdapterLeft();
			}
			// Call onRefreshComplete when the list has been refreshed.
			mPullToRefreshStaggerdGridView.onRefreshComplete();

		}
	}

}
