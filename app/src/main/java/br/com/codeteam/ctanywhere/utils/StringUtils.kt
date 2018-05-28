package br.com.codeteam.ctanywhere.utils

/**
 * Classe para facilitar o uso de operações com String
 * Created by bruno on 15/03/17.
 */
object StringUtils {
    /**
     * Valida se a String está branca ou nula
     */
    fun isBlankOrNull(value: String?): Boolean {
        return null == value || "" == value.trim()
    }

    fun onlyNumber(value: String): String {
        return value.replace("\\D+".toRegex(), "")
    }
}
