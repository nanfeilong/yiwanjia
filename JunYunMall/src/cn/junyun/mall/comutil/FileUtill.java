package cn.junyun.mall.comutil;

import java.io.File;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

/***
 *用来保存和读取文件的工具类
 */          

public class FileUtill {
    public static String API_NAME = "";
 public static void writeByteArrayToSD(String path, byte[] content,boolean create){  
        
        FileOutputStream fos = null;
        try {
           File file = new File(path);  
           //SD卡是否存在
           if(!isCanUseSD()){
                return;
           }
           //文件是否存在
           if(!file.exists()){
               if(create){
                   File parent = file.getParentFile();
                   if(!parent.exists()){
                       parent.mkdirs();
                       file.createNewFile();
                   }
               }else{
                   return;
               }
           }
           fos = new FileOutputStream(path);  
           fos.write(content);  
           
       } catch (Exception e) {
           e.printStackTrace();
       }finally{
           if(fos!=null){
               try {
                   fos.close();
               } catch (Exception e) {
               }
           }
       }
  }

    /**
     * 描述：SD卡是否能用.
     *
     * @return true 可用,false不可用
     */
    public static boolean isCanUseSD() { 
        try { 
            return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return false; 
    }
    
    public static Bitmap readerByteArrayToSD(){
      //  String filePath = Environment.getExternalStorageDirectory() + "/"+HttpUtil.API_NAME+"temp.jpg";
        String filePath = Environment.getExternalStorageDirectory() + "/"+""+"temp.jpg";
        File mfile = new File(filePath);
        if (mfile.exists()) {// 若该文件存在
            Bitmap bm = BitmapFactory.decodeFile(filePath);
            return bm;
        }
        return null;
    }
    
    
    public static double getFileSize(){
        return 0;
    }
}
