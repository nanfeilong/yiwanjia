package cn.junyun.mall.comutil;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import android.util.Base64;


public class DES {
    //初始化向量
    private static byte[] iv={1,2,3,4,5,6,7,8};
    //des加密
    //encryptString为原文
    //encryptkey为秘钥
    public static byte[] encryptDES(String encryptString,String encryptKey){
        try {
            //实例化IvParameterSpec对象，使用指定的初始化向量
            IvParameterSpec zeroIv=new IvParameterSpec(iv);
            //实例化SecreKeySpec类，根据字节数组来构建Secrekey
            SecretKeySpec key=new SecretKeySpec(encryptKey.getBytes(), "DES");
            //创建密码器
            Cipher cipher=Cipher.getInstance("DES/CBC/PKCS5Padding");
            //用秘钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, key,zeroIv);
            //执行加密操作
            byte[] encryptedData=cipher.doFinal(encryptString.getBytes());
            //返回加密后的数据
            return Base64.encode(encryptedData, 0);
        }
        catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
    //DES解密
    //decryptString为密文
    //decryptKey为秘钥
    //返回解密后的原文
    public static String decryptDES(byte[] encryptResult ,String decryptKey)throws Exception{
        //先使用Base64解密
        byte[] byteMi=Base64.decode(encryptResult, Base64.DEFAULT);
        //实例化IvParameterSpec对象，使用指定的初始化向量
        IvParameterSpec zeroIv=new IvParameterSpec(iv);
        //实例化SecretKeySpec根据字节数组构造secrekty
        SecretKeySpec key=new SecretKeySpec(decryptKey.getBytes(), "DES");
        //创建密码器
        Cipher cipher=Cipher.getInstance("DES/CBC/PKCS5Padding");
        //用秘钥初始化的Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, key,zeroIv);
        //获得解密的数据
        byte decryptedData[]=cipher.doFinal(byteMi);
        return new String(decryptedData);
    }
    
}
