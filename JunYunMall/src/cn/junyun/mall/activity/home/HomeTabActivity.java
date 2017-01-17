package cn.junyun.mall.activity.home;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import com.zxing.activity.CaptureActivity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.home.fragment.GoodsClassificationFragment;
import cn.junyun.mall.activity.home.fragment.HomeFragment;
import cn.junyun.mall.activity.home.fragment.MyMallFragment;
import cn.junyun.mall.activity.home.fragment.ShopCartFragment;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.view.CheckImageText;

/*
 * 首页底部导航
 */
@ContentView(R.layout.activity_home_tab)
public class HomeTabActivity extends BaseActivity {
	
	@ViewInject(R.id.home_page_cit)
	CheckImageText mHomePageCit;// 首页按钮
	@ViewInject(R.id.classification_cit)
	CheckImageText mClassificationCit;// 分类按钮
	@ViewInject(R.id.shopping_cart_cit)
	CheckImageText mShoppingCartCit;// 我的购物车按钮
	@ViewInject(R.id.my_store_cit)
	CheckImageText mMyStoreCit;// 我的商城按钮
	@ViewInject(R.id.title)
	View mTitleLayout;// 标题栏
	/*
	 * 二维码跳转
	 */
	@ViewInject(R.id.left_image)
	Button mLeftImage;//标题最左边按钮
	@ViewInject(R.id.btnHeaderExtra)
	Button mBtnHeaderExtra;//标题最右边按钮
	@ViewInject(R.id.back_tv)
	Button mBack_tv;//靠近回退箭头的标题

	FragmentManager mFragmentManager;
	HomeFragment mHomeFragment;// 首页
	GoodsClassificationFragment mGoodsClassificationFragment;// 分类
	ShopCartFragment mShopCartFragment;// 购物车
	MyMallFragment mMallFragment;// 我的商城

	//存放四个模块的集合
	List<CheckImageText> mCheckImageTextList = new ArrayList<CheckImageText>();

	@Override
	protected void fillView() {

		super.fillView();

		// 将底部导航四个按钮加到集合里面
		mCheckImageTextList.add(mHomePageCit);//首页0
		mCheckImageTextList.add(mClassificationCit);//分类1
		mCheckImageTextList.add(mShoppingCartCit);//购物车2
		mCheckImageTextList.add(mMyStoreCit);//我的商城3
		mFragmentManager = getSupportFragmentManager();
	}



	@Override
	protected void loadData() {
		// TODO Auto-generated method stub
		super.loadData();
		// 用户刚进入的界面为首页
		setTabSelection(0);


	}

	private void setTabSelection(int index) {
		// 开启一个Fragment事务
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 0: // 首页
			mTitleLayout.setVisibility(View.VISIBLE);
			mLeftImage.setVisibility(View.VISIBLE);
			mLeftImage.setBackgroundDrawable(getResources().getDrawable(R.drawable.scan));
			mBtnHeaderExtra.setVisibility(View.VISIBLE);
			mBtnHeaderExtra.setBackgroundDrawable(getResources().getDrawable(R.drawable.search));
			setTitle(getResources().getString(R.string.str_some));//亿万家

			setCheckedIndex(0);
			if (mHomeFragment == null) { //如果首页为空
				mHomeFragment = new HomeFragment(); //创建首页"界面"
				transaction.add(R.id.guide_tab_rl, mHomeFragment);//将创建的“首页”加添到要显示的layout中，并显示
			}
			else {
				transaction.show(mHomeFragment); //如果首页存在，则直接显示首页

			}
			break;
		case 1: // 分类

			mLeftImage.setVisibility(View.VISIBLE);
			mLeftImage.setBackgroundDrawable(getResources().getDrawable(R.drawable.scan));
			mBtnHeaderExtra.setVisibility(View.VISIBLE);
			mBtnHeaderExtra.setBackgroundDrawable(getResources().getDrawable(R.drawable.search));
			mTitleLayout.setVisibility(View.VISIBLE);
			setCheckedIndex(1);
			setTitle(getResources().getString(R.string.str_classification));//分类
			if (mGoodsClassificationFragment == null) {
				mGoodsClassificationFragment = new GoodsClassificationFragment();
				transaction.add(R.id.guide_tab_rl, mGoodsClassificationFragment);
			}
			else {
				transaction.show(mGoodsClassificationFragment);


			}

			break;
		case 2: // 购物车
			mLeftImage.setVisibility(View.GONE);
			mTitleLayout.setVisibility(View.VISIBLE);
			mBtnHeaderExtra.setVisibility(View.GONE);
			setTitle(getResources().getString(R.string.str_shopping_cart));//购物车
			setCheckedIndex(2);
			if (mShopCartFragment == null) {
				mShopCartFragment = new ShopCartFragment();
				transaction.add(R.id.guide_tab_rl, mShopCartFragment);

			}
			else {
				transaction.show(mShopCartFragment);

			}
			break;
		case 3: // 我的商城
			mLeftImage.setVisibility(View.VISIBLE);
			mLeftImage.setBackgroundDrawable(getResources().getDrawable(R.drawable.scan));
			mBtnHeaderExtra.setVisibility(View.VISIBLE);
			mBtnHeaderExtra.setBackgroundDrawable(getResources().getDrawable(R.drawable.search));
			mTitleLayout.setVisibility(View.VISIBLE);
			setTitle(getResources().getString(R.string.str_my_mall));//我的商城
			setCheckedIndex(3);
			if (mMallFragment == null) {
				mMallFragment = new MyMallFragment();
				transaction.add(R.id.guide_tab_rl, mMallFragment);
			}
			else {
				transaction.show(mMallFragment);


			}
			break;
		default:
			break;
		}
		transaction.commit();
	}

	void setCheckedIndex(int index) {
		for (int i = 0; i < mCheckImageTextList.size(); i++) {
			mCheckImageTextList.get(i).setChecked(index == i);
		}
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * @param transaction 用于对Fragment执行操作的事务
	 * //判断页面是否已经创建，如果已经创建，则隐藏页面
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (mHomeFragment != null) {
			transaction.hide(mHomeFragment);
		}
		if (mGoodsClassificationFragment != null) {
			transaction.hide(mGoodsClassificationFragment);
		}
		if (mShopCartFragment != null) {
			transaction.hide(mShopCartFragment);
		}
		if (mMallFragment != null) {
			transaction.hide(mMallFragment);
		}
	}





	@Override
	protected void onPause() {
		super.onPause();
		JPushInterface.onPause(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		JPushInterface.onResume(this);
	}


	/*
	 * 点击进入首页
	 */
	@Event(R.id.home_page_cit)
	private void goToHomePage(View v) {
		setTabSelection(0);
	}

	/*
	 * 点击进入分类
	 */
	@Event(R.id.classification_cit)
	private void goToClassification(View v) {
		setTabSelection(1);
	}

	/*
	 * 点击进入购物车
	 */
	@Event(R.id.shopping_cart_cit)
	private void goToShoppingCart(View v) {
		setTabSelection(2);

	}

	/*
	 * 点击进入我的商城
	 */
	@Event(R.id.my_store_cit)
	private void goToMyStore(View v) {
		setTabSelection(3);
	}

	/*
	 * 扫一扫
	 */
	@Event(R.id.left_image)
	private void Scan(View v) {
		Intent intent=new Intent(HomeTabActivity.this,CaptureActivity.class);
		startActivityForResult(intent, 0);

	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			String  result=data.getExtras().getString("result");
			Log.i("二维码扫描结果",result);
			Toast.makeText(HomeTabActivity.this, result, 1).show();
		}
	}

}
