package com.example.learnproject;

/**
 * @author: brian
 * @date: 2020/8/8 11:42
 * @description:
 */
public class Testjava {
        String test(Object obj){
            StringBuffer strBuf=new StringBuffer();
            Class cla = obj.getClass();

            /**
             * 对于基本数据类型和String直接返回
             */
            if(cla == Integer.class || cla == Short.class || cla == Byte.class || cla == Long.class
                    || cla == Double.class || cla == Float.class || cla == Boolean.class || cla == String.class
                    || cla == Character.class){
                strBuf.append(obj);
                return strBuf.toString();
            }
            return "";
        }
}
