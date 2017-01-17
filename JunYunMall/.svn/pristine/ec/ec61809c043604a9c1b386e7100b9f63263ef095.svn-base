package cn.junyun.mall.activity.myaccount;

import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.adapter.myorderadapter.AddressSeleteAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.AddressEntity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 县选择Activity
 */

@ContentView(R.layout.activity_provice_address_select)
public class AreaAddressSelectActivity extends BaseActivity {

	@ViewInject(R.id.provice_lv)
	private ListView mProviceLv;

	// title的back
	@ViewInject(value = R.id.btnHeaderBack)
	private Button mBackBt;
	// title返回键旁边的文字
	@ViewInject(value = R.id.back_tv)
	private TextView mBackTv;

	private AddressSeleteAdapter mAddressSeleteAdapter;// 省选择适配器

	private ArrayList<AddressEntity> mAddressEntities = new ArrayList<AddressEntity>();

	@Override
	protected void loadData() {

		setHeader();
		testData();
		initAdapter();
	}
	
	
	
	
	
	

	/**
	 * 设置头部标题
	 */

	private void setHeader() {
		// 设置title
		mBackTv.setText(getResources().getString(R.string.str_select_address));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);

	}

	/**
	 * 初始化适配器
	 */

	private void initAdapter() {
		if (mAddressSeleteAdapter == null) {
			mAddressSeleteAdapter = new AddressSeleteAdapter(mAddressEntities,
					this);
			mProviceLv.setAdapter(mAddressSeleteAdapter);

		} else {
			mAddressSeleteAdapter.notifyDataSetChanged();
		}
	}

	/**
	 * 测试数据
	 */
	private void testData() {
		mAddressEntities.add(new AddressEntity("高陵县"));
		mAddressEntities.add(new AddressEntity("临潼县"));
		mAddressEntities.add(new AddressEntity("湖南省"));
		mAddressEntities.add(new AddressEntity("湖北省"));
		mAddressEntities.add(new AddressEntity("江西省"));
		mAddressEntities.add(new AddressEntity("山西省"));
		mAddressEntities.add(new AddressEntity("河南省"));
		mAddressEntities.add(new AddressEntity("河北省"));
		mAddressEntities.add(new AddressEntity("云南省"));
		mAddressEntities.add(new AddressEntity("湖北省"));
		mAddressEntities.add(new AddressEntity("江西省"));
		mAddressEntities.add(new AddressEntity("山西省"));
		mAddressEntities.add(new AddressEntity("河南省"));
		mAddressEntities.add(new AddressEntity("河北省"));
		mAddressEntities.add(new AddressEntity("云南省"));
		mAddressEntities.add(new AddressEntity("湖北省"));
		mAddressEntities.add(new AddressEntity("江西省"));
		mAddressEntities.add(new AddressEntity("山西省"));
		mAddressEntities.add(new AddressEntity("河南省"));
		mAddressEntities.add(new AddressEntity("河北省"));
		mAddressEntities.add(new AddressEntity("云南省"));
		mAddressEntities.add(new AddressEntity("河南省"));
		mAddressEntities.add(new AddressEntity("河北省"));
		mAddressEntities.add(new AddressEntity("云南省"));
		mAddressEntities.add(new AddressEntity("湖北省"));
		mAddressEntities.add(new AddressEntity("江西省"));
		mAddressEntities.add(new AddressEntity("山西省"));
		mAddressEntities.add(new AddressEntity("河南省"));
	}
	
	
	/**
	 * 回退
	 */
	@Event({ R.id.back_tv, R.id.btnHeaderBack })
	private void back(View v) {
		finish();
	}

}
