package cn.junyun.mall.adapter.homeadapter;
//热卖商品
import java.util.ArrayList;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.adapter.homeadapter.ArrivalAdapter.ViewHolder;
import cn.junyun.mall.model.BestSellerEntity;

public class BestSellerAdapter extends ArrayAdapter<BestSellerEntity>{
	private int rescourceId;
	public BestSellerAdapter(Context context, 
			int textViewResourceId, List<BestSellerEntity> objects) {
		super(context,  textViewResourceId, objects);
		rescourceId=textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BestSellerEntity bestSellerEntity=getItem(position);
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.best_seller_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder,convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder)convertView.getTag();
		}
		viewHolder.mBestSellIv.setImageResource(bestSellerEntity.getBestSellerIv());
		viewHolder.mBestSellTv1.setText("百搭小白鞋");
		viewHolder.mBestSellTv2.setText("123");
		viewHolder.mBestSellTv4.setText("￥238");
		return convertView;
	}
	class ViewHolder{
		//顶部图片
		@ViewInject(R.id.bestSellIv)
		private ImageView mBestSellIv;
		//文字描述
		@ViewInject(R.id.bestSellTv1)
		private TextView mBestSellTv1;
		//XX已买人数
		@ViewInject(R.id.bestSellTv2)
		private TextView mBestSellTv2;
		//现在价格
		@ViewInject(R.id.bestSellTv4)
		private TextView mBestSellTv4;
	}
}
