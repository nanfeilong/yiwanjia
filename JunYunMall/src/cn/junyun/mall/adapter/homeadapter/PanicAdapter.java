package cn.junyun.mall.adapter.homeadapter;
/**
 * 疯狂抢购，今日特价adapter、
 * 
 */
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.adapter.homeadapter.HomeAdapter.ViewHolder;
import cn.junyun.mall.model.PanicBuyingListEntity;

public class PanicAdapter extends ArrayAdapter<PanicBuyingListEntity>{
	private int resourceId;
	public PanicAdapter(Context context,  int textViewResourceId,
			List<PanicBuyingListEntity> objects) {
		super(context, textViewResourceId, objects);
		resourceId=textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		PanicBuyingListEntity panicBuyingListBean=getItem(position);
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.panic_layout_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag(); // 重新获取ViewHolder
		}
		viewHolder.mPanicIv1.setImageResource(panicBuyingListBean.getPanicIv1());

		viewHolder.mPanicTv1.setText(panicBuyingListBean.getPanicTv1());
		viewHolder.mPanicTv2.setText(panicBuyingListBean.getPanicTv2());
		viewHolder.mPanicTv3.setText(panicBuyingListBean.getPanicTv3());
		viewHolder.mPanicTv4.setText(panicBuyingListBean.getPanicTv4());
		viewHolder.mPanicTv5.setText(panicBuyingListBean.getPanicTv5());
		viewHolder.mPanicTv5.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		return convertView;
	}

	class ViewHolder{
		//左侧图片
		@ViewInject(R.id.panic_buy_listview_iv1)
		ImageView mPanicIv1;
		//文字描述1
		@ViewInject(R.id.panic_buy_listview_tv1)
		TextView  mPanicTv1;
		//文字描述2
		@ViewInject(R.id.panic_buy_listview_tv2)
		TextView  mPanicTv2;
		//销量
		@ViewInject(R.id.panic_buy_listview_tv3)
		TextView  mPanicTv3;
		//限价
		@ViewInject(R.id.panic_buy_listview_tv4)
		TextView   mPanicTv4;
		//原件
		@ViewInject(R.id.panic_buy_listview_tv5)
		TextView   mPanicTv5;
		//		//购物按钮
		//		@ViewInject(R.id.panic_buy_listview_bt)
		//		Button mPanicBt1;
	}

}
