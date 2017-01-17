package cn.junyun.mall.adapter.myorderadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.home.fragment.MyMallFragment;
import cn.junyun.mall.activity.order.MyOrderAllFragment;
import cn.junyun.mall.model.MyOrderAllEntity;
import cn.junyun.mall.view.MyListView;
/**
 * 店名列表适配器
 * @author NanFeiLong
 * @date 2016年8月19日
 */
public abstract   class MyOrderAllAdapter extends BaseAdapter {

	private ArrayList<MyOrderAllEntity> mOrderAllEntities;
	private Context mcontext;
	private LayoutInflater mInflater;
	private int mFlag;
	
	MyOrderAllInnerAdapter myOrderAllInnerAdapter;

	public MyOrderAllAdapter(Context context,
			ArrayList<MyOrderAllEntity> myOrderAllEntities, int Flag) {
		this.mInflater = LayoutInflater.from(context);
		this.mcontext = context;
		this.mOrderAllEntities = myOrderAllEntities;
		this.mFlag = Flag;
	}

	@Override
	public int getCount() {
		return mOrderAllEntities == null ? 0 : mOrderAllEntities.size();
	}

	@Override
	public Object getItem(int position) {
		return mOrderAllEntities.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("NewApi") @Override
	public View getView( final int outerPosition, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_myorder_all_items,null);
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		MyOrderAllEntity myOrderAllEntity = mOrderAllEntities.get(outerPosition);
		myOrderAllInnerAdapter = new MyOrderAllInnerAdapter(mcontext, myOrderAllEntity.getMyOrderAllInnerEntities(), mFlag){

			@Override
			public void post(int innerPosition ) {
				//刷新Adapter
				outpost(innerPosition,outerPosition);
			}
			 
		 };

		
		viewHolder.mOrderInnerMLv.setAdapter(myOrderAllInnerAdapter);
		viewHolder.mShopNameTv.setText(myOrderAllEntity.getShopName()); // 店名
		viewHolder.mTransactionStatusTv.setText(myOrderAllEntity.getTransactionStatus());// 交易状态
		return convertView;
	}

	/*
	 * 兄弟抱一下
	 * 逆战
	 * 七里香
	 * 大约在冬季
	 * 爱在西元前
	 */
	
	class ViewHolder {
		// 店名
		@ViewInject(R.id.tv_myorder_all_shopname)
		TextView mShopNameTv;
		// 交易状态
		@ViewInject(R.id.tv_myorder_all_transaction_status)
		TextView mTransactionStatusTv;
		//内部listview
		@ViewInject(R.id.mlv_myorder_inner_listView)
		MyListView mOrderInnerMLv;
	
	}	
	
	public abstract void outpost(int innerPosition ,int outerPosition);
	
}
