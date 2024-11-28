package com.example.mobile_dev.cookies

data class ShopItem(
    val resId: Int,
    val title: String,
    val price: Int,
    val speed: Double,
    val count: Int = 0,
    val disabled: Boolean = true,
)