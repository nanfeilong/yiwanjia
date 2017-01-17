package cn.junyun.mall.adapter.myorderadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.adapter.myorderadapter.MyOrderAllInnerAdapter.ViewHolder;
import cn.junyun.mall.model.MyFootPrintEntity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyFootPrintAdapter extends BaseAdapter {

	private ArrayList<MyFootPrintEntity> myFootPrintEntities;
	private Context mcontext;
	private LayoutInflater mInflater;


	public MyFootPrintAdapter(Context context,ArrayList<MyFootPrintEntity> myFootPrintEntities) {
		super();
		this.myFootPrintEntities = myFootPrintEntities;
		this.mcontext = context;
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return myFootPrintEntities == null? 0 : myFootPrintEntities.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return myFootPrintEntities.get(position);
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
		ViewHolder viewHolder = null;
		MyListener myListener = null;
		MyFootPrintEntity myFootPrintEntity =  myFootPrintEntities.get(position);
		if(viewHolder == null) {
			viewHolder = new ViewHolder();
			myListener = new MyListener(position);
			convertView = mInflater.inflate(R.layout.adapter_myfoot_print_items, null);
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		/**
		 * 当日期不相同的是则显示，相同的时候则不显示
		 */
		if(myFootPrintEntity.isSameDate()){
			viewHolder.mVisitDateTv.setVisibility(View.GONE);
		}else{
			viewHolder.mVisitDateTv.setVisibility(View.VISIBLE);
			viewHolder.mVisitDateTv.setText(myFootPrintEntity.getVisitDate());//访问日期
		}
		
		x.image().bind(viewHolder.mGoodsPhotoIv,myFootPrintEntity.getGoodsPhotoUrl());// 商品图片
		viewHolder.mGoodsDescribeTv.setText(myFootPrintEntity.getGoodsDescribe());//商品描述
		viewHolder.mNowPriceTv.setText("￥"+myFootPrintEntity.getGoodsNowPrice());//现价
		viewHolder.mBeforePriceTv.setText("￥"+myFootPrintEntity.getGoodsBeforePrice());//原价
		viewHolder.mBeforePriceTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中间加横线
		myListener = new MyListener(position);
		viewHolder.mFootPrintShareIv.setOnClickListener(myListener);//分享添加监听
		viewHolder.mGoodDetailsRl.setTag(position);
		viewHolder.mGoodDetailsRl.setOnClickListener(myListener);//商品详情
		return convertView;
	}

	class ViewHolder {
		//访问日期
		@ViewInject(R.id.tv_myfootprint_visitdate)
		private TextView mVisitDateTv;
		//商品图片
		@ViewInject(R.id.iv_myfootprint_goods_photo)
		private ImageView mGoodsPhotoIv;
		//商品描述
		@ViewInject(R.id.tv_myfootprint_goods_describe)
		private TextView mGoodsDescribeTv;
		//现价
		@ViewInject(R.id.tv_myfootprint_now_price)
		private TextView mNowPriceTv;
		//原价
		@ViewInject(R.id.tv_myfootprint_before_price)
		private TextView mBeforePriceTv;
		//分享
		@ViewInject(R.id.iv_myfootprint_share)
		private ImageView mFootPrintShareIv;
		//商品详情
		@ViewInject(R.id.rl_myfootprint_goods_details)
		private RelativeLayout mGoodDetailsRl;
	}







	/**
	 * item中控件的点击事件
	 * 
	 * @author Administrator
	 * @date 2016年8月15日
	 */
	private class MyListener implements OnClickListener {
		int mPosition;

		public MyListener(int inPosition) {
			mPosition = inPosition;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_myfootprint_share:
				Toast.makeText(mcontext, "分享" +myFootPrintEntities.get(mPosition), Toast.LENGTH_SHORT).show();
				break;
			case R.id.rl_myfootprint_goods_details:
				Toast.makeText(mcontext, "商品详情" +myFootPrintEntities.get(mPosition), Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}

		}

	}







}
