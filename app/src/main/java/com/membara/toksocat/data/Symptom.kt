package com.membara.toksocat.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Symptom(
    @PrimaryKey
    var text: String,
    var yesDestination: String? = null,
    var noDestination: String? = null
)