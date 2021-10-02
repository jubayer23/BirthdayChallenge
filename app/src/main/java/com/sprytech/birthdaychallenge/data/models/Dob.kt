package com.android.birthdaychallenge.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Dob(

    var age: Int?,

    var date: String?
): Parcelable