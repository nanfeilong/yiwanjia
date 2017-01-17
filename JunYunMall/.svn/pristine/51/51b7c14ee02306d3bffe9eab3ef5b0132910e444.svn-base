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
 * 修改密码
 * @author fxr
 *
 */
@ContentView(value = R.layout.activity_retrieve)
public class RetrieveActivity extends BaseActivity {
	//电话号码
@ViewInject(value=R.id.ed_re_tel)
private EditText mReTelEt;
//发送验证码按钮
@ViewInject(value=R.id.bt_re_yanzhengma)
private Button mReYanBt;
//验证码
@ViewInject(value=R.id.ed_yanzhengma)
private EditText mReYanEd;
//新密码
@ViewInject(value=R.id.ed_re_password)
private EditText mRePasswordEt;
//确认button
@ViewInject(value=R.id.bt_re_yes)
private Button mReYesBt;
@ViewInject(value = R.id.btnHeaderBack)
private Button mBackBt;
@ViewInject (value=R.id.back_tv)
private TextView mBackTv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBackTv.setText(getResources().getString(R.string.str_re));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
	}


}
