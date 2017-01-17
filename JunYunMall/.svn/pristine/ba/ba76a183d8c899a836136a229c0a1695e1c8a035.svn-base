package cn.junyun.mall.activity.mycollect;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.adapter.myorderadapter.MyCollectFragmentAdapter;
import cn.junyun.mall.base.BaseActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 我的商城----我的收藏
 * @author NanFeiLong
 * @date 2016年8月23日
 */
@ContentView(R.layout.activity_my_collect)
public class MyCollectActivity extends BaseActivity {
	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt; //我的订单--->返回箭头
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;//我的订单--->顶部“我的订单”标题

    // ViewPager适配器
    private MyCollectFragmentAdapter myCollectFragmentAdapter = null;
    private int tabWidth;
    private DisplayMetrics dm = new DisplayMetrics();
	//ViewPager
	@ViewInject(R.id.vp_mycollect)
	private ViewPager mViewPagerVp;
    //下面的提示图片条
    @ViewInject(R.id.img_tabLine)
    private ImageView img_tabLineIv;
    // 宝贝
    @ViewInject(R.id.tv_collect_mybady)
    private TextView mCollectBadyTv;
    // 店铺
    @ViewInject(R.id.tv_collect_myshop)
    private TextView mCollectShopTv;

	@Override
	protected void fillView() {
		// TODO Auto-generated method stub
		super.fillView();
		mBackTv.setText(getResources().getString(R.string.str_tv_mymall_mycollect));//设置成我的成就标题
		mBackBt.setVisibility(View.VISIBLE);//返回箭头可见
		mBackBt.setBackgroundResource(R.drawable.back);//设置返回箭头图片
		mCollectBadyTv.setTextColor(getResources().getColor(R.color.color_e20d11));//设置默认选中宝贝的字体颜色
		bindPageData();
	}

	
	@Override
	protected void loadData() {
		// TODO Auto-generated method stub
		super.loadData();
		 getWindowManager().getDefaultDisplay().getMetrics(dm);
	        tabWidth = dm.widthPixels / 2;
	        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tab_line);
	        // /Bitmap b = Bitmap.createBitmap(bitmap, 0, 0, tabWidth, 8);
	        // 设置tab的宽度和高度
	        Bitmap bitmapWidehigh = Bitmap.createScaledBitmap(bitmap, tabWidth, 8, true);
	        img_tabLineIv.setImageBitmap(bitmapWidehigh);
	}
	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		super.setListener();
		mViewPagerVp.setOnPageChangeListener(new PageListener());
	}
	
	/**
     * 绑定我的券页面及数据
     */
    private void bindPageData() {
    	myCollectFragmentAdapter = new MyCollectFragmentAdapter(getSupportFragmentManager());
    	mViewPagerVp.setAdapter(myCollectFragmentAdapter);
    }

	/*
	 * 返回"箭头"点击方法
	 * @param view
	 * @date 2016年8月3日
	 */

	@Event(value={R.id.btnHeaderBack,R.id.back_tv},type=View.OnClickListener.class)
	private void mBackBt(View view) {
		finish();
	}
	/**
	 * 宝贝
	 * @date 2016年8月23日
	 */
	 @Event(R.id.tv_collect_mybady)
	 private void mCollectBadyTv(View view) {
		 resetTab();
		 mCollectBadyTv.setTextColor(getResources().getColor(R.color.color_e20d11));
		 mViewPagerVp.setCurrentItem(0);
	 }
	 /**
	  * 店铺
	  * @date 2016年8月23日
	  */
	 @Event(R.id.tv_collect_myshop)
	 private void mCollectShopTv(View view) {
		 resetTab();
		 mCollectShopTv.setTextColor(getResources().getColor(R.color.color_e20d11));
		 mViewPagerVp.setCurrentItem(1);
	 }
	 
	
	/**
     * viewPager滑动监听
     */
	class PageListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			 // new一个矩阵
            Matrix matrix = new Matrix();
            // 设置激活条的最终位置
            switch (arg0) {
                case 0:
                    // 使用set直接设置到那个位置
                    matrix.setTranslate(0, 0);
                    break;
                case 1:
                    matrix.setTranslate(tabWidth, 0);
                    break;
            }
            // 在滑动的过程中，计算出激活条应该要滑动的距离
            float t = (tabWidth) * arg1;
            // 使用post追加数值
            matrix.postTranslate(t, 0);
            img_tabLineIv.setImageMatrix(matrix);
		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			 switch (position) {
             case 0: {
                 resetTab();
                 mCollectBadyTv.setTextColor(getResources().getColor(R.color.color_e20d11));
                 mViewPagerVp.setCurrentItem(0);
             }
             break;
             case 1: {
                 resetTab();
                 mCollectShopTv.setTextColor(getResources().getColor(R.color.color_e20d11));
                 mViewPagerVp.setCurrentItem(1);
             }
             break;
             default:
                 break;
         }
		}
		
	}
	
	
	/*
     * 文字全部重置为默认状态
     */
    private void resetTab() {
    	mCollectBadyTv.setTextColor(getResources().getColor(R.color.color_969696));
    	mCollectShopTv.setTextColor(getResources().getColor(R.color.color_969696));
    }

}
