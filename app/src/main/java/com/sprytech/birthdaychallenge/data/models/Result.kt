package com.android.birthdaychallenge.data.models


import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "userlist")
@Parcelize
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @Embedded var dob: Dob?,

    @Embedded var name: Name?
): Parcelable