package com.example.android_composecamp_codelab.Chapter4.data

import com.example.android_composecamp_codelab.Chapter4.Model.DessertData
import com.example.android_composecamp_codelab.R

object DessertDatasource {
    val dessertList = listOf(
        DessertData(R.drawable.cupcake, 5, 0),
        DessertData(R.drawable.donut, 10, 5),
        DessertData(R.drawable.eclair, 15, 20),
        DessertData(R.drawable.froyo, 30, 50),
        DessertData(R.drawable.gingerbread, 50, 100),
        DessertData(R.drawable.honeycomb, 100, 200),
        DessertData(R.drawable.icecreamsandwich, 500, 500),
        DessertData(R.drawable.jellybean, 1000, 1000),
        DessertData(R.drawable.kitkat, 2000, 2000),
        DessertData(R.drawable.lollipop, 3000, 4000),
        DessertData(R.drawable.marshmallow, 4000, 8000),
        DessertData(R.drawable.nougat, 5000, 16000),
        DessertData(R.drawable.oreo, 6000, 20000)
    )
}