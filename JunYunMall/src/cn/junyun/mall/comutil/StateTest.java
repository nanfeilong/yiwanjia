package cn.junyun.mall.comutil;




import cn.junyun.mall.constant.Constant;

import cn.junyun.mall.constant.Constant;


import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class StateTest {

	/**
	 * 判断网络连接是否可用
	 */
	public static boolean isNetworkAvailable(Context context){
		ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(cm == null){
			Toast.makeText(context,Constant.NETWORK_IS_NOT_TO_FORCE, 1).show();
		}else {
			//如果仅仅是用来判断网络连接
			//则可以使用 cm.getActiveNetworkInfo().isAvailable();  
			NetworkInfo[] info=cm.getAllNetworkInfo();
			if(info != null){
				for(int i=0;i<info.length;i++){
					if(info[i].getState() == NetworkInfo.State.CONNECTED){
						Toast.makeText(context, Constant.NETWORK_IS_OK, 1).show();
						return true;
					}
				}
			}
		}
		return true;

	}


	/**
	 * 判断是wifi还是3g网络,用户的体现性在这里了，wifi就可以建议下载或者在线播放。
	 */
	public static boolean isWifi(Context context) {   
		ConnectivityManager cm = (ConnectivityManager) context   
				.getSystemService(Context.CONNECTIVITY_SERVICE);   
		NetworkInfo networkINfo = cm.getActiveNetworkInfo();   
		if (networkINfo != null   
				&& networkINfo.getType() == ConnectivityManager.TYPE_WIFI) {   
			Toast.makeText(context, "是wifi", 1).show();
			return true;   
		}   
		Toast.makeText(context, "不是wifi", 1).show();
		return false;   
	}


	/***
	 * 判断WIFI是否打开
	 */
	public static boolean isWifiEnabled(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context   
				.getSystemService(Context.CONNECTIVITY_SERVICE);   
		if (connectivity != null) {   
			NetworkInfo[] info = connectivity.getAllNetworkInfo();   
			if (info != null) {   
				for (int i = 0; i < info.length; i++) {   
					if (info[i].getTypeName().equals("WIFI") && info[i].isConnected()) {

						Toast.makeText(context, Constant.WIFI_IS_OK, 1).show();
						return true;   
					}   
				}   
			}   
		}     Toast.makeText(context,  Constant.WIFI_IS_NO, 1).show();
		return false;   
	}   

	/**
	 * 判断是否是3G网络
	 */
	public static boolean is3rd(Context context) {   
		ConnectivityManager cm = (ConnectivityManager) context   
				.getSystemService(Context.CONNECTIVITY_SERVICE);   
		NetworkInfo networkINfo = cm.getActiveNetworkInfo();   
		if (networkINfo != null   
				&& networkINfo.getType() == ConnectivityManager.TYPE_MOBILE) {   
			Toast.makeText(context, "是3G", 1).show();
			return true;   
		}   
		Toast.makeText(context, "不是3G", 1).show();
		return false;   
	}  


	/**
	 * 判断GPS是否打开
	 */
	public static boolean isGpsEnabled(Context context) {   
		LocationManager locationManager   
		= (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);  
		// 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）  
		boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);  
		// 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）  
		//   boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);  
		if (gps) { 
			Toast.makeText(context,Constant.GPS_IS_OK, 1).show();
			return true;  
		}  
		Toast.makeText(context, Constant.GPS_IS_NO, 1).show();
		return false;    
	} 




}
