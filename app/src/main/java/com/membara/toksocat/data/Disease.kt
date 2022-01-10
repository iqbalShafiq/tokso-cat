package com.membara.toksocat.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Disease(
    @PrimaryKey
    val text: String
) : Parcelable
