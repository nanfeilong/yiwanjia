package cn.junyun.mall.activity.member;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cn.junyun.mall.R;
import cn.junyun.mall.base.BaseActivity;
/**
 * 
 * @author fxr
 * 登录
 */
@ContentView(value = R.layout.activity_login)
public class LoginActivity extends BaseActivity{
	//账号
	@ViewInject (value = R.id.ed_login_user)
	private EditText mUserEt;
	//密码
	@ViewInject(value = R.id.ed_login_pasword)
	private EditText mPassWordEt;
	//登录按钮
	@ViewInject(value = R.id.login)
	private Button mLoginBt;
	//注册
	@ViewInject (value = R.id.bt_register)
	private Button mRegisterBt;
	//找回密码
	@ViewInject(value = R.id.bt_lose)
	private Button mLoseBt;
	@ViewInject(value = R.id.btnHeaderBack)
	private Button mBackBt;
	@ViewInject (value=R.id.back_tv)
	private TextView mBackTv;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		mBackTv.setText(getResources().getString(R.string.str_login));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
	}


}
