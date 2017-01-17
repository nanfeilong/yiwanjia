package cn.junyun.mall.adapter.myorderadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.junyun.mall.R;
import cn.junyun.mall.model.MyOrderAllInnerEntity;
/**
 * 退款/售后 内部listview适配器
 * @author Administrator
 * @date 2016年8月30日
 */

public class RrturnGoodsInnerAdapter extends BaseAdapter {
	
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities;
	private Context mcontext;
	private LayoutInflater mInflater;




	public RrturnGoodsInnerAdapter(ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities,Context context) {
		this.myOrderAllInnerEntities = myOrderAllInnerEntities;
		this.mcontext = context;
		this.mInflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//return myOrderAllInnerEntities == null ? 0 : myOrderAllInnerEntities.size();
		return myOrderAllInnerEntities.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return myOrderAllInnerEntities.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		MyListener myListener = null;
		MyOrderAllInnerEntity myOrderAllInnerEntity =  myOrderAllInnerEntities.get(position);
		if (convertView == null) {
			viewHolder = new ViewHolder();
			myListener = new MyListener(position);
			convertView = mInflater.inflate(R.layout.adapter_return_aftersale_inner_items, null);
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		ImageOptions imageOptions = new ImageOptions.Builder()
		.setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
		// 图片大小
		// .setRadius(DensityUtil.dip2px(5))//ImageView圆角半径
		.setCrop(true)
		// 如果ImageView的大小不是定义为wrap_content, 不要crop.
		.setImageScaleType(ImageView.ScaleType.CENTER_CROP)
		.setLoadingDrawableId(R.drawable.ic_launcher)// 加载中默认显示图片
		.setFailureDrawableId(R.drawable.ic_launcher)// 加载失败后默认显示图片
		.build();

		x.image().bind(viewHolder.mGoodsPhotoIv,myOrderAllInnerEntity.getGoodsPhotoUrl(), imageOptions);// 商品图片
		viewHolder.mGoodsDescribeTv.setText(myOrderAllInnerEntity.getGoodsDescribe());// 商品描述
		viewHolder.mGoodscolorClassificationTv.setText("颜色分类："+ myOrderAllInnerEntity.getGoodsColor() + "，尺码：");// 商品颜色分类
		viewHolder.mGoodsSizeTv.setText(myOrderAllInnerEntity.getGoodsSize());// 商品尺码
		viewHolder.mGoodsUnitPriceTv.setText("￥"+ myOrderAllInnerEntity.getGoodsUnitPrice());// 商品单价
		viewHolder.mTransactionAmountTv.setText("交易金额：￥"+myOrderAllInnerEntity.getTransactionAmount());//交易金额
		viewHolder.mGoodsAllPriceTv.setText("退款金额：￥"+ myOrderAllInnerEntity.getGoodsAllPrice());// 退款金额
		myListener = new MyListener(position);
		viewHolder.mFindByFaceBt.setOnClickListener(myListener);//找相似添加监听
		viewHolder.mGoodsDetailsRl.setTag(position);
		viewHolder.mGoodsDetailsRl.setOnClickListener(myListener); // 商品详情
		return convertView;
	}
	
	
	class ViewHolder {
		// 商品图片
		@ViewInject(R.id.iv_myorder_all_goods_photo)
		ImageView mGoodsPhotoIv;
		// 商品描述
		@ViewInject(R.id.tv_myorder_all_goods_describe)
		TextView mGoodsDescribeTv;
		// 商品颜色分类
		@ViewInject(R.id.tv_myorder_all_goodscolor_classification)
		TextView mGoodscolorClassificationTv;
		// 商品尺码
		@ViewInject(R.id.tv_myorder_all_goods_size)
		TextView mGoodsSizeTv;
		// 商品单价
		@ViewInject(R.id.tv_myorder_all_goods_unit_price)
		TextView mGoodsUnitPriceTv;
		// 交易金额
		@ViewInject(R.id.tv_transaction_amount)
		TextView mTransactionAmountTv;
		// 商品总价
		@ViewInject(R.id.tv_myorder_all_goods_all_price)
		TextView mGoodsAllPriceTv;
		//找相似
		@ViewInject(R.id.bt_find_by_face)
		Button mFindByFaceBt;
		// 商品详情，就是一大块点击事件
		@ViewInject(R.id.rl_myorder_all_goods_details)
		RelativeLayout mGoodsDetailsRl;
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
			switch (v.getId()) {
			case R.id.bt_find_by_face:  //找相似
				 Toast.makeText(mcontext, "找相似" +myOrderAllInnerEntities.get(mPosition), Toast.LENGTH_SHORT).show();
				break;
			case R.id.rl_myorder_all_goods_details:
				Uri uri = Uri.parse(myOrderAllInnerEntities.get(mPosition).getGoodsPhotoUrl());
				Intent intent_url = new Intent(Intent.ACTION_VIEW, uri);
				mcontext.startActivity(intent_url);
				break;
			default:
				break;
				
				}				
			}

		}
	
	
	
	
	
	
	
	
	
	

	}
	
	
	
	

	


