package cn.junyun.mall.activity.product.fragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.RenderPriority;
import android.widget.LinearLayout;
import cn.junyun.mall.R;
import cn.junyun.mall.base.BaseFragment;

/**
 * \
 * 商品详情
 *
 */
@ContentView(R.layout.fragment_goos_detail_layout)
public class GoodsDetailFragment extends BaseFragment {
	
	@ViewInject(R.id.web_view)
	private WebView mWebView;
	@ViewInject(R.id.spaceView)
	private View mspaceView;// 空View
	
 @Override
protected void loadData() {
//		//设置webView
		initWebSetting(mWebView,getActivity());
		mWebView.loadUrl("http://www.baidu.com");
	
}
 
 

	/**
	 * 初始化浏览器设置
	 */
	private  void initWebSetting(final WebView mWebview, final Context context){
		final WebSettings settings = mWebview.getSettings();
		if (Build.VERSION.SDK_INT >= 19) {
			settings.setLoadsImagesAutomatically(true);// 支持自动加载图片
		} else {
			settings.setLoadsImagesAutomatically(false);
		}
		settings.setUseWideViewPort(true);// 将图片调整到适合webview的大小
		settings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
		settings.setJavaScriptEnabled(true);// 支持js
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		settings.setRenderPriority(RenderPriority.HIGH);
		settings.setCacheMode(WebSettings.LOAD_DEFAULT);
		// 开启 DOM storage API 功能
		settings.setDomStorageEnabled(true);
		// 开启 database storage API 功能
		settings.setDatabaseEnabled(true);
		String cacheDirPath = context.getFilesDir().getAbsolutePath() + "cache";
		// 设置数据库缓存路径
		settings.setDatabasePath(cacheDirPath);
		// 设置 Application Caches 缓存目录
		settings.setAppCachePath(cacheDirPath);
		// 开启 Application Caches 功能
		settings.setAppCacheEnabled(true);
		
		mWebview.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				super.onProgressChanged(view, newProgress);
			}

		});
		
		mWebview.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
			}
			@Override
			public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
				// TODO Auto-generated method stub
				super.onReceivedSslError(view, handler, error);
				handler.proceed();
			}

		});
	}
	
	
	


}
