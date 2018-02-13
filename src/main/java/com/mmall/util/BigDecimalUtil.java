package com.mmall.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
    /*
    使用double, float时，一定要转为String再运算。
    除法要考虑除不尽时的运算策略
     */

    private BigDecimalUtil(){

    }

    public static BigDecimal add(double v1, double v2){
        BigDecimal bd1 = new BigDecimal(Double.toString(v1));
        BigDecimal bd2 = new BigDecimal(Double.toString(v2));
        return bd1.add(bd2);
    }

    public static BigDecimal sub(double v1, double v2){
        BigDecimal bd1 = new BigDecimal(Double.toString(v1));
        BigDecimal bd2 = new BigDecimal(Double.toString(v2));
        return bd1.subtract(bd2);
    }

    public static BigDecimal mul(double v1, double v2){
        BigDecimal bd1 = new BigDecimal(Double.toString(v1));
        BigDecimal bd2 = new BigDecimal(Double.toString(v2));
        return bd1.multiply(bd2);
    }

    public static BigDecimal div(double v1, double v2){
        //除法要注意除不尽的情况，要确定保留位数，四舍五入的逻辑等
        BigDecimal bd1 = new BigDecimal(Double.toString(v1));
        BigDecimal bd2 = new BigDecimal(Double.toString(v2));
        return bd1.divide(bd2, 2, BigDecimal.ROUND_HALF_UP); //保留两位小数，使用四舍五入
    }
}
