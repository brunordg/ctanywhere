package br.com.codeteam.ctanywhere.log

import timber.log.Timber

object Log {

    fun init(debug: Boolean) {
        if (debug) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * Encapsula o Timber error
     * @param e
     * @param message
     * @param args
     */
    fun e(e: Throwable? = null, message: String, vararg args: Any) = if (e != null) {
        Timber.e(e, message, *args)
    } else {
        Timber.e(message, *args)
    }

    /**
     * Encapsula o Timber Debug
     * @param message
     * @param args
     */
    fun d(message: String, vararg args: Any) = Timber.d(message, *args)

    /**
     * Encapsula o Timber Info
     * @param message
     * @param args
     */
    fun i(message: String, vararg args: Any) = Timber.i(message, *args)

    /**
     * Encapsula o Timber WTF
     * @param message
     * @param args
     */
    fun wtf(message: String, vararg args: Any) = Timber.wtf(message, *args)
}
