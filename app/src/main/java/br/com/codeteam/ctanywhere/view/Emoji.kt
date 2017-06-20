package br.com.codeteam.ctanywhere.view

/**
 * Created by Bruno Rodrigues e Rodrigues on 18/04/17.
 */

object Emoji {

    fun getEmojiByUnicode(unicode: Int): String {
        return String(Character.toChars(unicode))
    }
}
