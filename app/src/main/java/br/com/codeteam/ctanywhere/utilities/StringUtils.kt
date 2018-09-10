package br.com.codeteam.ctanywhere.utilities

/**
 * Classe para facilitar o uso de operações com String
 * Created by bruno on 15/03/17.
 */
object StringUtils {
    /**
     * Valida se a String está branca ou nula
     */
    fun isBlankOrNull(value: String?): Boolean {
        return value.isNullOrBlank()
    }

    /**
     * Valida se a lista é branca ou nula
     */
    fun isNullOrEmpty(list: List<Any>?): Boolean {
        return list == null || list.isEmpty()
    }

    fun onlyNumber(value: String): String {
        return value.replace("\\D+".toRegex(), "")
    }
}
