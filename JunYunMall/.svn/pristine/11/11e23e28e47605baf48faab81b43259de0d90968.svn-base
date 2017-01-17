package cn.junyun.mall.adapter.myorderadapter;

import cn.junyun.mall.activity.mycollect.MyCollectBadyFragment;
import cn.junyun.mall.activity.mycollect.MyCollectShopFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
/**
 * 我的收藏 viewPager适配器
 * @author NanFeiLong
 * @date 2016年8月23日
 */
public class MyCollectFragmentAdapter extends FragmentPagerAdapter {

	public MyCollectFragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int myCollectPosition) {
		Fragment fragment = null;
		switch (myCollectPosition) {
		// 宝贝
		case 0:
			fragment = new MyCollectBadyFragment();
			break;
			// 店铺
		case 1:
			fragment = new MyCollectShopFragment();
			break;
		default:
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}

}
