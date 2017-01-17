package cn.junyun.mall.adapter.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.model.SkuItme;

import com.hhl.library.OnInitSelectedPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HanHailong on 15/10/19.
 */
public class EvlutionAdapter<T> extends BaseAdapter implements
		OnInitSelectedPosition {

	private final Context mContext;
	private final List<T> mDataList;
	TextView mTextView;// 点击的字体
	int mPosition;// 选中的位置

	public EvlutionAdapter(Context context) {
		this.mContext = context;
		mDataList = new ArrayList<T>();
	}

	@Override
	public int getCount() {
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = LayoutInflater.from(mContext).inflate(R.layout.evlution_item,
				null);

		mTextView = (TextView) view.findViewById(R.id.tv_tag);

		if (mPosition == position) {
			mTextView.setBackground(mContext.getResources().getDrawable(R.drawable.evlution_round_rectangle_bg2));
		}

		T t = mDataList.get(position);

		if (t instanceof String) {
			mTextView.setText((String) t);
		}
		return view;
	}

	public void onlyAddAll(List<T> datas) {
		mDataList.clear();
		mDataList.addAll(datas);
		notifyDataSetChanged();
	}

	public void clearAndAddAll(List<T> datas) {
		mDataList.clear();
		onlyAddAll(datas);
	}

	@Override
	public boolean isSelectedPosition(int position) {

		return false;
	}

	/**
	 * 设置被选中的item的字体颜色
	 * 
	 * @param position
	 */
	public void setSelectTvColor(int position) {
		mPosition = position;
		if (mPosition == position) {
			notifyDataSetChanged();
		}

	}

}
