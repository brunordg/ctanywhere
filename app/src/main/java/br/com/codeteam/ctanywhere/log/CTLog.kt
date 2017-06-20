package br.com.codeteam.ctanywhere.log

import timber.log.Timber

/**
 * Created by Bruno Rodrigues e Rodrigues on 28/04/17.
 */

object CTLog {

    /**
     * Encapsula o Timber error
     * @param e
     * @param message
     * @param args
     */
    fun e(e: Throwable, message: String, vararg args: Any) {
        Timber.e(e, message, *args)
    }

    fun e(message: String, vararg args: Any) {
        Timber.e(message, *args)
    }

    /**
     * Encapsula o Timber Debug
     * @param message
     * @param args
     */
    fun d(message: String, vararg args: Any) {
        Timber.d(message, *args)
    }

    /**
     * Encapsula o Timber Info
     * @param message
     * *
     * @param args
     */
    fun i(message: String, vararg args: Any) {
        Timber.i(message, *args)
    }

    /**
     * Encapsula o Timber WTF
     * @param message
     * @param args
     */
    fun wtf(message: String, vararg args: Any) {
        Timber.wtf(message, *args)
    }
}
