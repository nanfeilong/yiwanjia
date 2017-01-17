package cn.junyun.mall.activity.fistjump;
/**
 * 疯狂抢购
 */
import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import android.os.AsyncTask;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.adapter.homeadapter.PanicAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.PanicBuyingListEntity;
import cn.junyun.mall.view.MyListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
@ContentView(R.layout.activity_panic_buying)
public class PanicBuyingActivity extends BaseActivity {
	//下拉刷新控件
	@ViewInject(R.id.panic_refresh)
	private PullToRefreshScrollView mPanicLv;

	//title的back
	@ViewInject( R.id.btnHeaderBack)
	private Button mBackBt;
	
	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;
	
	//疯狂抢购广告条
	@ViewInject(R.id.panicbuying)
	private ImageView mPanicAdIv;
	
	//疯狂抢购蓝条
	@ViewInject(R.id.panic_buying_blue)
	private ImageView mPanicBlue;
	
	//文字说明限时限量  疯狂抢购
	@ViewInject(R.id.xianshiqianggou)
	private TextView mPanicAd1;
	
	//倒计时文字
	@ViewInject(R.id.count_down_text)
	private TextView mCountDownTv;
	
	//倒计时
	@ViewInject(R.id.count_down)
	private TextView mCountDown;
	
	//list
	@ViewInject(R.id.panic_buying_listview)
	private MyListView mPanicListView;
	
	//适配器
	PanicAdapter panicAdapter;

	ArrayList <PanicBuyingListEntity> panicListView=new ArrayList<PanicBuyingListEntity>();

	private ScrollView mScrollView;

	@Override
	protected void fillView() {
		//设置title
		mBackTv.setText(getResources().getString(R.string.str_panic_buying_head));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		mScrollView = mPanicLv.getRefreshableView();
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
		mPanicLv.setMode(Mode.PULL_FROM_END);
		new ShowFooterTask().execute();
		mPanicLv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
				String str = DateUtils.formatDateTime(PanicBuyingActivity.this,
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if (refreshView.isShownFooter()) {
					// 设置刷新标签
					mPanicLv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置上拉标签
					mPanicLv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					mPanicLv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
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
			panicListView.add(new PanicBuyingListEntity(R.drawable.panic_buy_listview, "时尚夏季潮流 修身阔腿套装", "简单利落+显高显瘦", "已经抢124件", "￥ 1990000000000000", "￥999"));
			return panicListView;
		}

		@Override
		protected void onPostExecute(ArrayList<PanicBuyingListEntity> result) {
			initAdapter(result);
			mPanicLv.onRefreshComplete();
		}

		private void initAdapter(ArrayList<PanicBuyingListEntity> result) {
			if(panicAdapter==null){
				panicAdapter=new PanicAdapter(PanicBuyingActivity.this, R.layout.panic_layout_item, result);
				mPanicListView.setAdapter(panicAdapter);
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
