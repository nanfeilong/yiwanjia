package cn.junyun.mall.activity.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.xutils.x;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.adapter.myorderadapter.RrturnGoodsAllAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.MyOrderAllEntity;
import cn.junyun.mall.model.MyOrderAllInnerEntity;

@ContentView(R.layout.activity_return_goods)
public class ReturnGoodsActivity extends BaseActivity {

	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt; //退款/售后--->返回箭头
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;//退款/售后--->顶部标题
	
	@ViewInject(R.id.lv_return_after_sale)
	private ListView mReturnAfterSaleLv;  //listview
	
	private RrturnGoodsAllAdapter rrturnGoodsAllAdapter;
	private ArrayList<MyOrderAllEntity> myOrderAllEntities = new ArrayList<MyOrderAllEntity>(); //外部listview
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities = new ArrayList<MyOrderAllInnerEntity>(); //内部listview
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities1 = new ArrayList<MyOrderAllInnerEntity>(); //内部listview
	
	private String[] imgurl = {
			"http://d01.res.meilishuo.net/pic/_o/eb/f8/037f5e7ff75a495c3e6c26d39371_850_850.c6.jpeg",
			"http://d06.res.meilishuo.net/pic/_o/3b/19/55b9fd8ed1717c79da897179a863_1600_1600.c8.jpeg",
			"http://s9.mogujie.cn/b7/pic/140319/12420w_kqzfiykmozbhsx3wgfjeg5sckzsew_950x1425.jpg",
			"http://d01.res.meilishuo.net/pic/_o/96/ef/753758c3b48564464dfc9373c584_850_850.c1.jpg",
			"http://imgtest-dl.meiliworks.com/pic/_o/79/d6/b9831401630a8fa8167639f064d5_850_850.c1.jpg",
			"http://s6.mogujie.cn/b7/pic/140422/1227kj_kqzeeokkozbg22cugfjeg5sckzsew_850x850.jpg",
			"http://i0.ihaveu.net/image/auction/image/000/073/318/large/d0e5685902fae73e01829745b4c74279.jpg",
			"http://d06.res.meilishuo.net/pic/_o/ea/90/8b92872d8b1889c632b9c00d591b_999_1000.c1.jpg",
			"http://d6.yihaodianimg.com/N04/M07/32/70/CgQDr1Orhl-AbVRLAAIr0DSk3RE31700.jpg",
			"http://s12.mogujie.cn/b7/pic/140323/bb2jw_kqzdo6sbozbfcx2ugfjeg5sckzsew_1300x867.jpg"
	};

	@Override
	protected void fillView() {
		super.fillView();
		mBackTv.setText(getResources().getString(R.string.str_return_goods_aftersale));//设置成 退款/售后
		mBackBt.setVisibility(View.VISIBLE);//返回箭头可见
		mBackBt.setBackgroundResource(R.drawable.back);//设置返回箭头图片
		
		for (int i = 0; i < 4; i++) {
			myOrderAllInnerEntities.add(new MyOrderAllInnerEntity(
					imgurl[0], 
					"2016春夏季性感女鞋时尚韩国高跟凉鞋粗跟一字带白搭露趾矮跟女鞋1",
					"黑色", 37+"码", 160.0, 168.00, 168.00));
		}
		for (int i = 0; i < 4; i++) {
			myOrderAllInnerEntities1.add(new MyOrderAllInnerEntity(
					imgurl[0], 
					"2016春夏季性感女鞋时尚韩国高跟凉鞋粗跟一字带白搭露趾矮跟女鞋1",
					"黑色", 37+"码", 160.0, 168.00, 168.00));
		}
		myOrderAllEntities.add(new MyOrderAllEntity("莱薇儿精品女鞋1", "退款处理中", myOrderAllInnerEntities));
		myOrderAllEntities.add(new MyOrderAllEntity("莱薇儿精品女鞋2", "交易成功", myOrderAllInnerEntities1));
		
		
	}
	
	@Override
	protected void loadData() {
		// TODO Auto-generated method stub
		super.loadData();
		if(rrturnGoodsAllAdapter == null){
			rrturnGoodsAllAdapter = new RrturnGoodsAllAdapter(myOrderAllEntities, this);
			mReturnAfterSaleLv.setAdapter(rrturnGoodsAllAdapter);
		} else {
			rrturnGoodsAllAdapter.notifyDataSetChanged();
		}
		
	}
	
	
	
	/**
	 * 返回"箭头"点击方法
	 * @param view
	 * @date 2016年8月3日
	 */

	@Event(value={R.id.btnHeaderBack,R.id.back_tv},type=View.OnClickListener.class)
	private void mBackBt(View view) {
		finish();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
