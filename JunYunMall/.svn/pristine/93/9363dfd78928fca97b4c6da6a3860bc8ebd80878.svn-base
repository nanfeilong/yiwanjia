package cn.junyun.mall.adapter.homeadapter;

import java.util.List;

import org.w3c.dom.Text;
import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.adapter.homeadapter.PanicAdapter.ViewHolder;
import cn.junyun.mall.model.BrandStreetEntity;
import cn.junyun.mall.model.GoodShopEntity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodShopAdapter extends ArrayAdapter<GoodShopEntity>{
	private int rescourceId;

	public GoodShopAdapter(Context context, 
			int textViewResourceId, List<GoodShopEntity> objects) {
		super(context, textViewResourceId, objects);

		rescourceId=textViewResourceId;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		GoodShopEntity goodShopEntity=getItem(position);
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.good_shop_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag(); // 重新获取ViewHolder
		}
		viewHolder.goodShopLogo.setImageResource(goodShopEntity.getGoodShopLogn());
		viewHolder.shopName.setText("傻大胖的猪");
		viewHolder.goodShopVipIv.setImageResource(goodShopEntity.getGoodShopVip());
		viewHolder.goodShopLeft.setImageResource(goodShopEntity.getGoodShopLeftIv());
		viewHolder.goodShopRightItem.setImageResource(goodShopEntity.getGoodShopRightIv1());
		viewHolder.goodShopRightItem2.setImageResource(goodShopEntity.getGoodShopRightIv2());
		return convertView;
	}


	class ViewHolder{
		//店铺logo
		@ViewInject(R.id.good_shop_logo)
		private ImageView goodShopLogo;
		//店铺名称
		@ViewInject(R.id.shop_name)
		private TextView shopName;
		//vip等级
		@ViewInject(R.id.goodShopVipIv)
		private ImageView goodShopVipIv;
		//左图
		@ViewInject(R.id.goodShopView1)
		private ImageView goodShopLeft;
		//右图1
		@ViewInject(R.id.good_shop_right_item1)
		private ImageView goodShopRightItem;
		//右图2
		@ViewInject(R.id.good_shop_right_item2)
		private ImageView goodShopRightItem2;
	}



}
