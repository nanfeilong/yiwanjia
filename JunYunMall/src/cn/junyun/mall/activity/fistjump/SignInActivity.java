package cn.junyun.mall.activity.fistjump;

import java.text.SimpleDateFormat;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.junyun.mall.R;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.view.ImageViewCircle;
/**
 * @author fxr
 * 签到
 */
@ContentView(value = R.layout.activity_sign_in)
public class SignInActivity extends BaseActivity {
	//头像
	@ViewInject(value=R.id.sign_in_head)
	private ImageViewCircle mIcon;
	//昵称
	@ViewInject(value=R.id.tv_sign_in_username)
	private TextView mUsernameTv;
	//vip等级
	//@ViewInject(value=R.id.iv_sign_in_vip_lv)
	//private ImageView mViplvIm;
	//连续签到天数
	@ViewInject(value=R.id.x_day)
	private TextView mDayTv;
	//总计签到天数
	@ViewInject(value=R.id.accumulateDouNo)
	private TextView mAccumulateDouNoTv;
	//日期
	@ViewInject(value=R.id.date)
	private TextView mDateTv;
	//签到按钮
	@ViewInject(value=R.id.sign_in_iv)
	private ImageView mSignInIv;
	//签到按钮上的汉字
	@ViewInject(value=R.id.sign_in_tv)
	private TextView mSignInTv;
	//title的back
	@ViewInject(value = R.id.btnHeaderBack)
	private Button mBackBt;
	//title返回键旁边的文字
	@ViewInject (value=R.id.back_tv)
	private TextView mBackTv;

	@Override
	protected void fillView() {
		//设置title
		mBackTv.setText(getResources().getString(R.string.str_sign_in));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
		//获取当前日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new java.util.Date());
		mDateTv.setText(date);
	}

	@Override
	protected void setListener() {
		//title上的返回箭头
		mBackBt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});

		//title上的返回文字
		mBackTv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();				
			}
		});

		mSignInIv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mSignInIv.setImageDrawable(getResources().getDrawable(R.drawable.sign_in_yes));
				mSignInIv.setClickable(false);
//				if(mSignInIv.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.sign_in_yes).getConstantState())){
//					Toast.makeText(SignInActivity.this, "请勿重复签到", 1).show();
//				}
			}
		});
	}

	@Override
	protected void loadData() {

	}


}
