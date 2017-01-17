package cn.junyun.mall.activity.product.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.product.AllEvalutionActivity;
import cn.junyun.mall.adapter.product.BabyEvlationAdapter;
import cn.junyun.mall.base.BaseFragment;
import cn.junyun.mall.model.BabyEvlationEntity;
import cn.junyun.mall.view.MyListView;

/**
 * 宝贝评价
 * 
 */
@ContentView(R.layout.fragment_baby_evlation_layout)
public class BabyEvlationFragment extends BaseFragment {
	@ViewInject(R.id.babay_evlation_lv)
	private MyListView mBabyEvlationLv;// 宝贝评价listView

	private BabyEvlationAdapter mBabyEvlationAdapter;// 宝贝评价Adapter

	private ArrayList<BabyEvlationEntity> mBabyEvlationEntities = new ArrayList<BabyEvlationEntity>();

	@ViewInject(R.id.spaceView)
	private View mspaceView;// 空View
	@ViewInject(R.id.parent_layout)
	private RelativeLayout mParentLayout;// 父容器
	@ViewInject(R.id.see_all_comments_layout)
	private LinearLayout mSeeAllCommentsLayout;// 查看全部pinglun
	
	
	


	@Override
	protected void loadData() {

		testData();

		initAdapter();
		getViewHeight();

	}
	

	/**
	 * 初始化Adapter
	 */

	private void initAdapter() {

		if (mBabyEvlationAdapter == null) {
			mBabyEvlationAdapter = new BabyEvlationAdapter(
					mBabyEvlationEntities, getActivity());
			mBabyEvlationLv.setAdapter(mBabyEvlationAdapter);

		} else {
			mBabyEvlationAdapter.notifyDataSetChanged();
		}

	}

	/**
	 * 测试数据`
	 */

	private void testData() {
		mBabyEvlationEntities.add(new BabyEvlationEntity(
				"好衣服的去阿尔法全额就放弃而1；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
				"2016年7月7日", "粉红色"));
		mBabyEvlationEntities.add(new BabyEvlationEntity(
				"好衣服的去阿尔法全额就放弃而2；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
				"2016年7月7日", "粉红色"));
		mBabyEvlationEntities.add(new BabyEvlationEntity(
				"好衣服的去阿尔法全额就放弃而3；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
				"2016年7月7日", "粉红色"));
		 mBabyEvlationEntities.add(new BabyEvlationEntity(
		 "好衣服的去阿尔法全额就放弃而4；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
		 "2016年7月7日", "粉红色"));
//		 mBabyEvlationEntities.add(new BabyEvlationEntity(
//		 "好衣服的去阿尔法全额就放弃而5；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
//		 "2016年7月7日", "粉红色"));
//		 mBabyEvlationEntities.add(new BabyEvlationEntity(
//		 "好衣服的去阿尔法全额就放弃而6；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
//		 "2016年7月7日", "粉红色"));
//		 mBabyEvlationEntities.add(new BabyEvlationEntity(
//		 "好衣服的去阿尔法全额就放弃而7；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
//		 "2016年7月7日", "粉红色"));
//		 mBabyEvlationEntities.add(new BabyEvlationEntity(
//		 "好衣服的去阿尔法全额就放弃而8；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
//		 "2016年7月7日", "粉红色"));
//		 mBabyEvlationEntities.add(new BabyEvlationEntity(
//		 "好衣服的去阿尔法全额就放弃而9；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
//		 "2016年7月7日", "粉红色"));
//		 mBabyEvlationEntities.add(new BabyEvlationEntity(
//		 "好衣服的去阿尔法全额就放弃而10；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
//		 "2016年7月7日", "粉红色"));
//		 mBabyEvlationEntities.add(new BabyEvlationEntity(
//		 "好衣服的去阿尔法全额就放弃而11；飞if额服务器efi哦我回去覅噢我去诶分为回复", "超级超级大坏蛋那",
//		 "2016年7月7日", "粉红色"));
	}

	
	private void getViewHeight(){
		mParentLayout.measure(0, 0);  
		int  height = mParentLayout.getMeasuredHeight();  
		
		
		if (mHeight - dip2px(150)- getStatusBarHeight()> height) {

			LinearLayout.LayoutParams parmas = new LinearLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, (int) (mHeight
							- dip2px(150) - height+getStatusBarHeight()));

			mspaceView.setLayoutParams(parmas);
		}
		
	}
	
	/**
	 * 查看全部评价
	 */
	@Event(R.id.bottom_bt)
	private void seeAllEvlution(View v){
		startActivity(new Intent(getActivity(),AllEvalutionActivity.class));
		
	}
	


}
