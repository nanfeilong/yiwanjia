package cn.junyun.mall.activity.fistjump;
/**
 * 品牌街
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
import cn.junyun.mall.adapter.homeadapter.BrandStreetAdapter;
import cn.junyun.mall.adapter.homeadapter.PanicAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.BrandStreetEntity;
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
@ContentView(R.layout.activity_brands_street)
public class BrandsStreetActivity extends BaseActivity {
	//下拉刷新控件
	@ViewInject(R.id.brands_refresh)
	private PullToRefreshScrollView mBrandsSv;

	//title的back
	@ViewInject( R.id.btnHeaderBack)
	private Button mBackBt;

	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;
	//head,ImageView第1格
	@ViewInject(R.id.brand_street_top1)
	ImageView mBrandStreetTop1;

	//head,ImageView第2格
	@ViewInject(R.id.brand_street_top2)
	ImageView mBrandStreetTop2;

	//head,ImageView第3格
	@ViewInject(R.id.brand_street_top3)
	ImageView mBrandStreetTop3;

	//head,ImageView第4格
	@ViewInject(R.id.brand_street_top4)
	ImageView mBrandStreetTop4;

	//list
	@ViewInject(R.id.brands_street_listview)
	private MyListView mBrandsListView;

	//适配器
	BrandStreetAdapter brandStreetAdapter;
	ArrayList<BrandStreetEntity>brandStreetEntities=new ArrayList<BrandStreetEntity>();
	private ScrollView mScrollView;
	@Override
	protected void fillView() {
		//设置title
		
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		mScrollView = mBrandsSv.getRefreshableView();

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

		mBrandsSv.setMode(Mode.PULL_FROM_END);
		new ShowFooterTask().execute();
		mBrandsSv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
				String str = DateUtils.formatDateTime(BrandsStreetActivity.this,
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if(refreshView.isShownFooter()){
					// 设置刷新标签
					mBrandsSv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置上拉标签
					mBrandsSv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					mBrandsSv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(
							"最后更新时间:" + str);
					new ShowFooterTask().execute();
				}
			}
		});
	}
	private class ShowFooterTask extends AsyncTask<Void, Void, ArrayList<BrandStreetEntity>>{

		@Override
		protected ArrayList<BrandStreetEntity> doInBackground(Void... arg0) {
			brandStreetEntities.add(new BrandStreetEntity(R.drawable.banner01));
			brandStreetEntities.add(new BrandStreetEntity(R.drawable.banner02));
			brandStreetEntities.add(new BrandStreetEntity(R.drawable.banner03));
			return brandStreetEntities;
		}

		@Override
		protected void onPostExecute(ArrayList<BrandStreetEntity> result) {
			super.onPostExecute(result);
			initAdapter(result);
			mBrandsSv.onRefreshComplete();
		}

		private void initAdapter(ArrayList<BrandStreetEntity> result) {
			if(brandStreetAdapter==null){
				brandStreetAdapter=new BrandStreetAdapter(BrandsStreetActivity.this, R.layout.brands_street_item, result);
				mBrandsListView.setAdapter(brandStreetAdapter);
			}else {
				brandStreetAdapter.notifyDataSetChanged();
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
