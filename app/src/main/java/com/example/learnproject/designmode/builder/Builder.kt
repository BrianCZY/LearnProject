package com.example.learnproject.designmode.builder

/**
 * @author: brian
 * @date: 2020/8/2 16:26
 * @description:建造者
 */
abstract class Builder {
    //建造者模式 抽象类  亦可不要
    abstract fun buildTile()
    abstract fun buildDay(day: String)
    abstract fun buildContent(content: String)
    abstract fun create(): Report

}