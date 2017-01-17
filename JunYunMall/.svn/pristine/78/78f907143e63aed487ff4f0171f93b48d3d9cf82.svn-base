package cn.junyun.mall.activity.fistjump;

import java.util.ArrayList;

import org.w3c.dom.Text;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.adapter.homeadapter.DouDouAdapter;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.model.DouDouMallEntity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
/**
 * 豆豆mall
 * @author fxr
 *
 */
@ContentView(R.layout.activity_dou_dou_mall)
public class DouDouMallActivity extends BaseActivity {

	//title的back
	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt;

	//title返回键旁边的文字
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;

	//顶部广告条
	@ViewInject(R.id.douDouMallHead)
	private ImageView mDouDouTitleIV;

	//精品活动
	@ViewInject(R.id.doudouJingPinHuoDong)
	private TextView mDouDouJingPinHuoDong;
	//广告位1
	@ViewInject(R.id.doudoumall1)
	private ImageView mDouDouMall1;
	//广告位2
	@ViewInject(R.id.doudoumall2)
	private ImageView mDouDouMall2;
	//广告位3
	@ViewInject(R.id.doudoumall3)
	private ImageView mDouDouMall3;

	//广告位4
	@ViewInject(R.id.doudoumall4)
	private ImageView mDouDouMall4;

	//广告位5
	@ViewInject(R.id.doudoumall5)
	private ImageView mDouDouMall5;
	//豆豆换购tv
	@ViewInject(R.id.doudouHuanGou)
	private TextView mDouDouHuanGou;
	//GridView
	@ViewInject(R.id.douDouGV)
	private GridView mDouDouMallGv;
	//底部button
	@ViewInject(R.id.doudouBottomBt)
	private Button mDouDouTiaoZhuanBt;
	//适配器
	DouDouAdapter  douDouAdapter;
	ArrayList<DouDouMallEntity>douDouMallEntities=new ArrayList<DouDouMallEntity>();
	private ScrollView scrollView;


	@Override
	protected void fillView() {
		//设置title
		mBackTv.setText(getResources().getString(R.string.str_doudou_mall));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
	}

	@Override
	protected void setListener() {
		mBackBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();				
			}
		});
		mDouDouTiaoZhuanBt.setOnClickListener(new  OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent douDouTiaoZhuanIntent=new Intent(DouDouMallActivity.this,DouDouHuanGouActivity.class);
				startActivity(douDouTiaoZhuanIntent);
			}
		});
	}

	@Override
	protected void loadData() {
		mDouDouMallGv.setFocusable(false);
		//配置GridView 的适配器
		init();
		douDouAdapter=new DouDouAdapter(DouDouMallActivity.this, R.layout.doudou_item, douDouMallEntities);
		mDouDouMallGv=(GridView)findViewById(R.id.douDouGV);
		mDouDouMallGv.setAdapter(douDouAdapter);
	}

	//改GridView添加假数据
	private void init() {
		douDouMallEntities.add(new DouDouMallEntity(R.drawable.doudouhuangou, "2000", "原价为￥250", "360儿童手表"));
		douDouMallEntities.add(new DouDouMallEntity(R.drawable.doudouhuangou, "2000", "原价为￥250", "360儿童手表"));
		douDouMallEntities.add(new DouDouMallEntity(R.drawable.doudouhuangou, "2000", "原价为￥250", "360儿童手表"));
		douDouMallEntities.add(new DouDouMallEntity(R.drawable.doudouhuangou, "2000", "原价为￥250", "360儿童手表"));
	}


}
