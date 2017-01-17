package cn.junyun.mall.adapter.categoryadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.model.CategoryLeftEntity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 分类左侧适配器
 * 
 * @author Administrator
 * 
 */

public class CategoryLeftAdapter extends BaseAdapter {

	ArrayList<CategoryLeftEntity> categoryEntities;
	Context context;
	LayoutInflater mInflater;

	public ViewHolder holder;

	int mPostion;// 点击的位置

	public CategoryLeftAdapter(ArrayList<CategoryLeftEntity> categoryEntities,
			Context context) {
		this.categoryEntities = categoryEntities;
		this.context = context;
		mInflater = LayoutInflater.from(context);
	
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
					R.layout.adapter_goods_classsification_left_items, null);
			holder = new ViewHolder();
			x.view().inject(holder, convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		CategoryLeftEntity bean = categoryEntities.get(position);
		
		holder.mCategoryNameTv.setText(bean.getName());

		holder.mCategoryNameTv.setBackgroundColor(context.getResources()
				.getColor(R.color.white));
		holder.mCategoryNameTv.setTextColor(context.getResources().getColor(
				R.color.color_2b2b2b));
		holder.mSpiltView.setBackgroundColor(context.getResources().getColor(
				R.color.color_d6d7dc));
		
		

		/**
		 * 当点击某item时，改变字体颜色和背景色
		 */
		if (mPostion == position) {
			holder.mCategoryNameTv.setBackgroundColor(context.getResources()
					.getColor(R.color.color_f1f1f1));
			holder.mCategoryNameTv.setTextColor(context.getResources()
					.getColor(R.color.color_e20d11));
			holder.mSpiltView.setBackgroundColor(context.getResources()
					.getColor(R.color.color_e20d11));
		}

		return convertView;
	}

	class ViewHolder {
		@ViewInject(R.id.spilt_view)
		View mSpiltView;
		@ViewInject(R.id.category_name_tv)
		TextView mCategoryNameTv;
		
	}

	// 颜色设置
	public void setColor(int pos) {
		mPostion = pos;
		notifyDataSetChanged();
	}

}
