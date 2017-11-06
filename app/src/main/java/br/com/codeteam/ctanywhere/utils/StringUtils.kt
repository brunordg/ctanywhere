package br.com.codeteam.ctanywhere.utils

object StringUtils {

    fun isBlankOrNull(value: String?): Boolean {
        return null == value || "" == value.trim()
    }
}
