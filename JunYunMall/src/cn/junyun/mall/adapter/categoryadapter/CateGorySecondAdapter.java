package cn.junyun.mall.adapter.categoryadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.adapter.categoryadapter.CategoryLeftAdapter.ViewHolder;
import cn.junyun.mall.model.CategoryLeftEntity;
import cn.junyun.mall.view.ScaleImageView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

//继承自 RecyclerView.Adapter 
public class CateGorySecondAdapter extends BaseAdapter {

	ArrayList<CategoryLeftEntity> categoryEntities;
	Context context;
	LayoutInflater mInflater;
	private ImageOptions options;

	public ViewHolder holder;


	public CateGorySecondAdapter(ArrayList<CategoryLeftEntity> categoryEntities,
			Context context) {
		this.categoryEntities = categoryEntities;
		this.context = context;
		mInflater = LayoutInflater.from(context);
		
		options = new ImageOptions.Builder()
		.setLoadingDrawableId(R.drawable.ic_launcher)
		.setImageScaleType(ScaleType.FIT_XY)
		.setUseMemCache(true).build();
	
	}

	@Override
	public int getCount() {
		return categoryEntities == null ? 0 : categoryEntities.size();
	}

	@Override
	public Object getItem(int position) {
		return categoryEntities == null || (position + 1) > getCount() ? null
				: categoryEntities.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.adapter_second_cagtegory_items, null);
			holder = new ViewHolder();
			x.view().inject(holder, convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		CategoryLeftEntity bean = categoryEntities.get(position);
		
		holder.mCategoryNameTv.setText(bean.getName());
		
		 x.image().bind(holder.mCategoryIv, "http://h.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=c6153ba7d3a20cf446c5f6db43396700/10dfa9ec8a136327fd477e13928fa0ec08fac76c.jpg", options);
				// //显示网络图片的方法
		//测试
		 if(position == 2){
			 holder.mCategoryIv.setImageResource(R.drawable.tixue);
		 }else if(position == 5){
			 holder.mCategoryIv.setImageResource(R.drawable.diaodaibeixing);
		 }


		return convertView;
	}

	class ViewHolder {
		@ViewInject(R.id.name_tv)
		TextView mCategoryNameTv;
		@ViewInject(R.id.category_iv)
		ScaleImageView mCategoryIv;
		
	}
} 