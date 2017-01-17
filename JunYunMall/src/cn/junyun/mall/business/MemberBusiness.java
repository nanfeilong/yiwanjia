package cn.junyun.mall.business;



import org.xutils.http.RequestParams;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.junyun.mall.base.BaseBusiness;
import cn.junyun.mall.comutil.HttpUtil;
import cn.junyun.mall.constant.Constant;
import cn.junyun.mall.constant.HttpUrl;
import cn.junyun.mall.httpinterinface.HttpInterface;
import cn.junyun.mall.httpresponse.EntityResponse;
import cn.junyun.mall.model.Member;

import com.google.gson.reflect.TypeToken;

public class MemberBusiness extends BaseBusiness {

	private Handler mHandler;
	private Context mContext;

	// 获取用户信息成功
	public static final int MEMBERINFO_REQUEST_OK = 101;

	public MemberBusiness(Handler handler, Context context) {
		super();
		this.mHandler = handler;
		this.mContext = context;
	}

	/**
	 * Post请求 异步的
	 * 
	 * @param url
	 * @param userkey
	 * @param str
	 * @param sign
	 * @return
	 */

	public void getMemberInfo(final String key, final String phone) {
		/**
		 * 添加参数
		 */
		RequestParams params = new RequestParams(HttpUrl.HOME_URL);
		params.addQueryStringParameter(Constant.HTTP_PARAMETER_KEY, key);
		params.addQueryStringParameter(Constant.HTTP_PARAMETER_PHONE, phone);
		/*
		 * 发送请求
		 */
		TypeToken<EntityResponse<Member>> t = new TypeToken<EntityResponse<Member>>() {
		};

		HttpUtil.post(params, mHandler, mContext, t,
				new HttpInterface<EntityResponse<Member>>() {

					@Override
					public void parseJsonOnWorkThread(String json,
							EntityResponse<Member> result) {

						Message msg = Message.obtain();
						msg.what = MEMBERINFO_REQUEST_OK;
						msg.obj = result.getResult();
						Bundle bundle = new Bundle();
						msg.setData(bundle);

						mHandler.sendMessage(msg);

					}
				});
	}
	
	

}