package com.example.learnproject.designmode.prototype

/**
 * @author: brian
 * @date: 2020/10/14 12:34
 * @description:
 */
class Product : Cloneable {
    var name: String? = null //名称
    var price: String? = null //价格
    var producer: String? = null //生产商

    public override fun clone(): Product {
        return super.clone() as Product
    }
}