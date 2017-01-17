package cn.junyun.mall.adapter.homeadapter;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.adapter.homeadapter.PanicAdapter.ViewHolder;
import cn.junyun.mall.model.BrandStreetEntity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class BrandStreetAdapter extends ArrayAdapter<BrandStreetEntity>{
	private int resourceId;
	public BrandStreetAdapter(Context context,
			int textViewResourceId, List<BrandStreetEntity> objects) {
		super(context, textViewResourceId, objects);
		resourceId=textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BrandStreetEntity brandStreetEntity=getItem(position);
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.brands_street_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag(); // 重新获取ViewHolder
		}
		viewHolder.mBrandStreetIv.setImageResource(brandStreetEntity.getBrandIv());
		return convertView;
	}
	class ViewHolder{
		//ListView中的图片
		@ViewInject(R.id.brands_street_listview_iv)
		ImageView mBrandStreetIv;
	}


}
