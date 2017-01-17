package cn.junyun.mall.comutil;

import java.math.BigDecimal;

/**
 * 
 * @author wangxiaojing 提供精确的加减乘除的运算 和判断大小的运算
 * 
 */

public class CalculateUtil {
    
    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 2;
    
    // 比较v1 v2大小，v1>=v2则true
    public static boolean comare(String v1, String v2) {
        BigDecimal b1;
        try {
            b1 = new BigDecimal(v1);
        }
        catch (NumberFormatException e) {
            b1 = new BigDecimal("0");
        }
        BigDecimal b2;
        try {
            b2 = new BigDecimal(v2);
        }
        catch (NumberFormatException e) {
            b2 = new BigDecimal("0");
        }
        return b1.compareTo(b2) > 0 || b1.compareTo(b2) == 0;
    }
    
    // 比较v1 v2大小，v1>v2则true
    public static boolean comareBig(String v1, String v2) {
        BigDecimal b1;
        try {
            b1 = new BigDecimal(v1);
        }
        catch (NumberFormatException e) {
            b1 = new BigDecimal("0");
        }
        BigDecimal b2;
        try {
            b2 = new BigDecimal(v2);
        }
        catch (NumberFormatException e) {
            b2 = new BigDecimal("0");
        }
        return b1.compareTo(b2) > 0;
    }
    
    /**
     * 提供精确的加法运算。
     * 
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static String add(String v1, String v2) {
        BigDecimal b1;
        try {
            b1 = new BigDecimal(v1);
        }
        catch (NumberFormatException e) {
            b1 = new BigDecimal("0");
        }
        BigDecimal b2;
        try {
            b2 = new BigDecimal(v2);
        }
        catch (NumberFormatException e) {
            b2 = new BigDecimal("0");
        }
        return b1.add(b2).toString();
    }
    
    /**
     * 提供精确的减法运算。
     * 
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static String subtract(String v1, String v2) {
        BigDecimal b1;
        try {
            b1 = new BigDecimal(v1);
        }
        catch (NumberFormatException e) {
            b1 = new BigDecimal("0");
        }
        BigDecimal b2;
        try {
            b2 = new BigDecimal(v2);
        }
        catch (NumberFormatException e) {
            b2 = new BigDecimal("0");
        }
        return b1.subtract(b2).toString();
    }
    
    /**
     * 提供精确的乘法运算。
     * 
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static String multiply(String v1, String v2) {
        BigDecimal b1;
        try {
            b1 = new BigDecimal(v1);
        }
        catch (NumberFormatException e) {
            b1 = new BigDecimal("0");
        }
        BigDecimal b2;
        try {
            b2 = new BigDecimal(v2);
        }
        catch (NumberFormatException e) {
            b2 = new BigDecimal("0");
        }
        return b1.multiply(b2).toString();
    }
    
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后 10 位，以后的数字四舍五入。
     * 
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static String divide(String v1, String v2) {
        return divide(v1, v2, DEF_DIV_SCALE);
    }
    
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由 scale 参数指 定精度，以后的数字四舍五入。
     * 
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static String divide(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1;
        try {
            b1 = new BigDecimal(v1);
        }
        catch (NumberFormatException e) {
            b1 = new BigDecimal("0");
        }
        BigDecimal b2;
        try {
            b2 = new BigDecimal(v2);
        }
        catch (NumberFormatException e) {
            b2 = new BigDecimal("0");
        }
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }
    
    /**
     * 提供精确的小数位四舍五入处理。
     * 
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b;
        try {
            b = new BigDecimal(v);
        }
        catch (NumberFormatException e) {
            b = new BigDecimal("0");
        }
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).toString();
    }
    
}
