package cn.junyun.mall.adapter.homeadapter;
/**
 * 主页的adapter
 */
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.junyun.mall.R;
import cn.junyun.mall.model.HomeListEntity;

public class HomeAdapter extends ArrayAdapter<HomeListEntity>{
	private int resourceId;
	private Context context;
	public HomeAdapter(Context context,  int textViewResourceId,
			List<HomeListEntity> objects) {
		super(context,	textViewResourceId, objects);
		this.context = context;
		resourceId=textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HomeListEntity homeListItem=getItem(position);//获得当前homeList的实例
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(getContext()).inflate(R.layout.home_list_item, null);
			viewHolder=new ViewHolder();
			x.view().inject(viewHolder, convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag(); // 重新获取ViewHolder
		}
		viewHolder.mHomeListIvOne.setImageResource(homeListItem.getHomeListOne());
		setImnage1Listener(viewHolder.mHomeListIvOne);
		viewHolder.mHomeList.setImageResource(homeListItem.getHomeList());
		viewHolder.mHomeListTv.setText(homeListItem.getHomeListText());
		viewHolder.mHomeListIvTwo.setImageResource(homeListItem.getHomeListTwo());
		viewHolder.mHomeListIvThree.setImageResource(homeListItem.getHomeListThree());
		viewHolder.mHomeListIvFour.setImageResource(homeListItem.getHomeListFour());
		viewHolder.mHomeListIvFive.setImageResource(homeListItem.getHomeListFive());
		viewHolder.mHomeListIvSix.setImageResource(homeListItem.getHomeListSix());
		return convertView;

	}
	
	private void setImnage1Listener(ImageView imageView){
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "123", 1).show();
				
			}
		});
		
	}
	

	class ViewHolder{
		@ViewInject(R.id.home_list_iv_one)
		ImageView mHomeListIvOne;//第一张图

		@ViewInject(R.id.home_list)
		ImageView mHomeList;//小图标

		@ViewInject(R.id.home_list_tv)
		TextView mHomeListTv;//文字

		@ViewInject(R.id.home_list_iv_two)
		ImageView mHomeListIvTwo;//第二张图

		@ViewInject(R.id.home_list_iv_three)
		ImageView mHomeListIvThree;//第三张图

		@ViewInject(R.id.home_list_iv_four)
		ImageView mHomeListIvFour;//第四张图

		@ViewInject(R.id.home_list_iv_five)
		ImageView mHomeListIvFive;//第五张图

		@ViewInject(R.id.home_list_iv_sixs)
		ImageView mHomeListIvSix;//第六张图

	}

}
