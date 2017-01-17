package cn.junyun.mall.adapter.myorderadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.model.MakeSureOrderEntity;
import cn.junyun.mall.model.MakeSureOrderInnerEntity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

/**
 * 
 * 确认订单列表适配器
 *
 */
public class MakeSureOrderInnerAdapter extends BaseAdapter {

	ArrayList<MakeSureOrderInnerEntity> makeSureOrderInnerEntities;
	Context context;
	LayoutInflater mInflater;
	private ImageOptions options;

	public ViewHolder holder;

	public MakeSureOrderInnerAdapter(
			ArrayList<MakeSureOrderInnerEntity> makeSureOrderInnerEntities,
			Context context) {
		this.makeSureOrderInnerEntities = makeSureOrderInnerEntities;
		this.context = context;
		mInflater = LayoutInflater.from(context);

		options = new ImageOptions.Builder()
				.setLoadingDrawableId(R.drawable.ic_launcher)
				.setImageScaleType(ScaleType.FIT_XY).setUseMemCache(true)
				.build();

	}

	@Override
	public int getCount() {
		return makeSureOrderInnerEntities == null ? 0 : makeSureOrderInnerEntities.size();
	}

	@Override
	public Object getItem(int position) {
		return makeSureOrderInnerEntities == null || (position + 1) > getCount() ? null
				: makeSureOrderInnerEntities.get(position);
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
					R.layout.adapter_inner_order_items, null);
			holder = new ViewHolder();
			x.view().inject(holder, convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		MakeSureOrderInnerEntity bean = makeSureOrderInnerEntities.get(position);

		holder.mNameTv.setText(bean.getName());// 描述
		holder.mColorTv.setText(bean.getColor());// 颜色
		holder.mSizeTv.setText(bean.getSize());//尺寸
		holder.mPriceTv.setText(bean.getPrice());//价格
		return convertView;
	}

	class ViewHolder {
		@ViewInject(R.id.name_tv)
		TextView mNameTv;
		@ViewInject(R.id.color_tv)
		TextView mColorTv;
		@ViewInject(R.id.size_tv)
		TextView mSizeTv;
		@ViewInject(R.id.price_tv)
		TextView mPriceTv;
	}
}