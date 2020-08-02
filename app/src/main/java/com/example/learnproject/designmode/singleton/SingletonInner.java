package com.example.learnproject.designmode.singleton;

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description:
 */
public class SingletonInner {
    //单例模式 内部类
    private String name = "";

    private void SingletonInner() {

    }

    public static SingletonInner getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static SingletonInner instance = new SingletonInner();
    }

    public void init() {
        name = SingletonInner.class.getSimpleName();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
