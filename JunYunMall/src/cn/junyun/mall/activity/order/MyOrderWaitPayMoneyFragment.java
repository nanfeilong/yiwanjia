package cn.junyun.mall.activity.order;

import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.adapter.myorderadapter.MyOrderAllAdapter;
import cn.junyun.mall.base.BaseFragment;
import cn.junyun.mall.model.MyOrderAllEntity;
import cn.junyun.mall.model.MyOrderAllInnerEntity;

@ContentView(R.layout.fragment_myorder_wait_paymoney_layout)
public class MyOrderWaitPayMoneyFragment extends BaseFragment {

	/**
	 * 我的订单-->待付款
	 */
	@ViewInject(R.id.lv_myorder_wait_paymoney)
	private ListView MyOrderWaitPayMoneyLv; //待付款ListView
	private MyOrderAllAdapter myOrderAllAdapter;
	private ArrayList<MyOrderAllEntity> orderWaitPayMoneyEntities = new ArrayList<MyOrderAllEntity>();//外部list

	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities = new ArrayList<MyOrderAllInnerEntity>(); //内部listview
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities1 = new ArrayList<MyOrderAllInnerEntity>(); //内部listview
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities2 = new ArrayList<MyOrderAllInnerEntity>(); //内部listview

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
		// TODO Auto-generated method stub
		super.fillView();

	
			for (int j = 0; j < 2; j++) {
				myOrderAllInnerEntities.add(new MyOrderAllInnerEntity(
						imgurl[j%imgurl.length], 
						"2016春夏季性感女鞋时尚韩国高跟凉鞋粗跟一字带白搭露趾矮跟女鞋",
						"黑色", 37+j%5+"码", 160.0, j , 160.04));
			}
			for (int j = 0; j < 2; j++) {
				myOrderAllInnerEntities1.add(new MyOrderAllInnerEntity(
						imgurl[j%imgurl.length], 
						"2016春夏季性感女鞋时尚韩国高跟凉鞋粗跟一字带白搭露趾矮跟女鞋",
						"黑色", 37+j%5+"码", 160.0, j , 160.04));
			}
			for (int j = 0; j < 2; j++) {
				myOrderAllInnerEntities2.add(new MyOrderAllInnerEntity(
						imgurl[j%imgurl.length], 
						"2016春夏季性感女鞋时尚韩国高跟凉鞋粗跟一字带白搭露趾矮跟女鞋",
						"黑色", 37+j%5+"码", 160.0, j , 160.04));
			}
			orderWaitPayMoneyEntities.add(new MyOrderAllEntity("莱薇儿精品女鞋", "等待付款", myOrderAllInnerEntities));
			orderWaitPayMoneyEntities.add(new MyOrderAllEntity("莱薇儿精品女鞋", "等待付款", myOrderAllInnerEntities1));
			orderWaitPayMoneyEntities.add(new MyOrderAllEntity("莱薇儿精品女鞋", "等待付款", myOrderAllInnerEntities2));
			

	}

	/*
	 *初始化adapter
	 */
	@Override
	protected void loadData() {
		// TODO Auto-generated method stub
		super.loadData();
		initAdapter();

	
	}

	private void initAdapter() {
		// TODO Auto-generated method stub
		if(myOrderAllAdapter == null){
			myOrderAllAdapter = new MyOrderAllAdapter(
					getActivity(), 
					orderWaitPayMoneyEntities, 
					MyOrderAllEntity.MYORDER_FLAG_WAIT_PAY_MONEY) {
				
				@Override
				public void outpost(int innerPosition, int outerPosition) {
					// TODO Auto-generated method stub
					if(orderWaitPayMoneyEntities.get(outerPosition).getMyOrderAllInnerEntities().size()==1){
						orderWaitPayMoneyEntities.remove(outerPosition);
					}else{
//						myOrderAllInnerEntities.remove(innerPosition);
						orderWaitPayMoneyEntities.get(outerPosition).getMyOrderAllInnerEntities().remove(innerPosition);
					}
					myOrderAllAdapter.notifyDataSetChanged();
				}
			};
			MyOrderWaitPayMoneyLv.setAdapter(myOrderAllAdapter);
		}else {
			myOrderAllAdapter.notifyDataSetChanged();
		}
	}





}
