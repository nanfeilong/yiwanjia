package cn.junyun.mall.adapter.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.activity.product.ShowImageActivity;
import cn.junyun.mall.model.BabyEvlationEntity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author 宝贝评价Adapter
 * 
 */

public class BabyEvlationAdapter extends BaseAdapter {

	ArrayList<BabyEvlationEntity> mBabyEvlationEntities;
	Context context;
	LayoutInflater mInflater;
	private HorizaViewHolder mHorizaViewHolder;// 绑定HorizaScrollView里面的item的ViewHolder

	/**
	 * 测试数据
	 */
	private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(
			R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
			R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
			R.drawable.l));

	public ViewHolder holder;

	public BabyEvlationAdapter(
			ArrayList<BabyEvlationEntity> babyEvlationEntities, Context context) {
		this.mBabyEvlationEntities = babyEvlationEntities;
		this.context = context;

		mInflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		return mBabyEvlationEntities == null ? 0 : mBabyEvlationEntities.size();
	}

	@Override
	public Object getItem(int position) {
		return mBabyEvlationEntities == null || (position + 1) > getCount() ? null
				: mBabyEvlationEntities.get(position);
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
					R.layout.adapter_baby_evlation_items, null);
			holder = new ViewHolder();
			x.view().inject(holder, convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();

		}

		
		initHorizaView(holder.mGalleryLayout);

		BabyEvlationEntity babyEvlationEntity = mBabyEvlationEntities
				.get(position);
		holder.mEvlationDescripTionTv.setText(babyEvlationEntity
				.getDescription());
		holder.mNameTv.setText(babyEvlationEntity.getName());
		holder.mDateTv.setText(babyEvlationEntity.getDate());
		holder.mColorSizeTv.setText(babyEvlationEntity.getColorAndSize());

		return convertView;
	}
	
	/**
	 * 
	 * @author wang
	 * 初始化HoriScrollerView的方法
	 *
	 */
	private void initHorizaView(LinearLayout mGalleryLayout){
	
		
		OnItemClickListener onItemClickListener = null;

		mGalleryLayout.removeAllViews();
		for (int i = 0; i < mDatas.size(); i++){
			View view = mInflater.inflate(R.layout.adapter_index_gallery_item,
					mGalleryLayout, false);
			
			onItemClickListener = new OnItemClickListener(i);
			view.setOnClickListener(onItemClickListener);
			mHorizaViewHolder = new HorizaViewHolder(view);
			mHorizaViewHolder.img.setImageResource(mDatas.get(i));
			mGalleryLayout.addView(view);
		}
		
		
	}
	
	
	class HorizaViewHolder{
		@ViewInject(R.id.id_index_gallery_item_image)
		ImageView img;
		
		public HorizaViewHolder(View v) {
			x.view().inject(this, v);
		}
		
	}
	
	
	/**
	 * 
	 * @author Wang
	 *添加每个Item的点击事件
	 */
	
	
	 private  class OnItemClickListener implements OnClickListener{
		 
		 
		 int position ;
		 
		 public OnItemClickListener(int position) {
			super();
			this.position = position;
		}




		@Override
		public void onClick(View v) {
			Toast.makeText(context, "点击了某一个图片" +position, 1).show();
			context.startActivity(new Intent(context,ShowImageActivity.class));
		}
		 
	 }
	
	
	
	

	class ViewHolder {
		@ViewInject(R.id.evlation_description_tv)
		TextView mEvlationDescripTionTv;
		@ViewInject(R.id.name_tv)
		TextView mNameTv;
		@ViewInject(R.id.date_tv)
		TextView mDateTv;
		@ViewInject(R.id.color_size_tv)
		TextView mColorSizeTv;
		@ViewInject(R.id.id_gallery)
		LinearLayout mGalleryLayout;
		@ViewInject(R.id.id_horizontalScrollView)
		HorizontalScrollView mHorizontalScrollView;
		
	}

}
