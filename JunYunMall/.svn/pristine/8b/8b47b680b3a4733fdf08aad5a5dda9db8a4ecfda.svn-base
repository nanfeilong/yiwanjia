package cn.junyun.mall.adapter.homeadapter;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.model.ArrivalEntity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//新品上新
public class ArrivalAdapter extends ArrayAdapter<ArrivalEntity>{
	private int rescourceId;
	public ArrivalAdapter(Context context,
			int textViewResourceId, List<ArrivalEntity> objects) {
		super(context, textViewResourceId, objects);
		rescourceId=textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ArrivalEntity arrivalEntity=getItem(position);
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.arrival_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder,convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder)convertView.getTag();
		}
		viewHolder.arrivalItemIv.setImageResource(arrivalEntity.getArrivalItemIv());
		viewHolder.arrivalTextView.setText("￥999");
		return convertView;
	}

	class ViewHolder{
		//背景图片
		@ViewInject(R.id.arrivalItemIv)
		private ImageView arrivalItemIv;
		//背景文字
		@ViewInject(R.id.arrivalTextView)
		private TextView arrivalTextView;
	}
}
