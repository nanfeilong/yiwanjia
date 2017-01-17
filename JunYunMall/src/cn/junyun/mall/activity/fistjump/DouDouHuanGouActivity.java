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
import cn.junyun.mall.adapter.homeadapter.DouDouHuanGouAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.DouDouHuanGouEntity;
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
 * doudou兑换页面
 */
@ContentView(R.layout.activity_dou_dou_huan_gou)
public class DouDouHuanGouActivity extends BaseActivity {
	//下拉刷新控件
	@ViewInject(R.id.doudou_huan_gou_refresh)
	private PullToRefreshScrollView mDouDouSv;
	//title的back
	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt;

	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;
	//list
	@ViewInject(R.id.dou_dou_huangou_listview)
	private MyListView mDouDouHuanGouListView;
	//适配器
	DouDouHuanGouAdapter douDouHuanGouAdapter;
	ArrayList<DouDouHuanGouEntity>douDouHuanGouXiangQingList=new ArrayList<DouDouHuanGouEntity>();
	private ScrollView mScrollView;


	@Override
	protected void fillView() {
		//设置title
		mBackTv.setText(getResources().getString(R.string.str_doudou_huangou));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		mScrollView = mDouDouSv.getRefreshableView();
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
		mDouDouSv.setMode(Mode.PULL_FROM_END);
		new ShowFooterTask().execute();
		mDouDouSv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
				String str = DateUtils.formatDateTime(DouDouHuanGouActivity.this,
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if(refreshView.isShownFooter()){
					// 设置刷新标签
					mDouDouSv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置上拉标签
					mDouDouSv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					mDouDouSv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(
							"最后更新时间:" + str);
					new ShowFooterTask().execute();
				}
			}
		});
	}
	private class ShowFooterTask extends AsyncTask<Void, Void, ArrayList<DouDouHuanGouEntity>>{

		@Override
		protected ArrayList<DouDouHuanGouEntity> doInBackground(Void... arg0) {
			douDouHuanGouXiangQingList.add(new  DouDouHuanGouEntity(R.drawable.huangouitem, "CK凯文迪卡(CalvinKlein) CITY系列男表夜光皮表石英表K2G21107", "1000", "￥200", "已经有15人换购"));

			return douDouHuanGouXiangQingList;
		}

		@Override
		protected void onPostExecute(ArrayList<DouDouHuanGouEntity> result) {
			super.onPostExecute(result);
			initAdapter(result);
			mDouDouSv.onRefreshComplete();
		}

		private void initAdapter(ArrayList<DouDouHuanGouEntity> result) {
			if(douDouHuanGouAdapter==null){
				douDouHuanGouAdapter=new DouDouHuanGouAdapter(DouDouHuanGouActivity.this, R.layout.dou_dou_xiangqing_item, result);
				mDouDouHuanGouListView.setAdapter(douDouHuanGouAdapter);
			}else {
				douDouHuanGouAdapter.notifyDataSetChanged();
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

