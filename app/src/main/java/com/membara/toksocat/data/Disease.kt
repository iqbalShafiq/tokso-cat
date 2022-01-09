package com.membara.toksocat.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Disease(
    @PrimaryKey
    val text: String
)
