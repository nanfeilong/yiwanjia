package cn.junyun.mall.activity.myaccount;

import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.adapter.myorderadapter.AddressManageAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.AddressManageEntity;

/**
 * 收货地址管理
 * 
 * @author NanFeiLong
 * @date 2016年8月24日
 */
@ContentView(R.layout.activity_address_manage)
public class AddressManageActivity extends BaseActivity {
		
		/**
		 * 返回"箭头"点击方法
		 * @param view
		 * @date 2016年8月3日
		 */
	// 收货地址管理--->返回箭头
	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt;
	// 收货地址管理--->顶部“收货地址管理”标题
	@ViewInject(R.id.back_tv)
	private TextView mBackTv;
	//收货地址管理--添加新地址
	@ViewInject(R.id.btn_address_new)
	private Button mAddressNewBt;


	// pop显示参照物
	@ViewInject(R.id.parent_view)
	private RelativeLayout mParentView;

	// ListView
	@ViewInject(R.id.lv_address_manage)
	private ListView mAddressMagageLv;
	private AddressManageAdapter maddressManageAdapter;
	private ArrayList<AddressManageEntity> addressManageEntities2 = new ArrayList<AddressManageEntity>();
	private ArrayList<AddressManageEntity> addressManageEntities1 = new ArrayList<AddressManageEntity>();
	private ArrayList<AddressManageEntity> addressManageEntitiesAll = new ArrayList<AddressManageEntity>();

	@Override
	protected void fillView() {
		// TODO Auto-generated method stub
		super.fillView();
		mBackTv.setText(getResources().getString(
				R.string.str_tv_myaccount_addressmanage));// 设置成收货地址管理标题
		mBackBt.setVisibility(View.VISIBLE);// 返回箭头可见
		mBackBt.setBackgroundResource(R.drawable.back);// 设置返回箭头图片

		addressManageEntities1.add(new AddressManageEntity("高艳", "18292426151",
				"陕西省西安市雁塔区丈八沟街道汇鑫IBC -D座 12楼 1206室", false));
		addressManageEntities1.add(new AddressManageEntity("南飞龙",
				"13468615895", "陕西省西安市雁塔区丈八沟街道汇鑫IBC -C座 13楼 1206室", true));
		addressManageEntities1.add(new AddressManageEntity("王小京",
				"13459876214", "陕西省西安市雁塔区丈八沟街道汇鑫IBC -E座 14楼 1206室", false));

		addressManageEntities2.add(new AddressManageEntity("高艳", "18292426151",
				"陕西省西安市雁塔区丈八沟街道汇鑫IBC -D座 12楼 1206室", true));
		addressManageEntities2.add(new AddressManageEntity("南飞龙",
				"13468615895", "陕西省西安市雁塔区丈八沟街道汇鑫IBC -C座 13楼 1206室", false));
		addressManageEntities2.add(new AddressManageEntity("王小京",
				"13459876214", "陕西省西安市雁塔区丈八沟街道汇鑫IBC -E座 14楼 1206室", false));
	}

	@Override
	protected void loadData() {
		// TODO Auto-generated method stub
		super.loadData();
		if (maddressManageAdapter == null) {
			addressManageEntitiesAll.clear();
			addressManageEntitiesAll.addAll(addressManageEntities1);
			maddressManageAdapter = new AddressManageAdapter(this,
					addressManageEntitiesAll, mParentView) {

				@Override
				public void postDefaultCheckbox() {

					addressManageEntitiesAll.clear();
					addressManageEntitiesAll.addAll(addressManageEntities2);
					maddressManageAdapter.notifyDataSetChanged();

				}

			};
			mAddressMagageLv.setAdapter(maddressManageAdapter);
		} else {
			maddressManageAdapter.notifyDataSetChanged();
		}
	}

	/**
	 * 返回"箭头"点击方法
	 * @param view
	 * @date 2016年8月3日
	 */

	@Event(value = { R.id.btnHeaderBack, R.id.back_tv }, type = View.OnClickListener.class)
	private void mBackBt(View view) {
		finish();
	}
	
	/**
	 * 添加新地址
	 * @param view
	 * @date 2016年8月31日
	 */
	@Event(R.id.btn_address_new)
	private void mAddressNewBt(View view) {
		Intent intent = new Intent(this, AddressNewActivity.class);
		startActivity(intent);
	}
	
	
	
	

}
