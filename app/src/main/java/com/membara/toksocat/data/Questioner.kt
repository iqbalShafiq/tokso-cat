package com.membara.toksocat.data

class Questioner(
    private var _text: String,
    private var _answers: MutableList<Answer>
) {
    var text = this._text
    var answers = this._answers
}