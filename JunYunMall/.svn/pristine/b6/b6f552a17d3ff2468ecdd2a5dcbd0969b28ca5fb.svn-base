package cn.junyun.mall.activity.home.fragment;

import java.util.ArrayList;
import java.util.List;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.catgegory.CategoryActivity;
import cn.junyun.mall.activity.catgegory.CategoryOneLeveActivity;
import cn.junyun.mall.activity.home.HomeTabActivity;
import cn.junyun.mall.adapter.categoryadapter.CategoryLeftAdapter;
import cn.junyun.mall.adapter.categoryadapter.CategoryRightAdapter;
import cn.junyun.mall.base.BaseFragment;
import cn.junyun.mall.business.MemberBusiness;
import cn.junyun.mall.constant.Constant;
import cn.junyun.mall.model.CategoryLeftEntity;
import cn.junyun.mall.model.CategoryRightEntity;
import cn.junyun.mall.model.Member;

@ContentView(R.layout.fragment_goods_classification_layout)
public class GoodsClassificationFragment extends BaseFragment {

	/**
	 * 商品分类
	 */

	@ViewInject(R.id.category_list_left)
	ListView mLeftListView;// 左侧分类
	@ViewInject(R.id.category_gride_right)
	GridView mRightGridView;// 右侧分类
	@ViewInject(R.id.in_category_bt)
	Button mInCategoryBt;// 进入各种品牌按钮

	private int mPosition;// 左侧listView按钮点击的位置

	ArrayList<CategoryLeftEntity> mCategoryLeftEntities = new ArrayList<CategoryLeftEntity>();// 左侧listView数据集合
	ArrayList<CategoryRightEntity> mCategoryrightsEntities = new ArrayList<CategoryRightEntity>();// 右侧GridView数据集合

	private CategoryLeftAdapter mCategoryLeftAdapter;// 左侧适配器
	private CategoryRightAdapter mCategoryRightAdapter;// 右侧侧适配器

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			String sMsg = null;
			Bundle bundle = null;
			switch (msg.what) {
			case MemberBusiness.MEMBERINFO_REQUEST_OK:// 获取分类信息成功
				((HomeTabActivity) getActivity()).dismissProgressBar();
				// 获得消息内容
				Member member = (Member) msg.obj;
				// 显示数据

				break;

			// 错误信息
			case Constant.SHOW_RETURN_ERROR_MSG:
				bundle = msg.getData();
				sMsg = bundle.getString("msg");
				if (!TextUtils.isEmpty(sMsg) && sMsg != null) {
					toast(sMsg);
				}
				break;

			}
		}

	};

	@Override
	protected void loadData() {
		// TODO Auto-generated method stub
		super.loadData();

		mRightGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));// 去除gridView点击效果

		testLeftAdapterData();

		testRightAdapterData();

		initAdapterLeft(mCategoryLeftEntities);

		initAdapterRight(mCategoryrightsEntities);

	}

	/**
	 * 设置监听器
	 */

	@Override
	protected void setListener() {

		mLeftListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				mPosition = position;

				mCategoryRightAdapter = new CategoryRightAdapter(getActivity(),
						mCategoryrightsEntities);

				mRightGridView.setAdapter(mCategoryRightAdapter);

				// 设置左侧listView的字体背景
				if (mCategoryLeftAdapter != null) {
					mCategoryLeftAdapter.setColor(position);
					mCategoryRightAdapter.setPosition(position);

				}

				// 设置进入各种品牌的红色按钮可见与不可见
				if (position == 0) {
					mInCategoryBt.setVisibility(View.GONE);
				} else {
					mInCategoryBt.setText("进入"
							+ mCategoryLeftEntities.get(position).getName()
							+ ">>");
					mInCategoryBt.setVisibility(View.VISIBLE);
				}

			}
		});

		mRightGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				startActivity(new Intent(getActivity(), CategoryActivity.class));

			}
		});

	}

	/**
	 * 初始化左侧适配器
	 * 
	 * @param beans
	 */

	private void initAdapterLeft(List<CategoryLeftEntity> beans) {

		if (mCategoryLeftAdapter == null) {
			mCategoryLeftAdapter = new CategoryLeftAdapter(
					(ArrayList<CategoryLeftEntity>) beans, getActivity());
			mLeftListView.setAdapter(mCategoryLeftAdapter);
		} else {
			mCategoryLeftAdapter.notifyDataSetChanged();
		}

	}

	/**
	 * 初始化右侧适配器
	 * 
	 * @param beans
	 */

	private void initAdapterRight(List<CategoryRightEntity> beans) {

		if (mCategoryRightAdapter == null) {
			mCategoryRightAdapter = new CategoryRightAdapter(getActivity(),
					beans);

			mRightGridView.setAdapter(mCategoryRightAdapter);
		} else {
			mCategoryRightAdapter.notifyDataSetChanged();
		}

	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		if (hidden) {
			((HomeTabActivity) getActivity()).dismissProgressBar();
		}

	}

	/**
	 * 测试左侧商品分类数据
	 */

	private void testLeftAdapterData() {

		mCategoryLeftEntities.add(new CategoryLeftEntity("实时推荐"));
		mCategoryLeftEntities.add(new CategoryLeftEntity("潮流女装"));
		mCategoryLeftEntities.add(new CategoryLeftEntity("精品男装"));
		mCategoryLeftEntities.add(new CategoryLeftEntity("时尚女鞋"));
		mCategoryLeftEntities.add(new CategoryLeftEntity("品质男鞋"));
		mCategoryLeftEntities.add(new CategoryLeftEntity("个性箱包"));

	}

	/**
	 * 测试右侧商品分类数据
	 */

	private void testRightAdapterData() {

		for (int i = 0; i < 10; i++) {
			mCategoryrightsEntities.add(new CategoryRightEntity("衬衫"));
			mCategoryrightsEntities.add(new CategoryRightEntity("针织"));
			mCategoryrightsEntities.add(new CategoryRightEntity("啼血"));
			mCategoryrightsEntities.add(new CategoryRightEntity("雪纺衫"));
			mCategoryrightsEntities.add(new CategoryRightEntity("短外套"));
		}
	}

	/*
	 * 点击红色的按钮进入各种类型的衣服
	 */
	@Event(R.id.in_category_bt)
	private void gotoOnLeveCategory(View v) {
		String cloneType = mCategoryLeftEntities.get(mPosition).getName();// 衣服的类型
		Intent intent = new Intent(getActivity(), CategoryOneLeveActivity.class);
		intent.putExtra("cloneType", cloneType);
		startActivity(intent);
	}
	
	
	

}
