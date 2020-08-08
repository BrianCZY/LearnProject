package com.example.learnproject.designmode.builder

import com.example.learnproject.bean.MonthReport
import com.example.learnproject.bean.Report

/**
 * @author: brian
 * @date: 2020/8/2 16:31
 * @description:
 */
class MonthReportBuilder : Builder() {
    val mMonthReport = MonthReport()
    override fun buildTile() {
        mMonthReport.initTile()
    }

    override fun buildDay(day: String) {
        mMonthReport.mDay = day
    }

    override fun buildContent(content: String) {
        mMonthReport.mContent = content
    }

    override fun create(): Report {

        return mMonthReport
    }
}