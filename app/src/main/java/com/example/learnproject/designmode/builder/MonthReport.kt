package com.example.learnproject.designmode.builder

import android.util.Log

/**
 * @author: brian
 * @date: 2020/8/2 16:05
 * @description: 月报
 */

class MonthReport : Report() {
    //具体的报告类型
    val TAG = MonthReport::class.java.simpleName

    override fun initTile() {
        mTile = "$TAG"
    }

}