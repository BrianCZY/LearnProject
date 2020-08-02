package com.example.learnproject.designmode.singleton;

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description:
 */
public enum SingletonEnum {
    INSTANCE;
    //单例模式 内部类
    String name2 = "";

    public void init() {
        name2 = SingletonEnum.class.getSimpleName();
    }


    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

}
