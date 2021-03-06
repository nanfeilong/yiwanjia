package cn.junyun.mall.adapter.myorderadapter;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;






import cn.junyun.mall.R;
import cn.junyun.mall.model.AddressEntity;
import cn.junyun.mall.model.MakeSureOrderEntity;
import cn.junyun.mall.view.MyListView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

/**
 * 地址选择适配器
 */
public class AddressSeleteAdapter extends BaseAdapter {

	ArrayList<AddressEntity> mAddressEntities;
	Context context;
	LayoutInflater mInflater;
	private ImageOptions options;

	public ViewHolder holder;

	public AddressSeleteAdapter(
			ArrayList<AddressEntity> mAddressEntities,
			Context context) {
		this.mAddressEntities = mAddressEntities;
		this.context = context;
		mInflater = LayoutInflater.from(context);

		options = new ImageOptions.Builder()
				.setLoadingDrawableId(R.drawable.ic_launcher)
				.setImageScaleType(ScaleType.FIT_XY).setUseMemCache(true)
				.build();

	}

	@Override
	public int getCount() {
		return mAddressEntities == null ? 0 : mAddressEntities.size();
	}

	@Override
	public Object getItem(int position) {
		return mAddressEntities == null || (position + 1) > getCount() ? null
				: mAddressEntities.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_city_items, null);
			holder = new ViewHolder();
			x.view().inject(holder, convertView);
			
			// 动画集合
			AnimationSet set1 = new AnimationSet(false);
//			// 缩放动画
			ScaleAnimation scale = new ScaleAnimation(0f, 1, 0f, 1,
					Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
					0f);
			scale.setDuration(1000);// 动画时间
			scale.setFillAfter(true);// 保持动画状态
			//平移动画
			TranslateAnimation translateAnimation = new TranslateAnimation(parent.getWidth(), 0, 0, 0);
			translateAnimation.setDuration(1000);
			
			
			// 渐变动画
			AlphaAnimation alpha = new AlphaAnimation(0f, 1);
			alpha.setDuration(1000);// 动画时间
			alpha.setFillAfter(true);// 保持动画状态
			set1.addAnimation(alpha);
			set1.addAnimation(scale);
			set1.addAnimation(translateAnimation);
			
			holder.set1 = set1;
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		AddressEntity bean = mAddressEntities.get(position);

		holder.mCityNameTv.setText(bean.getCityName());// 实体城市名
		convertView.startAnimation(holder.set1);

		return convertView;
	}

	class ViewHolder {
		@ViewInject(R.id.city_name_tv)
		TextView mCityNameTv;
		@ViewInject(R.id.iv_arr)
		ImageView mArrIv;
		
		AnimationSet set1;

	}
}