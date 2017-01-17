package cn.junyun.mall.activity.member;
/**
 * 修改密码界面
 */
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.base.BaseActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
@ContentView(value=R.layout.activity_change_password)
public class ChangePasswordActivity extends BaseActivity {
	//就密码
	@ViewInject(value=R.id.ed_old)
	private EditText mOldPassWordEt;
	//新密码
	@ViewInject(value=R.id.ed_new_password)
	private EditText mNewPassWordEt;
	//确认新密码
	@ViewInject(value=R.id.ed_re_new_password)
	private EditText mNewRePassWordEt;
	//确认button
	@ViewInject(value=R.id.bt_re_yes)
	private Button mChangePasswordYesBt;
	@ViewInject(value = R.id.btnHeaderBack)
	private Button mBackBt;
	@ViewInject (value=R.id.back_tv)
	private TextView mBackTv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBackTv.setText(getResources().getString(R.string.str_change_password));
		mBackBt.setVisibility(View.VISIBLE);
		mBackBt.setBackgroundResource(R.drawable.back);
	}


}
