 package cn.junyun.mall.activity.catgegory;

import java.util.ArrayList;
import java.util.List;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.origamilabs.library.views.PullToRefreshStaggeredGridView;
import com.origamilabs.library.views.StaggeredGridView;

import cn.junyun.mall.R;
import cn.junyun.mall.adapter.categoryadapter.CateGorySecondAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.CategoryLeftEntity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@ContentView(R.layout.activity_first_category_layout)
public class CategoryOneLeveActivity extends BaseActivity  {
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

	private CateGorySecondAdapter mCateGorySecondAdapter;// 二级分类Adapter

	ArrayList<CategoryLeftEntity> mCategorys = new ArrayList<CategoryLeftEntity>();// 左侧gridView数据集合

	ArrayList<TextView> mTvs = new ArrayList<TextView>();// 存储TextView 的集合

	private Intent mIntent;

	private StaggeredGridView mGv;

	private String mCloneType;// 服饰种类

	@Override
	protected void fillView() {
		// TODO Auto-generated method stub
		super.fillView();

		mIntent = getIntent();
		mCloneType = mIntent.getStringExtra("cloneType");

		setHeader();

		mGv = mPullToRefreshStaggerdGridView.getRefreshableView();

	}

	@Override
	protected void setListener() {

		mPullToRefreshStaggerdGridView.setMode(Mode.BOTH);

		mPullToRefreshStaggerdGridView
				.setOnRefreshListener(new OnRefreshListener2<StaggeredGridView>() {

					@Override
					public void onPullDownToRefresh(
							PullToRefreshBase<StaggeredGridView> refreshView) {
//						Log.e("onPullDownToRefresh 方法 ", "执行了");
						new GetDataTask().execute();

					}

					@Override
					public void onPullUpToRefresh(
							PullToRefreshBase<StaggeredGridView> refreshView) {
						//设置刷新标签
						mPullToRefreshStaggerdGridView.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
						//设置下拉标签
						mPullToRefreshStaggerdGridView.getLoadingLayoutProxy().setPullLabel("上拉加载");
						//设置释放标签
						mPullToRefreshStaggerdGridView.getLoadingLayoutProxy().setReleaseLabel("释放加载更多数据");
//						Log.e("onPullUpToRefresh 方法 ", "执行了");
						new GetDataTask().execute();

					}
				});

	}

	/**
	 * 设置头部标题的方法
	 */
	private void setHeader() {
		mBackTv.setVisibility(View.VISIBLE);
		mBackTv.setText(mCloneType);
		mSearchEt.setVisibility(View.GONE);
		mBtnHeaderBack.setVisibility(View.VISIBLE);
		mBtnHeaderBack.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.back));
		mBtnHeaderExtra.setVisibility(View.VISIBLE);
		mBtnHeaderExtra.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.search));

	}

	@Override
	protected void loadData() {
		super.loadData();

		int margin = getResources().getDimensionPixelSize(R.dimen.dp_value_5);

		mGv.setItemMargin(margin); // set the GridView margin

		testData();

		initAdapterLeft(mCategorys);

	}

	/**
	 * 初始化分类适配器
	 * 
	 * @param beans
	 */

	private Parcelable state;//gridview当前的状态
	private void initAdapterLeft(List<CategoryLeftEntity> beans) {

		if (mCateGorySecondAdapter == null) {
			mCateGorySecondAdapter = new CateGorySecondAdapter(
					(ArrayList<CategoryLeftEntity>) beans, this);
			mGv.setAdapter(mCateGorySecondAdapter);
		} else {
			state = mGv.onSaveInstanceState();
			mCateGorySecondAdapter.notifyDataSetChanged();
			mGv.onRestoreInstanceState(state);
		}

	}

	/**
	 * 测试数据
	 */

	private void testData() {

		/**
		 * 测试右侧商品分类数据
		 */

		for (int i = 0; i < 5; i++) {
			mCategorys.add(new CategoryLeftEntity("衬衫"));
			mCategorys.add(new CategoryLeftEntity("针织"));
			mCategorys.add(new CategoryLeftEntity("啼血"));
			mCategorys.add(new CategoryLeftEntity("雪纺衫"));
			mCategorys.add(new CategoryLeftEntity("短外套"));

		}

	}

	/*
	 * 点击回退按钮
	 */
	@Event({R.id.btnHeaderBack,R.id.back_tv})
	private void back(View v) {
		finish();
	}

	private class GetDataTask extends AsyncTask<Void, Void, String[]> {
		@Override
		protected String[] doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			// Do some stuff here

			// Call onRefreshComplete when the list has been refreshed.
			mPullToRefreshStaggerdGridView.onRefreshComplete();

			super.onPostExecute(result);
		}
	}
}
