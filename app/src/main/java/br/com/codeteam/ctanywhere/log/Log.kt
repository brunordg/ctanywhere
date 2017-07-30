package br.com.codeteam.ctanywhere.log

import timber.log.Timber

object Log {

    fun init(debug: Boolean) {
        if (debug) {
            Timber.plant(Timber.DebugTree())
        }
    }

    fun tag(tag: String) {
        Timber.tag(tag)
    }

    /**
     * Encapsula o Timber error
     * @param e
     * @param message
     * @param args
     */
    fun e(message: String, vararg args: Any, e: Throwable? = null) = if (e == null) {
        Timber.e(message, *args)
    } else {
        Timber.e(e, message, *args)
    }

    /**
     * Encapsula o Timber Debug
     * @param message
     * @param args
     */
    fun d(message: String, vararg args: Any, e: Throwable? = null) = if (e == null) {
        Timber.d(message, *args)
    } else {
        Timber.d(e, message, *args)
    }

    /**
     * Encapsula o Timber Info
     * @param e
     * @param message
     * @param args
     */
    fun i(message: String, vararg args: Any, e: Throwable? = null) = if (e == null) {
        Timber.i(message, *args)
    } else {
        Timber.i(e, message, *args)
    }

    /**
     * Encapsula o Timber WTF
     * @param e
     * @param message
     * @param args
     */
    fun wtf(message: String, vararg args: Any, e: Throwable? = null) = if (e == null) {
        Timber.wtf(message, *args)
    } else {
        Timber.wtf(e, message, *args)
    }
}
