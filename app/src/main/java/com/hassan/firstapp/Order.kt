package com.hassan.firstapp

data class Order(
    val orderId: Int,
    val clientName: String,
    val price: Double,
    val iteName: String,
    val qty: Int)