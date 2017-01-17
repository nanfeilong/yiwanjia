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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.junyun.mall.R;
import cn.junyun.mall.activity.order.ApplyForRefundActivity;
import cn.junyun.mall.model.MyOrderAllEntity;
import cn.junyun.mall.model.MyOrderAllInnerEntity;

public abstract  class MyOrderAllInnerAdapter extends BaseAdapter {

	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities;
	private Context mcontext;
	private LayoutInflater mInflater;
	private int mFlag;
	int outPosition;
	
	public MyOrderAllInnerAdapter(Context context,ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities, int Flag) {
		this.mInflater = LayoutInflater.from(context);
		this.mcontext = context;
		this.myOrderAllInnerEntities = myOrderAllInnerEntities;
		this.mFlag = Flag;
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
		return position;
	}

	@SuppressLint("NewApi") @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		MyListener myListener = null;
		MyOrderAllInnerEntity myOrderAllInnerEntity =  myOrderAllInnerEntities.get(position);
		if (convertView == null) {
			viewHolder = new ViewHolder();
			myListener = new MyListener(position);
			convertView = mInflater.inflate(R.layout.adapter_myorder_all_inner_items, null);
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
		viewHolder.mGoodsAllNumberTv.setText("共"+ myOrderAllInnerEntity.getGoodsAllNumber() + "件商品");// 商品数量
		viewHolder.mGoodsAllPriceTv.setText("合计￥"+ myOrderAllInnerEntity.getGoodsAllPrice());// 商品总价
		
		myListener = new MyListener(position);
		// viewHolder.mDeleteOrderBt.setTag(position);
		if (mFlag == MyOrderAllEntity.MYORDER_FLAG_ALL) { // 全部
			viewHolder.mDeleteOrderBt.setOnClickListener(myListener); // 删除订单监听事件
			viewHolder.mCheckLogisticsBt.setVisibility(View.GONE);// 查看物流
			viewHolder.mCheckLogisticsBt.setOnClickListener(myListener);
			viewHolder.mAddToCommentBt.setOnClickListener(myListener);// 追加评价监听事件
		}
		if (mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_PAY_MONEY) {
			viewHolder.mDeleteOrderBt.setText("取消订单");
			viewHolder.mDeleteOrderBt.setOnClickListener(myListener); // 取消订单监听事件
			viewHolder.mCheckLogisticsBt.setVisibility(View.GONE);// 查看物流
			viewHolder.mAddToCommentBt.setTextColor(mcontext.getResources().getColor(R.color.color_e20d11));
			viewHolder.mAddToCommentBt.setText("付款");
			viewHolder.mAddToCommentBt.setOnClickListener(myListener);// 追加评价监听事件
		}

		if (mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_SEND_GOODS) {
			//设置提醒发货按钮父级右侧
			//RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(dip2px(60), dip2px(20));
			//params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			//params.setMarginEnd(20); 
			//viewHolder.mCheckLogisticsBt.setLayoutParams(params);
			viewHolder.mCheckLogisticsBt.setText("我要退货");
			viewHolder.mCheckLogisticsBt.setOnClickListener(myListener);// 我要退货监听事件
			viewHolder.mDeleteOrderBt.setVisibility(View.INVISIBLE);
			viewHolder.mAddToCommentBt.setText("提醒发货");
			viewHolder.mAddToCommentBt.setOnClickListener(myListener);
		}

		if(mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_RECEIVS_GOODS) {
			viewHolder.mDeleteOrderBt.setText("我要退货");//我要退货
			viewHolder.mDeleteOrderBt.setOnClickListener(myListener);
			viewHolder.mCheckLogisticsBt.setText("查看物流");// 查看物流
			viewHolder.mCheckLogisticsBt.setOnClickListener(myListener);
			viewHolder.mAddToCommentBt.setText("确认收货");
			viewHolder.mAddToCommentBt.setOnClickListener(myListener);// 追加评价监听事件
		}
		if(mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_COMMENT){
			viewHolder.mDeleteOrderBt.setOnClickListener(myListener); // 删除订单监听事件
			viewHolder.mCheckLogisticsBt.setOnClickListener(myListener);//// 查看物流监听事件
			viewHolder.mAddToCommentBt.setTextColor(mcontext.getResources().getColor(R.color.color_e20d11));
			viewHolder.mAddToCommentBt.setText("评价");
			viewHolder.mAddToCommentBt.setOnClickListener(myListener);// 评价监听事件
		}
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
		// 商品总数
		@ViewInject(R.id.tv_myorder_all_goods_allnumber)
		TextView mGoodsAllNumberTv;
		// 商品总价
		@ViewInject(R.id.tv_myorder_all_goods_all_price)
		TextView mGoodsAllPriceTv;
		// 删除订单
		@ViewInject(R.id.bt_myorder_all_delete_order)
		Button mDeleteOrderBt;
		// 追加评价
		@ViewInject(R.id.bt_myorder_all_addto_comment)
		Button mAddToCommentBt;
		// 查看物流
		@ViewInject(R.id.bt_myorder_all_check_logistics)
		Button mCheckLogisticsBt;
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
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.bt_myorder_all_delete_order:
				// Toast.makeText(mcontext, "删除订单" +
				// mOrderAllEntities.get(mPosition), Toast.LENGTH_SHORT).show();
				if (mFlag == MyOrderAllEntity.MYORDER_FLAG_ALL ||
				mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_COMMENT) { // 全部 --删除订单
					showInfo(mPosition);
				}
				if (mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_PAY_MONEY) { //待付款 --取消订单
					showInfo(mPosition);
				}
				if(mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_RECEIVS_GOODS){ //待收货 -- 我要退货
					Toast.makeText(mcontext,"我要退货\n" + myOrderAllInnerEntities.get(mPosition),Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(mcontext, ApplyForRefundActivity.class);
					mcontext.startActivity(intent);
				}
				break;
			case R.id.bt_myorder_all_addto_comment:
				if(mFlag == MyOrderAllEntity.MYORDER_FLAG_ALL){
					Toast.makeText(mcontext,"追加评价\n" + myOrderAllInnerEntities.get(mPosition),Toast.LENGTH_SHORT).show();
				}
				if(mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_PAY_MONEY){
					Toast.makeText(mcontext,"付款\n" + myOrderAllInnerEntities.get(mPosition),Toast.LENGTH_SHORT).show();
				}
				if(mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_RECEIVS_GOODS){
					Toast.makeText(mcontext,"确认收货\n" + myOrderAllInnerEntities.get(mPosition),Toast.LENGTH_SHORT).show();
				}
				if(mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_COMMENT){
					Toast.makeText(mcontext,"评价\n" + myOrderAllInnerEntities.get(mPosition),Toast.LENGTH_SHORT).show();
				}
				if(mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_SEND_GOODS){
					Toast.makeText(mcontext,"提醒发货\n" + myOrderAllInnerEntities.get(mPosition),Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.rl_myorder_all_goods_details:
				Uri uri = Uri.parse(myOrderAllInnerEntities.get(mPosition)
						.getGoodsPhotoUrl());
				Intent intent_url = new Intent(Intent.ACTION_VIEW, uri);
				mcontext.startActivity(intent_url);
				break;
			case R.id.bt_myorder_all_check_logistics:
				if (mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_SEND_GOODS) {
					Toast.makeText(mcontext,"我要退货\n" + myOrderAllInnerEntities.get(mPosition),Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(mcontext, ApplyForRefundActivity.class);
					mcontext.startActivity(intent);
				}
				if(mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_RECEIVS_GOODS ||
						mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_COMMENT){
					Toast.makeText(mcontext,"查看物流\n" + myOrderAllInnerEntities.get(mPosition),Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
			}

		}

	}

	/**
	 * listview删除订单
	 * 
	 * @param position
	 * @date 2016年8月15日
	 */
	public void showInfo(final int innerPosition) {
		if (mFlag == MyOrderAllEntity.MYORDER_FLAG_ALL || mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_COMMENT) {
			new AlertDialog.Builder(mcontext)
			.setTitle("删除订单")
			.setMessage("确定要删除该订单吗？")
			.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog,int which) {
					
//					if(myOrderAllInnerEntities.size() == 0){
//						//刷新外部的Adapter
//						//myOrderAllInnerEntities.remove(position);
//						mOrderAllEntities.remove(outPosition);
//						
//					}
//					myOrderAllInnerEntities.remove(position);
//					notifyDataSetChanged();
					
					post(innerPosition);
					
					
				}
			}).show();
		}

		if (mFlag == MyOrderAllEntity.MYORDER_FLAG_WAIT_PAY_MONEY) {
			new AlertDialog.Builder(mcontext)
			.setTitle("取消订单")
			.setMessage("确定要取消该订单吗？")
			.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog,int which) {
					post(innerPosition);
				}
			}).show();
		}

	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	private int dip2px(float dpValue) {
		final float scale = mcontext.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
	
	
  public  abstract void	post(int innerPosition);


}
