package cn.junyun.mall.activity.myaccount;
/**
 * 我的商城----我的账户
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Field;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import cn.junyun.mall.R;
import cn.junyun.mall.R.layout;
import cn.junyun.mall.R.menu;
import cn.junyun.mall.activity.home.fragment.MyMallFragment;
import cn.junyun.mall.base.BaseActivity;
import cn.junyun.mall.comutil.FileUtill;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Camera;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.PopupWindow.OnDismissListener;

@ContentView(R.layout.activity_my_account)
public class MyAccountActivity extends BaseActivity {
	//我的账户--->返回箭头
	@ViewInject(R.id.btnHeaderBack)
	private Button mBackBt; 
	//我的账户--->顶部“我的账户”标题
	@ViewInject (R.id.back_tv)
	private TextView mBackTv;
	//我的头像所在布局--点击会弹出popopwindow
	@ViewInject(R.id.rlayout_myaccount_myhead)
	private RelativeLayout mHeadRl; 
	//我的收货地址 --整个布局添加监听事件
	@ViewInject(R.id.rlayout_mycount_receiveraddress)
	private RelativeLayout mReceiverAddressRl; 
	//我的头像
	@ViewInject(R.id.iv_head_myaccount)
	private ImageView mIvHead; 
//	//pop显示参照物
//	@ViewInject(R.id.title)
//	private View mGoneView; 
	
	@ViewInject(R.id.gone_view)
	private View mGoneView; 
	
	
	private PopupWindow mPopupWindow; //popwindow
	private View mpopview;  //弹出框的布局
	private Bitmap photo;  //保存头像的Bitmap对象
	private static final int RESULT_PICK_PHOTO_CAMERA = 1; //退出
	private static int CAMERA_RESULT = 100; //拍照 标识码
	private static int LOAD_IMAGE_RESULT = 200; //相册 标识码

	
	@Override
	protected void fillView() {
		mBackTv.setText(getResources().getString(R.string.str_tv_mymall_myaccount));//设置成我的账户标题
		mBackBt.setVisibility(View.VISIBLE);//返回箭头可见
		mBackBt.setBackgroundResource(R.drawable.back);//设置返回箭头图片
		
		photo = FileUtill.readerByteArrayToSD(); //读取保存的图片
		if (photo != null) {
			mIvHead.setImageBitmap(photo);
		}
		else {
			mIvHead.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
		}
		super.fillView();
	}
	/**
	 * 返回"箭头"点击方法
	 * @param view
	 * @date 2016年8月3日
	 */

	@Event(value={R.id.btnHeaderBack,R.id.back_tv},type=View.OnClickListener.class)
	private void mBackBt(View view) {
		Intent intent = new Intent(this, MyMallFragment.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		intent.putExtra("head", photo);
		setResult(10, intent);
		finish();
	}
	/**
	 * 我的收货地址
	 * @param view
	 * @date 2016年8月24日
	 */
	@Event(R.id.rlayout_mycount_receiveraddress)
	private void mReceiverAddressRl(View view) {
		Intent intent = new Intent(this, AddressManageActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 更换我的头像方法
	 * @param view
	 * @date 2016年8月9日
	 */
	@Event(R.id.rlayout_myaccount_myhead)
	private void mHeadRlChange(View view){
		
		int width = getResources().getDisplayMetrics().widthPixels;
		int height = getResources().getDisplayMetrics().heightPixels;//px
		LayoutInflater inflater = LayoutInflater.from(this);
		mpopview = inflater.inflate(R.layout.activity_choose_picture,null);//加载动画布局
		mPopupWindow = new PopupWindow(mpopview, width, height-dip2px(50)+getStatusBarHeight());//设置布局在屏幕中显示的位置，并且获取焦点
		//设置PopupWindow的显示样式
		//mPopupWindow.setBackgroundDrawable(getResources().getDrawable());
		mPopupWindow.setAnimationStyle(R.style.PopupAnimation);
		//实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0x00000000);
		//设置SelectPicPopupWindow弹出窗体的背景
		mPopupWindow.setBackgroundDrawable(dw);
		backgroundAlpha(this,0.5f);//设置半透明0.0-1.0 
		mPopupWindow.setFocusable(true);
		mPopupWindow.setOutsideTouchable(false);//设置不允许在外点击消失
		//设置当mPopupWindow取消时，界面恢复原来的颜色 不是可透明的
		mPopupWindow.setOnDismissListener(new OnDismissListener() {

			@Override
			public void onDismiss() {
				// TODO Auto-generated method stub
				backgroundAlpha(MyAccountActivity.this, 1f);//不透明
			}
		});

		mPopupWindow.showAsDropDown(mGoneView);//弹出的mPopupWindow左上角正对mGoneView的左下角  偏移量默认为0,0
		Button mTakePhotoBt = (Button) mpopview.findViewById(R.id.button_take_photo);//拍照
		Button mChoicePhotoBt = (Button) mpopview.findViewById(R.id.button_choice_photo);//相册选择
		Button mChoiceCancelBt = (Button) mpopview.findViewById(R.id.button_choice_cancel);//取消
		// 拍照
		mTakePhotoBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mPopupWindow.dismiss();
				//destoryImage();
				File saveDirFile = new File(Environment.getExternalStorageDirectory(), "" + "temp.jpg");
				Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用系统相机拍照
				intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(saveDirFile));
				startActivityForResult(intentCamera, CAMERA_RESULT);
			}
		});

		// 从相册选择
		mChoicePhotoBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				mPopupWindow.dismiss();//取消弹窗
				//content://media/external/images/media 图片地址
				//Intent.ACTION_PICK 从图片中选择一张 并返回选择的图片
				Intent intentPhotoAlbum = new Intent(Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intentPhotoAlbum, LOAD_IMAGE_RESULT);//请求码200 打开相册
			}
		});

		//取消
		mChoiceCancelBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mPopupWindow.dismiss();
			}
		});
		

	}
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//拍照
		if (requestCode == CAMERA_RESULT && resultCode == RESULT_OK) {
			File temp = new File(Environment.getExternalStorageDirectory() + "/" +""+ "temp.jpg");
			startPhotoZoom(Uri.fromFile(temp));
		}
		//相册选择
		if (requestCode == LOAD_IMAGE_RESULT && data != null && data.getData() != null) {
			//Uri selectedImage = data.getData();
			startPhotoZoom(data.getData());
		}
		//取消
		if (requestCode == RESULT_PICK_PHOTO_CAMERA&&data != null && data.getExtras() != null) {
			Bundle extras = data.getExtras();
			Bitmap photo = extras.getParcelable("data");
			mIvHead.setImageBitmap(photo);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			photo.compress(Bitmap.CompressFormat.JPEG, 60, stream);
			byte[] bytes = stream.toByteArray();
			mIvHead.setTag(bytes);
			String filePath = Environment.getExternalStorageDirectory() + "/" + ""+ "temp.jpg";
			FileUtill.writeByteArrayToSD(filePath, bytes, true);}
	}
	
	
	/**
	 * 设置添加屏幕的背景透明度
	 * @param context
	 * @param bgAlpha(透明度 取值返回0-1, 0全透明,1不透明)
	 * @date 2016年8月6日
	 */
	public void backgroundAlpha(Activity context, float bgAlpha) {
		
		WindowManager.LayoutParams lp = context.getWindow().getAttributes();
		lp.alpha = bgAlpha;
		context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		context.getWindow().setAttributes(lp);
	}
	/**
	 * 裁剪图片方法实现
	 */
	@SuppressLint("NewApi")
	public void startPhotoZoom(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1); // outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 200);
		intent.putExtra("outputY", 200);
		intent.putExtra("scale", true);// 黑边
		intent.putExtra("scaleUpIfNeeded", true);// 黑边
		intent.putExtra("return-data", true);
		startActivityForResult(intent, RESULT_PICK_PHOTO_CAMERA);
	}

	/**
	 * 获取状态栏高速的方法
	 * @return 
	 * @date 2016年8月7日
	 */
	private int getStatusBarHeight() {  
		Class<?> c = null;  
		Object obj = null;  
		Field field = null;  
		int x = 0, sbar = 0;  
		try {  
			c = Class.forName("com.android.internal.R$dimen");  
			obj = c.newInstance();  
			field = c.getField("status_bar_height");  
			x = Integer.parseInt(field.get(obj).toString());  
			sbar = getResources().getDimensionPixelSize(x);  
		} catch (Exception e1) {  
			e1.printStackTrace();  
		}  

		return sbar;  
	}  



}
