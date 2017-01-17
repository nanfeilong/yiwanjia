package cn.junyun.mall.adapter.myorderadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.model.MakeSureOrderEntity;
import cn.junyun.mall.view.MyListView;
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
public class MakeSureOrderAdapter extends BaseAdapter {

	ArrayList<MakeSureOrderEntity> makeSureOrderEntities;
	Context context;
	LayoutInflater mInflater;
	private ImageOptions options;

	public ViewHolder holder;

	public MakeSureOrderAdapter(
			ArrayList<MakeSureOrderEntity> makeSureOrderEntities,
			Context context) {
		this.makeSureOrderEntities = makeSureOrderEntities;
		this.context = context;
		mInflater = LayoutInflater.from(context);

		options = new ImageOptions.Builder()
				.setLoadingDrawableId(R.drawable.ic_launcher)
				.setImageScaleType(ScaleType.FIT_XY).setUseMemCache(true)
				.build();

	}

	@Override
	public int getCount() {
		return makeSureOrderEntities == null ? 0 : makeSureOrderEntities.size();
	}

	@Override
	public Object getItem(int position) {
		return makeSureOrderEntities == null || (position + 1) > getCount() ? null
				: makeSureOrderEntities.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_make_sure_order_items, null);
			holder = new ViewHolder();
			x.view().inject(holder, convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		MakeSureOrderEntity bean = makeSureOrderEntities.get(position);

		MakeSureOrderInnerAdapter makeSureOrderInnerAdapter = new MakeSureOrderInnerAdapter(
				bean.getMakeSureOrderInners(), context);

		holder.mOrderInnerLv.setAdapter(makeSureOrderInnerAdapter);
		holder.mShopNameTv.setText(bean.getEntitySHopName());// 实体店名
		holder.mCourierNameTv.setText(bean.getCourierName());// 快递名

		return convertView;
	}

	class ViewHolder {
		@ViewInject(R.id.shop_name_tv)
		TextView mShopNameTv;
		@ViewInject(R.id.courier_name_tv)
		TextView mCourierNameTv;
		@ViewInject(R.id.order_inner_listView)
		MyListView mOrderInnerLv;

	}
}