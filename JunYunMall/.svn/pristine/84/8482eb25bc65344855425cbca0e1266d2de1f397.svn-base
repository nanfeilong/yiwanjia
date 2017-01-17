package cn.junyun.mall.base;

import android.content.SharedPreferences;
import cn.junyun.mall.constant.Constant;

import com.google.gson.JsonObject;



/**
 * Created by bing on 2015/11/25.
 */
public class BaseBusiness {

	SharedPreferences shareMember;//存储用户信息

	public static boolean checkCode(JsonObject jsonObject)throws Exception {
		if(jsonObject == null){
			return false;
		}
		if(jsonObject.has(Constant.REQUEST_KEY_CODE) && jsonObject.get(Constant.REQUEST_KEY_CODE).getAsString().equals("ok")){
			return true;
		}else{
			if(jsonObject.has(Constant.REQUEST_KEY_MSG)) {
				throw new Exception(jsonObject.get(Constant.REQUEST_KEY_MSG).getAsString());
			}
		}

		return false;
	}

}
