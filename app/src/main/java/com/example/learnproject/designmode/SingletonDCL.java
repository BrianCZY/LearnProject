package com.example.learnproject.designmode;

/**
 * @author: brian
 * @date: 2020/8/1 14:48
 * @description:
 */
public class SingletonDCL {
    //单例模式 Double Check Lock  (DCL)
    //会在某一特定的时候失效，不推荐
    private static SingletonDCL instance = null;
    private String name = "";

    private void singletonDCL() {

    }

    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }

        }
        return instance;
    }

    public void init() {
        name = SingletonDCL.class.getSimpleName();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
