package cn.junyun.mall.activity.product;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.R.drawable;
import cn.junyun.mall.R.id;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.view.ZoomImageView;
import cn.junyun.mall.view.ZoomImageView.OnSingleTouchListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;


@ContentView(R.layout.activity_show_image)
public class ShowImageActivity extends BaseActivity {
	@ViewInject(R.id.zoom_image)
	private ZoomImageView mZommImageView;
	

	
	@Override
	protected void setListener() {
		
		//单击销毁当前页面
		mZommImageView.setOnSingleTouchListener(new OnSingleTouchListener() {
			
			@Override
			public void onSingleTouch() {
				
				finish();
			}
		});
		
	}
	


}
