package cn.junyun.mall.adapter.myorderadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.myaccount.AddressNewActivity;
import cn.junyun.mall.activity.myaccount.MyAccountActivity;
import cn.junyun.mall.model.AddressManageEntity;

public  abstract  class AddressManageAdapter extends BaseAdapter {

	private Context mcontext;
	private ArrayList<AddressManageEntity> addressManageEntities;
	private LayoutInflater mInflater;


	private PopupWindow mPopupWindow; //popwindow
	private View mpopview;  //弹出框的布局
	private RelativeLayout parentView;


	public AddressManageAdapter(Context context,ArrayList<AddressManageEntity> manageEntities ,RelativeLayout parentView) {
		super();
		this.mcontext = context;
		this.addressManageEntities = manageEntities;
		this.mInflater = LayoutInflater.from(context);
		this.parentView = parentView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return addressManageEntities.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return addressManageEntities.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressWarnings("unused")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolderAddress viewHolderAddress = null;
		MyListenerAddress myListenerAddress  = null;
		AddressManageEntity addressManageEntity = addressManageEntities.get(position);
		if(viewHolderAddress == null) {
			viewHolderAddress = new ViewHolderAddress();
			//myListenerAddress = new MyListenerAddress(position);
			convertView = mInflater.inflate(R.layout.adapter_address_manage_items, null);
			x.view().inject(viewHolderAddress, convertView);
			convertView.setTag(viewHolderAddress);
		} else {
			viewHolderAddress = (ViewHolderAddress) convertView.getTag();
		}

		viewHolderAddress.mConsigneeNameTv.setText(addressManageEntity.getConsigneeNameTv());
		viewHolderAddress.mConsigneePhoneNumberTv.setText(addressManageEntity.getConsigneePhoneNumberTv());
		viewHolderAddress.mConsigneeAddressTv.setText(addressManageEntity.getConsigneeAddressTv());
		myListenerAddress = new MyListenerAddress(position);
		viewHolderAddress.mIsdefaultAddressCx.setOnClickListener(myListenerAddress);//checkBox

		if(addressManageEntities.get(position).isCheckBoxAddressBl()) {
			viewHolderAddress.mIsdefaultAddressCx.setText("默认地址");
			viewHolderAddress.mIsdefaultAddressCx.setChecked(true);
		}else {
			viewHolderAddress.mIsdefaultAddressCx.setText("设为默认地址");
			viewHolderAddress.mIsdefaultAddressCx.setChecked(false);
		}
		viewHolderAddress.mAddressEditBt.setTag(position);
		viewHolderAddress.mAddressEditBt.setOnClickListener(myListenerAddress);
		viewHolderAddress.mAddressDeleteBt.setTag(position);
		viewHolderAddress.mAddressDeleteBt.setOnClickListener(myListenerAddress);


		return convertView;
	}


	class ViewHolderAddress {
		//收货人姓名
		@ViewInject(R.id.tv_consignee_name)
		private TextView mConsigneeNameTv;
		//电话
		@ViewInject(R.id.tv_consignee_phone_number)
		private TextView mConsigneePhoneNumberTv;
		//地址
		@ViewInject(R.id.tv_consignee_address)
		private TextView mConsigneeAddressTv;
		//是否选择默认收货地址
		@ViewInject(R.id.isdefault_checkbox_address)
		private CheckBox mIsdefaultAddressCx;
		//编辑
		@ViewInject(R.id.btn_address_edit)
		private Button mAddressEditBt;
		//删除
		@ViewInject(R.id.btn_address_delete)
		private Button mAddressDeleteBt;

	}




	/**
	 * item中控件的点击事件
	 * 
	 * @author Administrator
	 * @date 2016年8月15日
	 */
	private class MyListenerAddress implements OnClickListener {
		int mPosition;

		public MyListenerAddress(int inPosition) {
			mPosition = inPosition;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.isdefault_checkbox_address:
				addressManageEntities.get(mPosition).setCheckBoxAddressBl(true);
				postDefaultCheckbox();
				break;
			case R.id.btn_address_edit:
				Toast.makeText(mcontext, "编辑" +addressManageEntities.get(mPosition), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(mcontext, AddressNewActivity.class);
				intent.putExtra("editAddress", 25);
				mcontext.startActivity(intent);
				
				break;
			case R.id.btn_address_delete:
				//Toast.makeText(mcontext, "删除" +addressManageEntities.get(mPosition), Toast.LENGTH_SHORT).show();
				SureDeleteAddress();
				break;
			default:
				break;
			}

		}





		private void SureDeleteAddress() {
			// TODO Auto-generated method stub
			LayoutInflater inflater = LayoutInflater.from(mcontext);
			mpopview = inflater.inflate(R.layout.popupwindow_delete_address,null);//加载动画布局
			mPopupWindow = new PopupWindow(mpopview,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT, true);//设置布局在屏幕中显示的位置，并且获取焦点
			//设置PopupWindow的显示样式
			//mPopupWindow.setBackgroundDrawable(getResources().getDrawable());
			mPopupWindow.setAnimationStyle(R.style.PopupAnimation);
			//实例化一个ColorDrawable颜色为半透明
			//ColorDrawable dw = new ColorDrawable(0x00000000);
			//设置SelectPicPopupWindow弹出窗体的背景
			//mPopupWindow.setBackgroundDrawable(dw);
			//			backgroundAlpha((Activity) mcontext,0.5f);//设置半透明0.0-1.0 
			mPopupWindow.setFocusable(true);
			mPopupWindow.setOutsideTouchable(false);//设置不允许在外点击消失

			// 当弹出时 设置背景颜色变暗
			WindowManager.LayoutParams lp = ((Activity) mcontext).getWindow().getAttributes();
			lp.alpha = 0.7f;
			((Activity) mcontext).getWindow().setAttributes(lp);	
			mPopupWindow.setOnDismissListener(new OnDismissListener() {

				@Override
				public void onDismiss() {
					//					// TODO Auto-generated method stub
					//设置当mPopupWindow取消时，界面恢复原来的颜色 不是可透明的
					backgroundAlpha((Activity) mcontext, 1f);//不透明
				}
			});

			mPopupWindow.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);//弹出的mPopupWindow左上角正对mGoneView的左下角  偏移量默认为0,0
			Button mMakeSureDeleteBt = (Button) mpopview.findViewById(R.id.btn_makesure_delete);//确定要删除吗？
			Button mSureDeleteBt = (Button) mpopview.findViewById(R.id.btn_yes_delete);//删除
			Button mCancelBt = (Button) mpopview.findViewById(R.id.btn_no_cancel);//取消
			mMakeSureDeleteBt.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) { //确定删除
					// TODO Auto-generated method stub
					Toast.makeText(mcontext, "确定删除", Toast.LENGTH_SHORT).show();
				}
			});


			mSureDeleteBt.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {  //删除
					// TODO Auto-generated method stub
					Toast.makeText(mcontext, "删除", Toast.LENGTH_SHORT).show();

				}
			});


			mCancelBt.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {  //取消
					// TODO Auto-generated method stub
					Toast.makeText(mcontext, "取消", Toast.LENGTH_SHORT).show();
					mPopupWindow.dismiss();

				}
			});



		}




	}



	/**
	 * 设置添加屏幕的背景透明度
	 * @param context
	 * @param bgAlpha(透明度 取值返回0-1, 0全透明,1不透明)
	 * @date 2016年8月6日
	 */
	public void backgroundAlpha(Activity context, float bgAlpha) {

		WindowManager.LayoutParams lp = ((Activity) mcontext).getWindow().getAttributes();
		lp.alpha = bgAlpha;
		((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		((Activity) context).getWindow().setAttributes(lp);
	}




	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public int dip2px(float dpValue) {
		final float scale = mcontext.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	public abstract void postDefaultCheckbox();

}
