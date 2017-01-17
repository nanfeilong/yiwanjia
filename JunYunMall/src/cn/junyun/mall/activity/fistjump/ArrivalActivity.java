package cn.junyun.mall.activity.fistjump;

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
import cn.junyun.mall.adapter.homeadapter.ArrivalAdapter;
import cn.junyun.mall.adapter.homeadapter.BrandStreetAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.ArrivalEntity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;
/**
 * 新品上架
 * @author fxr
 *
 */
@ContentView(R.layout.activity_arrival)
public class ArrivalActivity extends BaseActivity {
	//下拉刷新控件
	@ViewInject(R.id.arrival_refresh)
	private PullToRefreshScrollView mArrivalSv;

	//title的back
	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt;

	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;

	//GridView
	@ViewInject(R.id.arrival)
	private GridView mArrlGridView;

	//适配器
	ArrivalAdapter arrivalAdapter;
	ArrayList<ArrivalEntity>arrivalEntities=new ArrayList<ArrivalEntity>();
	private ScrollView mScrollView;
	@Override
	protected void fillView() {
		//设置title
		mBackTv.setText(getResources().getString(R.string.str_arrival));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		mScrollView = mArrivalSv.getRefreshableView();
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
		mArrivalSv.setMode(Mode.PULL_FROM_END);
		new ShowFooterTask().execute();
		mArrivalSv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
				String str = DateUtils.formatDateTime(ArrivalActivity.this,
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if(refreshView.isShownFooter()){
					// 设置刷新标签
					mArrivalSv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置上拉标签
					mArrivalSv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					mArrivalSv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(
							"最后更新时间:" + str);
					new ShowFooterTask().execute();
				}
			}
		});
	}
	private class ShowFooterTask extends AsyncTask<Void, Void, ArrayList<ArrivalEntity>>{

		@Override
		protected ArrayList<ArrivalEntity> doInBackground(Void... arg0) {
			arrivalEntities.add(new ArrivalEntity(R.drawable.arrival1, "￥369"));
			arrivalEntities.add(new ArrivalEntity(R.drawable.arrival2, "￥369"));
			arrivalEntities.add(new ArrivalEntity(R.drawable.arrival3, "￥369"));
			arrivalEntities.add(new ArrivalEntity(R.drawable.arrival4, "￥369"));
			arrivalEntities.add(new ArrivalEntity(R.drawable.arrival5, "￥369"));
			return arrivalEntities;
		}

		@Override
		protected void onPostExecute(ArrayList<ArrivalEntity> result) {
			super.onPostExecute(result);
			initAdapter(result);
			mArrivalSv.onRefreshComplete();
		}

		private void initAdapter(ArrayList<ArrivalEntity> result) {
			if(arrivalAdapter==null){
				arrivalAdapter=new ArrivalAdapter(ArrivalActivity.this, R.layout.arrival_item, result);
				mArrlGridView.setAdapter(arrivalAdapter);
			}else {
				arrivalAdapter.notifyDataSetChanged();
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
