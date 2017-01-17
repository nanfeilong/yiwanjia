package cn.junyun.mall.activity.fistjump;
/*
 * 今日特价
 */
import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.adapter.homeadapter.PanicAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.PanicBuyingListEntity;
import cn.junyun.mall.view.MyListView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
@ContentView(R.layout.activity_toadyprice)
public class ToadyPriceActivity extends  BaseActivity{
	//下拉刷新控件
	@ViewInject(R.id.today_price_refresh)
	private PullToRefreshScrollView mTodayPriceLv;
	//title的back
	@ViewInject( R.id.btnHeaderBack)
	private Button mBackBt;
	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;
	//今日特价广告条
	@ViewInject(R.id.today_price)
	private ImageView mTodayPriceIv;
	//今日特价红条
	@ViewInject(R.id.today_price_red)
	private ImageView mToadyPriceRed;
	//文字说明今日特价
	@ViewInject(R.id.jinritejia)
	private ImageView mJinRiTeJia;
	//list
	@ViewInject(R.id.today_price_listview)
	private MyListView mTodayPriceListView;
	//适配器
	PanicAdapter panicAdapter;

	ArrayList <PanicBuyingListEntity> todayPriceView=new ArrayList<PanicBuyingListEntity>();

	private ScrollView mScrollView;

	@Override
	protected void fillView() {
		//设置title
		mBackTv.setText(getResources().getString(R.string.str_today_price));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		mScrollView = mTodayPriceLv.getRefreshableView();
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

		mTodayPriceLv.setMode(Mode.PULL_FROM_END);
		new ShowFooterTask().execute();
		mTodayPriceLv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
				String str = DateUtils.formatDateTime(ToadyPriceActivity.this,
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if (refreshView.isShownFooter()) {
					// 设置刷新标签
					mTodayPriceLv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置上拉标签
					mTodayPriceLv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					mTodayPriceLv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(
							"最后更新时间:" + str);
					new ShowFooterTask().execute();
				}
			}
		});

	}
	private class ShowFooterTask extends AsyncTask<Void, Void, ArrayList<PanicBuyingListEntity>> {

		@Override
		protected ArrayList<PanicBuyingListEntity> doInBackground(Void... arg0) {
			todayPriceView.add(new PanicBuyingListEntity(R.drawable.panic_buy_listview, "时尚夏季潮流 修身阔腿套装", "简单利落+显高显瘦", "已经抢124件", "￥ 1990000000000000", "￥999"));
			return todayPriceView;
		}

		@Override
		protected void onPostExecute(ArrayList<PanicBuyingListEntity> result) {
			initAdapter(result);
			mTodayPriceLv.onRefreshComplete();
		}

		private void initAdapter(ArrayList<PanicBuyingListEntity> result) {
			if(panicAdapter==null){
				panicAdapter=new PanicAdapter(ToadyPriceActivity.this, R.layout.panic_layout_item, result);
				mTodayPriceListView.setAdapter(panicAdapter);
			}else {
				panicAdapter.notifyDataSetChanged();
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
