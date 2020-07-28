package io.github.manuelernesto.composeandconstraintlayout.ui

import androidx.annotation.DrawableRes

data class Product(
        val title: String,
        val price: String,
        @DrawableRes val bgColor: Int,
        @DrawableRes val img: Int
)