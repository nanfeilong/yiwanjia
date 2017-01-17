package cn.junyun.mall.activity.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import com.hhl.library.FlowTagLayout;
import com.hhl.library.OnTagSelectListener;

import cn.junyun.mall.R;
import cn.junyun.mall.adapter.product.BabyEvlationAdapter;
import cn.junyun.mall.adapter.product.EvlutionAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.BabyEvlationEntity;
import cn.junyun.mall.view.MyListView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 全部评价
 * 
 * @author wang
 * 
 */

@ContentView(R.layout.activity_all_evalution)
public class AllEvalutionActivity extends BaseActivity {
	// title的back
	@ViewInject(value = R.id.btnHeaderBack)
	private Button mBackBt;
	// title返回键旁边的文字
	@ViewInject(value = R.id.back_tv)
	private TextView mBackTv;
	@ViewInject(value = R.id.evlution_flow_layout)
	// 流布局
	private FlowTagLayout mEvlutionLayout;
	private EvlutionAdapter<String> mEvlutionCategoryAdapter;// 评价类型适配器
	private List<String> evlutionDataSource = new ArrayList<String>();// 评价类型集合

	@ViewInject(R.id.all_evlution_lv)
	private ListView mBabyEvlationLv;// 宝贝评价listView

	private BabyEvlationAdapter mBabyEvlationAdapter;// 宝贝评价Adapter

	private ArrayList<BabyEvlationEntity> mBabyEvlationEntities = new ArrayList<BabyEvlationEntity>();


	@Override
	protected void fillView() {

		setHeader();

		initEvlutionCategorAdapter();
		initEvlutionData();
	}

	@Override
	protected void loadData() {

		testData();

		initAdapter();
	}

	@Override
	protected void setListener() {

		mEvlutionLayout.setOnTagSelectListener(new OnTagSelectListener() {

			@Override
			public void onItemSelect(FlowTagLayout parent,
					List<Integer> selectedList, int position) {
				if (selectedList != null && selectedList.size() > 0) {
					mEvlutionCategoryAdapter.setSelectTvColor(position);
					Toast.makeText(AllEvalutionActivity.this,
							"选择了:" + parent.getAdapter().getItem(0),
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(AllEvalutionActivity.this, "没有选择标签",
							Toast.LENGTH_LONG).show();
				}

			}
		});

	}

	/**
	 * 设置评价类型适配器
	 */
	private void initEvlutionCategorAdapter() {

		if (mEvlutionCategoryAdapter == null) {
			mEvlutionCategoryAdapter = new EvlutionAdapter<String>(this);
			mEvlutionLayout.setAdapter(mEvlutionCategoryAdapter);
		} else {
			mEvlutionCategoryAdapter.notifyDataSetChanged();
		}

	}

	/**
	 * 设置头部标题的方法
	 */
	private void setHeader() {
		// 设置title
		mBackTv.setText(getResources().getString(R.string.str_baby_evlution));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);

	}

	/**
	 * 测试数据
	 */

	private void initEvlutionData() {

		evlutionDataSource.add("全部");
		evlutionDataSource.add("整体不错");
		evlutionDataSource.add("一般啦...");
		evlutionDataSource.add("有图哎");
		evlutionDataSource.add("差评啦");
		evlutionDataSource.add("很差");
//		evlutionDataSource.add("特别差");
//		evlutionDataSource.add("根本跟我想的一样");
//		evlutionDataSource.add("什么东东");
//		evlutionDataSource.add("不好");
//		evlutionDataSource.add("好");
//		evlutionDataSource.add("饿");
//		evlutionDataSource.add("不行");
//		evlutionDataSource.add("啊还好还好好好");

		mEvlutionCategoryAdapter.onlyAddAll(evlutionDataSource);
	}

	/**
	 * 回退
	 */
	@Event({ R.id.back_tv, R.id.btnHeaderBack })
	private void back(View v) {
		finish();
	}

	/**
	 * 初始化Adapter
	 */

	private void initAdapter() {

		if (mBabyEvlationAdapter == null) {
			mBabyEvlationAdapter = new BabyEvlationAdapter(
					mBabyEvlationEntities, this);
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
	}

}
