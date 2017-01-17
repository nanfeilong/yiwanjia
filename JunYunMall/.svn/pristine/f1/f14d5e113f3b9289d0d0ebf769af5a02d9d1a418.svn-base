package cn.junyun.mall.activity.fistjump;
//精品推荐
import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.adapter.homeadapter.PanicAdapter;
import cn.junyun.mall.adapter.homeadapter.RecommendAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.RecommendEntity;
import cn.junyun.mall.view.MyListView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
@ContentView(R.layout.activity_recommend)
public class RecommendActivity extends BaseActivity {
	//精品推荐下拉刷新
	@ViewInject(R.id.recommend_refresh)
	private PullToRefreshScrollView mRecommendSv;

	//title的back
	@ViewInject( R.id.btnHeaderBack)
	private Button mBackBt;

	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;

	//list
	@ViewInject(R.id.recommend_listview)
	private MyListView mRecommendListView;

	//适配器
	RecommendAdapter recommendAdapter;

	//创建list存放item
	ArrayList<RecommendEntity>recommendListView=new ArrayList<RecommendEntity>();

	//实例化真实ScrollView
	private ScrollView mScrollView;
	@Override
	protected void fillView() {


		//设置title
		mBackTv.setText(getResources().getString(R.string.str_reommend));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		Log.e("mRecommendSv === ", mRecommendSv+"");
		mScrollView = mRecommendSv.getRefreshableView();
	}

	@Override
	protected void setListener() {

		mBackBt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();				
			}
		});

	}

	@Override
	protected void loadData() {
		mRecommendSv.setMode(Mode.PULL_FROM_END);
		new ShowFooterTask().execute();
		mRecommendSv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {

				String str = DateUtils.formatDateTime(RecommendActivity.this,
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if (refreshView.isShownFooter()) {
					// 设置刷新标签
					mRecommendSv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置上拉标签
					mRecommendSv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					mRecommendSv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(
							"最后更新时间:" + str);
					new ShowFooterTask().execute();
				}
			}
		});
	}

	private class ShowFooterTask extends AsyncTask<Void, Void, ArrayList<RecommendEntity>>{

		@Override
		protected ArrayList<RecommendEntity> doInBackground(Void... arg0) {
			recommendListView.add(new RecommendEntity(R.drawable.recommend_test, "百搭偏光驾驶镜", "一本正经的假冒伪劣", "1000"));
			return recommendListView;
		}

		@Override
		protected void onPostExecute(ArrayList<RecommendEntity> result) {
			initAdapter(result);
			mRecommendSv.onRefreshComplete();
		}

		private void initAdapter(ArrayList<RecommendEntity> result) {

			if(recommendAdapter==null){
				recommendAdapter=new RecommendAdapter(RecommendActivity.this, R.layout.panic_layout_item, result);
				mRecommendListView.setAdapter(recommendAdapter);
			}else {
				recommendAdapter.notifyDataSetChanged();
				mScrollView.post(new Runnable() {
					@Override
					public void run() {
						mScrollView.smoothScrollBy(0, 100);	
					}
				});
			}


		}

	}


}
