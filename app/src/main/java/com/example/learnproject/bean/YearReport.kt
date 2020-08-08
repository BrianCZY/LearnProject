package com.example.learnproject.bean

import com.example.learnproject.designmode.builder.ReportLink

/**
 * @author: brian
 * @date: 2020/8/8 17:56
 * @description:
 */

class YearReport {
    val reports: MutableList<ReportLink> = mutableListOf()
    var reportSum: Int = 0
    var company: Company? = null
    var year: String? = null
}