package com.example.learnproject.designmode;

/**
 * @author: brian
 * @date: 2020/8/1 14:40
 * @description:
 */
public class SingletonHungry {
    //单例模式 饿汉
    private static SingletonHungry instance = new SingletonHungry();
    private String name = "";

    private void SingletonHungry() {

    }

    public static SingletonHungry getInstance() {
        return instance;
    }

    public void init() {
        name =SingletonHungry.class.getSimpleName();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
