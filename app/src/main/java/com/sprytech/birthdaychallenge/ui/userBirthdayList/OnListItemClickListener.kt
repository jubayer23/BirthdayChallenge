package com.sprytech.birthdaychallenge.ui.userBirthdayList

import android.view.View
import com.android.birthdaychallenge.data.models.Result
interface OnListItemClickListener {
    fun onItemClick(position: Int, item: Result?, view: View)
}