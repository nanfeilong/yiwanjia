package cn.junyun.mall.adapter.homeadapter;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.model.DouDouMallEntity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//doudou商城
public class DouDouAdapter extends ArrayAdapter<DouDouMallEntity>{
	private int rescourceId;
	public DouDouAdapter(Context context, int textViewResourceId,
			List<DouDouMallEntity> objects) {
		super(context, textViewResourceId, objects);
		rescourceId=textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		DouDouMallEntity douDouMallEntity=getItem(position);
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.doudou_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder,convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder)convertView.getTag();
		}
		viewHolder.mDouDoutu.setImageResource(douDouMallEntity.getDouDouMallIv());
		viewHolder.mDouDouMallXu.setText("2000");
		viewHolder.mDouDouMallYuanJia.setText("原价为￥250");
		viewHolder.mDouDouMallYuanJia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		viewHolder.mDouDouMallName.setText("360儿童手表");

		return convertView;
	}
	class ViewHolder{
		//图片
		@ViewInject(R.id.wanJiaDouItemIv1)
		private ImageView mDouDoutu;
		//现在需要的豆豆数量
		@ViewInject(R.id.wanJiaDouItemTv1)
		private TextView mDouDouMallXu;
		//原价
		@ViewInject(R.id.wanJiaDouItemTv2)
		private TextView mDouDouMallYuanJia;
		//商品名称
		@ViewInject(R.id.wanJiaDouItemTv3)
		private TextView mDouDouMallName;

	}
}
