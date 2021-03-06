package cn.junyun.mall.activity.order;

import java.util.ArrayList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import android.widget.ListView;
import cn.junyun.mall.R;
import cn.junyun.mall.adapter.myorderadapter.MyOrderAllAdapter;
import cn.junyun.mall.base.BaseFragment;
import cn.junyun.mall.model.MyOrderAllEntity;
import cn.junyun.mall.model.MyOrderAllInnerEntity;

@ContentView(R.layout.fragment_myorder_all_layout)
public class MyOrderAllFragment extends BaseFragment {
	/**
	 * 我的订单-->全部
	 */

	@ViewInject(R.id.lv_myorder_all)
	private ListView myOrderAllLv; //外部ListView
	private MyOrderAllAdapter myOrderAllAdapter; //外部adapter
	private ArrayList<MyOrderAllEntity> myOrderAllEntities = new ArrayList<MyOrderAllEntity>(); //外部集合
	
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities = new ArrayList<MyOrderAllInnerEntity>(); //内部集合1
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities1 = new ArrayList<MyOrderAllInnerEntity>(); //内部list
	private ArrayList<MyOrderAllInnerEntity> myOrderAllInnerEntities2= new ArrayList<MyOrderAllInnerEntity>(); //内部list
	
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
		for (int i = 0; i < 4; i++) {
			myOrderAllInnerEntities.add(new MyOrderAllInnerEntity(
					imgurl[0], 
					"2016春夏季性感女鞋时尚韩国高跟凉鞋粗跟一字带白搭露趾矮跟女鞋1",
					"黑色", 37+"码", 160.0, 0 , 160.04));
		}
		for (int i = 0; i < 4; i++) {
			myOrderAllInnerEntities1.add(new MyOrderAllInnerEntity(
					imgurl[0], 
					"2016春夏季性感女鞋时尚韩国高跟凉鞋粗跟一字带白搭露趾矮跟女鞋1",
					"黑色", 37+"码", 160.0, 0 , 160.04));
		}
		for (int i = 0; i < 4; i++) {
			myOrderAllInnerEntities2.add(new MyOrderAllInnerEntity(
					imgurl[0], 
					"2016春夏季性感女鞋时尚韩国高跟凉鞋粗跟一字带白搭露趾矮跟女鞋1",
					"黑色", 37+"码", 160.0, 0 , 160.04));
		}
				
				
		myOrderAllEntities.add(new MyOrderAllEntity("莱薇儿精品女鞋1", "交易成功", myOrderAllInnerEntities));
		myOrderAllEntities.add(new MyOrderAllEntity("莱薇儿精品女鞋2", "交易成功", myOrderAllInnerEntities1));
		myOrderAllEntities.add(new MyOrderAllEntity("莱薇儿精品女鞋3", "交易成功", myOrderAllInnerEntities2));
	}
	/**
	 * 初始化adapter
	 */
	@Override
	protected void loadData() {

		initAdapter();

	}
	
	
	
	private void initAdapter(){
		
		if(myOrderAllAdapter == null){
			myOrderAllAdapter =new MyOrderAllAdapter(getActivity(),myOrderAllEntities,MyOrderAllEntity.MYORDER_FLAG_ALL) {

				@Override
				public void outpost(int innerPosition, int outerPosition) {
					if(myOrderAllEntities.get(outerPosition).getMyOrderAllInnerEntities().size()==1){
						myOrderAllEntities.remove(outerPosition);
					}else{
//						myOrderAllInnerEntities.remove(innerPosition);
						myOrderAllEntities.get(outerPosition).getMyOrderAllInnerEntities().remove(innerPosition);
					}
					
					myOrderAllAdapter.notifyDataSetChanged();
				}

			};
			
			myOrderAllLv.setAdapter(myOrderAllAdapter);
		}else{
			myOrderAllAdapter.notifyDataSetChanged();
		}
		
	}




}


