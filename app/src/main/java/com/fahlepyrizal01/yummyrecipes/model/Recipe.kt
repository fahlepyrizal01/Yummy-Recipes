package com.fahlepyrizal01.yummyrecipes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe (
    var poster: Int,
    var name: String,
    var date: String,
    var yields: String,
    var prepTime: String,
    var totalTime: String,
    var ingredients: ArrayList<String>,
    var directions: ArrayList<String>
) : Parcelable