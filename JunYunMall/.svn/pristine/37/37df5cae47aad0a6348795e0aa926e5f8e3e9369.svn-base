package cn.junyun.mall.adapter.homeadapter;
/**
 * 豆豆换后adapter
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
import android.widget.ImageView;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.model.ArrivalEntity;
import cn.junyun.mall.model.DouDouHuanGouEntity;

public class DouDouHuanGouAdapter extends ArrayAdapter<DouDouHuanGouEntity>{
	private int rescourecId;
	public DouDouHuanGouAdapter(Context context,int textViewResourceId, List<DouDouHuanGouEntity> objects) {
		super(context, textViewResourceId, objects);
		rescourecId=textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		DouDouHuanGouEntity douDouHuanGouEntity=getItem(position);
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.dou_dou_xiangqing_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder,convertView);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder)convertView.getTag();
		}
		viewHolder.mDouDouHuanGouIv.setImageResource(douDouHuanGouEntity.getDouDouHuanGouIv());
		viewHolder.mDouDouHuanGouName.setText(douDouHuanGouEntity.getDouDouHuanGouName());
		viewHolder.mDouDouHuanGouXuDou.setText(douDouHuanGouEntity.getDouDouHuanGouXu());
		viewHolder.mDouDouHuanGouYuanJia.setText(douDouHuanGouEntity.getDouDouYuanJia());
		viewHolder.mDouDouHuanGouYuanJia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		viewHolder.mDouDouHuanGouYiJing.setText(douDouHuanGouEntity.getDouDouHuanGouRenShu());
		return convertView;
	}


	class ViewHolder{
		//图片
		@ViewInject(R.id.doudouhuangouiv)
		private ImageView mDouDouHuanGouIv;
		//name
		@ViewInject(R.id.douDouHuanGouTv1)
		private TextView mDouDouHuanGouName;
		//所需豆豆数量
		@ViewInject(R.id.douDouHuanGouTv2)
		private TextView mDouDouHuanGouXuDou;
		//原价
		@ViewInject(R.id.douDouHuanGouTv3)
		private TextView mDouDouHuanGouYuanJia;
		//已经换购的人数
		@ViewInject(R.id.douDouHuanGouTv4)
		private TextView mDouDouHuanGouYiJing;
	}
}
