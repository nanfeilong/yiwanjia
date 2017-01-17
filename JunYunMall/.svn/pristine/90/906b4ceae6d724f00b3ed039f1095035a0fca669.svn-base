
package cn.junyun.mall.activity.fistjump;

import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.adapter.homeadapter.GoodShopAdapter;
import cn.junyun.mall.adapter.homeadapter.PanicAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.GoodShopEntity;
import cn.junyun.mall.view.MyListView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
/**
 * 今日好点
 * @author feng
 */
@ContentView(R.layout.activity_good_shop)
public class GoodShopActivity extends BaseActivity {
	//下拉刷新控件
	@ViewInject(R.id.good_shop_refresh)
	private PullToRefreshScrollView mGoodShopSv;

	//title的back
	@ViewInject( R.id.btnHeaderBack)
	private Button mBackBt;

	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;

	//list
	@ViewInject(R.id.good_shop_listview)
	private MyListView mGoodShopListView;
	//适配器
	GoodShopAdapter goodShopAdapter;
	ArrayList<GoodShopEntity>goodShopEntities=new ArrayList<GoodShopEntity>();
	//定义真是的scrollView
	private ScrollView mScrollView;
	@Override
	protected void fillView() {
		//设置title
		mBackTv.setText(getResources().getString(R.string.str_good_shop));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		mScrollView = mGoodShopSv.getRefreshableView();
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
		mGoodShopSv.setMode(Mode.PULL_FROM_END);
		new ShowFooterTask().execute();
		mGoodShopSv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {
			

			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {

				String str = DateUtils.formatDateTime(GoodShopActivity.this,
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if (refreshView.isShownFooter()) {
					// 设置刷新标签
					mGoodShopSv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置上拉标签
					mGoodShopSv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					mGoodShopSv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(
							"最后更新时间:" + str);
					new ShowFooterTask().execute();
				}
			}
		});
	}
	private class ShowFooterTask extends AsyncTask<Void, Void, ArrayList<GoodShopEntity>>{

		@Override
		protected ArrayList<GoodShopEntity> doInBackground(Void... params) {
			goodShopEntities.add(new GoodShopEntity(R.drawable.shop_logo, "金刚葫芦娃",R.drawable.good_shop_vip, R.drawable.good_shop_left, R.drawable.good_shop_right11, R.drawable.good_shop_right22));
			return goodShopEntities;
		}

		@Override
		protected void onPostExecute(ArrayList<GoodShopEntity> result) {
			super.onPostExecute(result);
			initAdapter(result);
			mGoodShopSv.onRefreshComplete();
		}

		private void initAdapter(ArrayList<GoodShopEntity> result) {

			if(goodShopAdapter==null){
				goodShopAdapter=new GoodShopAdapter(GoodShopActivity.this, R.layout.good_shop_item, result);
				mGoodShopListView.setAdapter(goodShopAdapter);
			}else {
				goodShopAdapter.notifyDataSetChanged();
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
