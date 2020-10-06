package com.hassan.firstapp

import java.io.Serializable

data class Order(
    val orderId: Int,
    val clientName: String,
    val price: Double,
    val iteName: String,
    val qty: Int) : Serializable