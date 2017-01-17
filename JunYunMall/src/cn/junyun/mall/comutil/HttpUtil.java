package cn.junyun.mall.comutil;

import java.util.concurrent.TimeoutException;

import org.xutils.x;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.http.RequestParams;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import cn.junyun.mall.BuildConfig;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.constant.Constant;
import cn.junyun.mall.httpinterinface.HttpInterface;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class HttpUtil {

	public static <T> void post(RequestParams params,
			final Handler handler, final Context context,
			final TypeToken<T> typeToken, final HttpInterface<T> httpInterface) {
		// 只包含字符串参数时默认使用BodyParamsEntity，
		// 类似于UrlEncodedFormEntity（"application/x-www-form-urlencoded"）。
		// params.addBodyParameter("name", "value");

		// 加入文件参数后默认使用MultipartEntity（"multipart/form-data"），
		// 如需"multipart/related"，xUtils中提供的MultipartEntity支持设置subType为"related"。
		// 使用params.setBodyEntity(httpEntity)可设置更多类型的HttpEntity（如：
		// MultipartEntity,BodyParamsEntity,FileUploadEntity,InputStreamUploadEntity,StringEntity）。
		// 例如发送json参数：params.setBodyEntity(new StringEntity(jsonStr,charset));
		
		
		x.http().post(params, new CommonCallback<String>() {

			@Override
			public void onCancelled(CancelledException arg0) {
				
				((BaseActivity) context).dismissProgressBar();
				
				Message message = Message.obtain();
				message.what = Constant.SHOW_RETURN_ERROR_MSG;
				Bundle bundle = new Bundle();
				bundle.putString("msg", Constant.NETWORK_IS_NOT_TO_FORCE);
				message.setData(bundle);
				handler.sendMessage(message);
				
			}

			@Override
			public void onError(Throwable error, boolean arg1) {
				if(error instanceof TimeoutException ){
					
				}
				
				
				
			}

			@Override
			public void onFinished() {
				
			}

			@Override
			public void onSuccess(String json) {
				// 在线程中解析json
				parseJson(json, httpInterface, typeToken);
				
			}
		});
		
		
		
		
		

	}

	/**
	 * 解析json的方法
	 */
	protected static <T> void parseJson(final String json,
			final HttpInterface<T> httpInterface, final TypeToken<T> typeToken) {
		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... arg0) {

				try {
					Gson gson = new Gson();
					T result = gson.fromJson(json, typeToken.getType());

					httpInterface.parseJsonOnWorkThread(json, result);
				} catch (JsonSyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return null;
			}

		}.execute();

	}

}
