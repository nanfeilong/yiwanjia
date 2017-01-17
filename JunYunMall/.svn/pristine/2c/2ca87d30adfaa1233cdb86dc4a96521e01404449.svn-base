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
import cn.junyun.mall.adapter.homeadapter.BestSellerAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.BestSellerEntity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;
/**
 * 热卖商品
 * @author feng
 *
 */
@ContentView(R.layout.activity_best_seller)
public class BestSellerActivity extends BaseActivity {
	//下拉刷新控件
	@ViewInject(R.id.best_seller_refresh)
	private PullToRefreshScrollView mBestSv;
	//title的back
	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt;

	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;
	
	//GridView
	@ViewInject(R.id.bestSeller)
	private GridView mBestGridView;
	//适配器
	BestSellerAdapter bestSellerAdapter;
	ArrayList<BestSellerEntity>bestSellerEntities=new ArrayList<BestSellerEntity>();
	private ScrollView mScrollView;
	@Override
	protected void fillView() {
		//设置title
		mBackTv.setText(getResources().getString(R.string.str_best));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		mScrollView = mBestSv.getRefreshableView();
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
		mBestSv.setMode(Mode.PULL_FROM_END);
		new ShowFooterTask().execute();
		mBestSv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {

				String str = DateUtils.formatDateTime(BestSellerActivity.this,
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if(refreshView.isShownFooter()){
					// 设置刷新标签
					mBestSv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置上拉标签
					mBestSv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					mBestSv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(
							"最后更新时间:" + str);
					new ShowFooterTask().execute();
				}

			}
		});
	}
	private class ShowFooterTask extends AsyncTask<Void, Void, ArrayList<BestSellerEntity>>{

		@Override
		protected ArrayList<BestSellerEntity> doInBackground(Void... arg0) {
			bestSellerEntities.add(new BestSellerEntity(R.drawable.best_seller, "豹纹人字拖", "238", "￥38"));
			bestSellerEntities.add(new BestSellerEntity(R.drawable.best_seller, "豹纹人字拖", "238", "￥38"));
			bestSellerEntities.add(new BestSellerEntity(R.drawable.best_seller, "豹纹人字拖", "238", "￥38"));
			return bestSellerEntities;
		}

		@Override
		protected void onPostExecute(ArrayList<BestSellerEntity> result) {
			super.onPostExecute(result);
			initAdapter(result);
			mBestSv.onRefreshComplete();
		}

		private void initAdapter(ArrayList<BestSellerEntity> result) {
			if(bestSellerAdapter==null){
				bestSellerAdapter=new BestSellerAdapter(BestSellerActivity.this, R.layout.best_seller_item, result);
				mBestGridView.setAdapter(bestSellerAdapter);
			}else {
				bestSellerAdapter.notifyDataSetChanged();
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
