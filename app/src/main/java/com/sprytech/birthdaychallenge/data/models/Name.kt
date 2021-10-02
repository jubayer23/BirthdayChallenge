package com.android.birthdaychallenge.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Name(

    var first: String?,

    var last: String?,

    var title: String?
): Parcelable