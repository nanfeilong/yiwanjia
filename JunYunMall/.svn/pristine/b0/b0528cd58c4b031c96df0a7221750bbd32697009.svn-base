package cn.junyun.mall.adapter.myorderadapter;

import java.util.ArrayList;


import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.model.MyOrderAllEntity;
import cn.junyun.mall.view.MyListView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 退款/售后 外部listview适配器
 * @author Administrator
 * @date 2016年8月30日
 */

public class RrturnGoodsAllAdapter extends BaseAdapter {
	
	private ArrayList<MyOrderAllEntity> mOrderAllEntities;
	private Context mcontext;
	private LayoutInflater mInflater;
	
	RrturnGoodsInnerAdapter rrturnGoodsInnerAdapter;
	
	

	public RrturnGoodsAllAdapter(ArrayList<MyOrderAllEntity> mOrderAllEntities,
			Context context) {
		super();
		this.mOrderAllEntities = mOrderAllEntities;
		this.mcontext = context;
		this.mInflater = LayoutInflater.from(context);
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
	
	
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_return_aftersale_all_items,null);
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		MyOrderAllEntity myOrderAllEntity = mOrderAllEntities.get(position);
		rrturnGoodsInnerAdapter = new RrturnGoodsInnerAdapter(myOrderAllEntity.getMyOrderAllInnerEntities(), mcontext);
		
		viewHolder.mReturnAfterScleInnerLv.setAdapter(rrturnGoodsInnerAdapter);
		viewHolder.mShopNameTv.setText(myOrderAllEntity.getShopName()); // 店名
		viewHolder.mTransactionStatusTv.setText(myOrderAllEntity.getTransactionStatus());// 交易状态
		return convertView;
	}
	
	
	
	class ViewHolder {
		// 店名
		@ViewInject(R.id.tv_myorder_all_shopname)
		TextView mShopNameTv;
		// 交易状态
		@ViewInject(R.id.tv_myorder_all_transaction_status)
		TextView mTransactionStatusTv;
		//内部 退款售后listview
		@ViewInject(R.id.mlv_returngoods_inner_listView)
		MyListView mReturnAfterScleInnerLv;
		
		
	}	
	
	
	
	
	
	
	
	

}
