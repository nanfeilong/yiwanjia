package cn.junyun.mall.activity.home.fragment;
/*
 * 首页
 */
import java.util.ArrayList;
import java.util.List;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.fistjump.ArrivalActivity;
import cn.junyun.mall.activity.fistjump.BestSellerActivity;
import cn.junyun.mall.activity.fistjump.BrandsStreetActivity;
import cn.junyun.mall.activity.fistjump.DouDouMallActivity;
import cn.junyun.mall.activity.fistjump.GoodShopActivity;
import cn.junyun.mall.activity.fistjump.PanicBuyingActivity;
import cn.junyun.mall.activity.fistjump.RecommendActivity;
import cn.junyun.mall.activity.fistjump.SignInActivity;
import cn.junyun.mall.activity.fistjump.ToadyPriceActivity;
import cn.junyun.mall.activity.home.HomeTabActivity;
import cn.junyun.mall.adapter.homeadapter.HomeAdapter;
import cn.junyun.mall.base.BaseFragment;
import cn.junyun.mall.model.HomeListEntity;
import cn.junyun.mall.view.CarouselView;
import cn.junyun.mall.view.MyListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {
	@ViewInject(R.id.home)
	LinearLayout home;
	@ViewInject(R.id.home_up_refresh)
	PullToRefreshScrollView lv;// 下拉刷新控件
	@ViewInject(R.id.relativeLayout_homeback)
	CarouselView mCarouselView;// 轮播
	@ViewInject(R.id.iv_home_sign_in_logo)
	ImageView mSignInIv;// 签到
	@ViewInject(R.id.iv_home_panic_buying_logo)
	ImageView mPanicBuying;// 疯狂抢购
	@ViewInject(R.id.iv_home_doudoumall_logo)
	ImageView mDouDouMall;// 豆豆商城
	@ViewInject(R.id.iv_home_recommend)
	ImageView mRecommend;// 精品推荐
	@ViewInject(R.id.iv_sale_price)
	ImageView mSalePrice;//今日特价
	@ViewInject(R.id.iv_best_seller)
	ImageView mBestSeller;//热卖商品 
	@ViewInject(R.id.iv_new_arrival)
	ImageView mNewArrival;//新品上架
	@ViewInject(R.id.iv_good_shop)
	ImageView mGoodShop;//今日好店
	@ViewInject(R.id.iv_brand_street)
	ImageView mBrandStreet;//品牌街
	@ViewInject(R.id.home_list_view)
	MyListView mHomeList;//List
	//private List<HomeListEntity> homeList = new ArrayList<HomeListEntity>();
	HomeAdapter homeAdapter;
	ArrayList<HomeListEntity> fxr = new ArrayList<HomeListEntity>();

	/***
	 * 首页
	 */
	private ScrollView mScrollView;
	@Override
	protected void fillView() {
		mScrollView = lv.getRefreshableView();
	}

	@Override
	protected void setListener() {
		//签到跳转
		mSignInIv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent signInIntent=new Intent(getActivity(),SignInActivity.class);
				startActivity(signInIntent);
			}
		});
		//豆豆商城跳转
		mDouDouMall.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "敬请期待",0).show();
			}
		});
		//疯狂抢购
		mPanicBuying.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent panicIntent=new Intent(getActivity(),PanicBuyingActivity.class);
				startActivity(panicIntent);
			}
		});
		//今日特价
		mSalePrice.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent todayPriceIntent=new Intent(getActivity(),ToadyPriceActivity.class);
				startActivity(todayPriceIntent);

			}
		});
		//精品推荐
		mRecommend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent recommendIntent=new Intent(getActivity(),RecommendActivity.class);
				startActivity(recommendIntent);
			}
		});
		//品牌街
		mBrandStreet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent brandsStreetIntent=new Intent(getActivity(),BrandsStreetActivity.class);
				startActivity(brandsStreetIntent);
			}
		});
		//今日好点
		mGoodShop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent goodShopIntent=new Intent(getActivity(),GoodShopActivity.class);
				startActivity(goodShopIntent);
			}
		});
		//新品上架
		mNewArrival.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent arrivalIntent=new Intent(getActivity(),ArrivalActivity.class);
				startActivity(arrivalIntent);
			}
		});
		//热卖商品
		mBestSeller.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent bestSellerIntent=new Intent(getActivity(),BestSellerActivity.class);
				startActivity(bestSellerIntent);
			}
		});
		//豆豆商城
		mDouDouMall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent doudouMallIntent=new Intent(getActivity(),DouDouMallActivity.class);
				startActivity(doudouMallIntent);
			}
		});
	}


	@Override
	protected void loadData() {
		super.loadData();
		mHomeList.setFocusable(false);//取消listView的焦点
		lv.setMode(Mode.BOTH);//同时支持上拉刷新和下拉刷新
		new ShowFooterTask().execute();//发起请求
		// 下拉刷新
		lv.setOnRefreshListener(new OnRefreshListener<ScrollView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
				String str = DateUtils.formatDateTime(getActivity(),
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);
				if (refreshView.isShownHeader()) { //是否下拉 true为下拉
					lv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置下拉标签
					lv.getLoadingLayoutProxy().setPullLabel("下拉刷新");
					// 设置释放标签
					lv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间:" + str);
					new GetDataTask().execute();
				}
				if (refreshView.isShownFooter()) { //是否为上拉刷新 true为上拉
					// 设置刷新标签
					lv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
					// 设置下拉标签
					lv.getLoadingLayoutProxy().setPullLabel("上拉加载");
					// 设置释放标签
					lv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
					// 设置上一次刷新的提示标签
					refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间:" + str);
					new ShowFooterTask().execute();
				}
				Log.e("onRefresh===", "onRefresh方法执行了");
			}
		});
	}
	private void init() {
		HomeListEntity homeListEntity = new HomeListEntity(
				R.drawable.home_list_one, R.drawable.home_list, "必买清单",
				R.drawable.home_list_two, R.drawable.home_list_three,
				R.drawable.home_list_four, R.drawable.home_list_five,
				R.drawable.home_list_six);
		// homeList.add(homeListEntity);
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		if (hidden) {
			((HomeTabActivity) getActivity()).dismissProgressBar();
		}
	}

	private class GetDataTask extends AsyncTask<Void, Void, String[]> {
		@SuppressWarnings("ResourceType")
		@Override
		protected String[] doInBackground(Void... params) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			lv.onRefreshComplete();
			super.onPostExecute(result);
		}
	}

	private class ShowFooterTask extends
	AsyncTask<Void, Void, ArrayList<HomeListEntity>> {
		@Override
		protected ArrayList<HomeListEntity> doInBackground(Void... params) {
			// try {
			// Thread.sleep(2000);//睡眠2秒，延迟加载数据
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			fxr.add(new HomeListEntity(R.drawable.home_list_one,
					R.drawable.home_list, "必买清单", R.drawable.home_list_two,
					R.drawable.home_list_three, R.drawable.home_list_four,
					R.drawable.home_list_five, R.drawable.home_list_six));
			return fxr;
		}

		@Override
		protected void onPostExecute(ArrayList<HomeListEntity> result) {
			initAdapter(result);
			lv.onRefreshComplete();

		}

		private void initAdapter(ArrayList<HomeListEntity> data) {
			if (homeAdapter == null) {
				homeAdapter = new HomeAdapter(getActivity(),
						R.layout.home_list_item, data);
				mHomeList.setAdapter(homeAdapter);
			} else {
				homeAdapter.notifyDataSetChanged();
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
