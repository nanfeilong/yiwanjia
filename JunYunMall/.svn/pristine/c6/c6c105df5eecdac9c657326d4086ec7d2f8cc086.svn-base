package cn.junyun.mall.activity.myfootprint;

import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.adapter.myorderadapter.MyFootPrintAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.MyFootPrintEntity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

@ContentView(R.layout.activity_my_foot_print)
public class MyFootPrintActivity extends BaseActivity {

	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt; // 我的足迹--->返回箭头
	@ViewInject(R.id.back_tv)
	private TextView mBackTv;// 我的足迹--->顶部“我的订单”标题
	@ViewInject(R.id.lv_my_foot_print)
	private ListView mFootPrintLv; // listview
	private MyFootPrintAdapter myFootPrintAdapter;
	private ArrayList<MyFootPrintEntity> myFootPrintEntities = new ArrayList<MyFootPrintEntity>();// 存放数据的集合

	private String[] imgurl = {
			"http://d01.res.meilishuo.net/pic/_o/eb/f8/037f5e7ff75a495c3e6c26d39371_850_850.c6.jpeg",
			"http://d06.res.meilishuo.net/pic/_o/3b/19/55b9fd8ed1717c79da897179a863_1600_1600.c8.jpeg",
			"http://s9.mogujie.cn/b7/pic/140319/12420w_kqzfiykmozbhsx3wgfjeg5sckzsew_950x1425.jpg",
			"http://d01.res.meilishuo.net/pic/_o/96/ef/753758c3b48564464dfc9373c584_850_850.c1.jpg", };

	@Override
	protected void fillView() {
		// TODO Auto-generated method stub
		super.fillView();
		mBackTv.setText(getResources().getString(
				R.string.str_tv_mymall_myfootprint_allsize));// 设置成我的足迹标题
		mBackBt.setVisibility(View.VISIBLE);// 返回箭头可见
		mBackBt.setBackgroundResource(R.drawable.back);// 设置返回箭头图片
		
		
		addDate();

	}

	private void addDate() {
		myFootPrintEntities.add(new MyFootPrintEntity());
		myFootPrintEntities.add(new MyFootPrintEntity("6月29日", imgurl[1],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		myFootPrintEntities.add(new MyFootPrintEntity("6月30日", imgurl[2],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		myFootPrintEntities.add(new MyFootPrintEntity("6月30日", imgurl[3],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		myFootPrintEntities.add(new MyFootPrintEntity("6月30日", imgurl[1],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		myFootPrintEntities.add(new MyFootPrintEntity("6月31日", imgurl[2],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		myFootPrintEntities.add(new MyFootPrintEntity("6月31日", imgurl[3],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		myFootPrintEntities.add(new MyFootPrintEntity("6月31日", imgurl[1],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		myFootPrintEntities.add(new MyFootPrintEntity("6月31日", imgurl[2],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		myFootPrintEntities.add(new MyFootPrintEntity("6月31日", imgurl[3],
				"言吾2016夏装圆领蝙蝠袖真丝雪纺衫女宽松短袖气质纯色衬衫上衣", +368, +199));
		
		
		/**
		 * 此处用来判断数据是否重复
		 */
		
		
		for (int i = 0; i < myFootPrintEntities.size(); i++) {
			myFootPrintEntities.get(0).setSameDate(false);
			if(i == myFootPrintEntities.size()-1){
				break;
			}

			if (myFootPrintEntities.get(i).getVisitDate().equals(myFootPrintEntities.get(i + 1).getVisitDate())) {
				myFootPrintEntities.get(i+1).setSameDate(true);
			}

		}
		
		
	}

	@Override
	protected void loadData() {
		

		initAdapter();
	}

	private void initAdapter() {

		
		if (myFootPrintAdapter == null) {
			myFootPrintAdapter = new MyFootPrintAdapter(this,
					myFootPrintEntities);
			mFootPrintLv.setAdapter(myFootPrintAdapter);
		} else {
			myFootPrintAdapter.notifyDataSetChanged();
		}
	}

	/**
	 * 返回"箭头"点击方法
	 * 
	 * @param view
	 * @date 2016年8月3日
	 */

	@Event(value = { R.id.btnHeaderBack, R.id.back_tv }, type = View.OnClickListener.class)
	private void mBackBt(View view) {
		finish();
	}
}
