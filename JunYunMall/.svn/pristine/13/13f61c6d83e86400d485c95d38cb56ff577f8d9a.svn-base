package cn.junyun.mall.base;

import org.xutils.BuildConfig;
import org.xutils.x;

import cn.jpush.android.api.JPushInterface;
import android.app.Application;

public class BaseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		x.Ext.init(this);
		x.Ext.setDebug(BuildConfig.DEBUG); // 开启debug会影响性能
		//开启极光推送
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
	}

}
