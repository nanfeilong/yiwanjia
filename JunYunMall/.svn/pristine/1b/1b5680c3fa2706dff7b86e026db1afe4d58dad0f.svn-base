package cn.junyun.mall.adapter.homeadapter;
/**
 * 精品推荐adapter
 */
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.model.RecommendEntity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RecommendAdapter extends ArrayAdapter<RecommendEntity>{
	private int rescourceId;

	public RecommendAdapter(Context context, int textViewResourceId, List<RecommendEntity> objects) {
		super(context,  textViewResourceId, objects);
		rescourceId=textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RecommendEntity recommendEntity=getItem(position);
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.recommend_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder)convertView.getTag();

		}
		viewHolder.mRecommendIv.setImageResource(recommendEntity.getRecommendIv());
		viewHolder.mRecommendTitleTv.setText(recommendEntity.getRecommendTitleTv());
		viewHolder.mRecommentDetailsTv.setText(recommendEntity.getRecommendDetails());
		viewHolder.mRecommendSayGoodNumber.setText(recommendEntity.getRecommendSayGoodNumber());

		return convertView;
	}
	class ViewHolder{
		//精品推荐图片
		@ViewInject(R.id.recommendIv)
		ImageView mRecommendIv;
		//精品推荐标题描述
		@ViewInject(R.id.recommendTitleTv)
		TextView mRecommendTitleTv;
		//精品推荐内容
		@ViewInject(R.id.recommendDetails)
		TextView mRecommentDetailsTv;
		//精品推荐喜欢人数
		@ViewInject(R.id.commend_say_good_number)
		TextView mRecommendSayGoodNumber;
	}
}
