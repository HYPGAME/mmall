package com.mmall.test;


import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void testDouble(){
        //丢失精度容易产生问题
        System.out.println(0.05 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(123.3/100);
    }

    @Test
    public void testBigDecimal1(){
        BigDecimal bd1 = new BigDecimal(0.05);
        BigDecimal bd2 = new BigDecimal(0.01);
        System.out.println(bd1.add(bd2));
    }

    @Test
    public void testBigDecimal2(){
        //商业计算中一定要用BigDecimal的String构造器
        //封装一个转换格式的工具类，方便转换数据库中double类型的值
        BigDecimal bd1 = new BigDecimal("0.05");
        BigDecimal bd2 = new BigDecimal("0.01");
        System.out.println(bd1.add(bd2));
    }

}
