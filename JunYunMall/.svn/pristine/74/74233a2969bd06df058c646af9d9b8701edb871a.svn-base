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
 * 注册
 * @author fxr
 *
 */
@ContentView(value=R.layout.activity_register)
public class RegisterActivity extends BaseActivity {
	//电话号码
	@ViewInject(value=R.id.ed_tel)
	private EditText mTelEd;
	//验证码密码
	@ViewInject(value=R.id.bt_yanzhengma)
	private Button mYanBt;
	//验证码文字
	@ViewInject(value=R.id.ed_yanzhengma)
	private EditText mYanEd;
	//密码
	@ViewInject(value=R.id.ed_password)
	private EditText mPasswoedEd;
	//确认密码
	@ViewInject(value=R.id.ed_affirm)
	private EditText mAffirm;
	//推荐人
	@ViewInject(value=R.id.ed_referrer)
	private EditText mReferrer;
	//注册按钮
	@ViewInject(value=R.id.bt_register)
	private Button mRegisterBt;
	//以后账号，跳转登录界面	
	@ViewInject(value=R.id.tv_register_back)
	private Button mRegisterBackBt;
	@ViewInject(value = R.id.btnHeaderBack)
	private Button mBackBt;
	@ViewInject (value=R.id.back_tv)
	private TextView mBackTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBackTv.setText(getResources().getString(R.string.str_register));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
	}


}
