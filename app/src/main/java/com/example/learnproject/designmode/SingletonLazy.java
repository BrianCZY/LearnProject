package com.example.learnproject.designmode;

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description:
 */
public class SingletonLazy {
    //单例模式 懒汉
    private static SingletonLazy instance = null;
    private String name = "";

    private void SingletonHungry() {

    }

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    public void init() {
        name = SingletonLazy.class.getSimpleName();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
