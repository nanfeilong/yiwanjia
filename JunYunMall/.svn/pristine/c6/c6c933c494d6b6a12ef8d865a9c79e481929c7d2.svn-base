package cn.junyun.mall.adapter.categoryadapter;

import java.util.List;

import org.xutils.x;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.model.CategoryRightEntity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 分类右侧Gridview侧适配器
 * 
 * @author Administrator
 * 
 */

public class CategoryRightAdapter extends BaseAdapter {

	private Context context;
	private List<CategoryRightEntity> list;
	private LayoutInflater mInflater;
	private ImageOptions options;
	public ViewHolder holder;
	private int mPostion;

	public CategoryRightAdapter(Context context, List<CategoryRightEntity> list) {
		this.context = context;
		this.list = list;
		this.mInflater = LayoutInflater.from(context);
		options = new ImageOptions.Builder()
				.setLoadingDrawableId(R.drawable.ic_launcher)
				.setLoadingDrawableId(R.drawable.ic_launcher)
				.setUseMemCache(true).setCircular(true).build();
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
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
					R.layout.adapter_goods_classsification_right_items, null);
			holder = new ViewHolder();
			x.view().inject(holder, convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		CategoryRightEntity bean = list.get(position);
		holder.tv_name.setText(bean.getName());
		// x.image().bind(holder.iv_image, bean.getImgUrl(), options);
		// //显示网络图片的方法

		/**
		 * 测试数据
		 */

		switch (mPostion % 4) {
		case 0:
			holder.iv_image.setImageResource(R.drawable.diaodaibeixing);
			break;
		case 1:
			holder.iv_image.setImageResource(R.drawable.tixue);
			break;
		case 2:
			holder.iv_image.setImageResource(R.drawable.ic_launcher);
			break;
		case 3:
			test(position);
			break;

		default:
			
			break;
		}

		return convertView;
	}

	/**
	 * c测试数据
	 * 
	 * @author Administrator
	 * 
	 */
	void test(int position) {

		if (position % 2 == 0) {
			holder.iv_image.setImageResource(R.drawable.diaodaibeixing);
		} else if (position % 2 == 1) {
			holder.iv_image.setImageResource(R.drawable.tixue);
		} else {
			holder.iv_image.setImageResource(R.drawable.ic_launcher);
		}

	}

	class ViewHolder {
		@ViewInject(R.id.category_right_tv)
		private TextView tv_name;
		@ViewInject(R.id.category_right_img)
		private ImageView iv_image;
	}

	// 测试位置变化
	public void setPosition(int pos) {
		mPostion = pos;
		notifyDataSetChanged();
	}

}
