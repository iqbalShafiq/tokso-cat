package com.membara.toksocat.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Questioner(
    var text: String,
    var yesDestination: Int?,
    var noDestination: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}