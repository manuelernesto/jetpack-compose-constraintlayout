package io.github.manuelernesto.composeandconstraintlayout

import androidx.annotation.DrawableRes

data class Product(
        val title: String,
        val price: String,
        val description: String,
        val size: String,
        @DrawableRes val img: Int
)

val _product =
        Product(
                "Office Code",
                "\$234",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since. When an unknown printer took a galley.",
                "12 cm",
                R.drawable.office_code)