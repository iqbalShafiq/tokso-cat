package com.membara.toksocat

class Answer(
    private var _text: String,
    private var _truePercent: Double,
    private var _falsePercent: Double,
    private var _isSelected: Boolean
) {
    var text = this._text
    var truePercent = this._truePercent
    var falsePercent = this._falsePercent
    var isSelected = this._isSelected
}