package br.com.codeteam.ctanywhere.ext

import android.util.Log

/**
 * Created by Bruno Rodrigues e Rodrigues on 17/05/2018.
 */
//--------------—--------------—--------------—--------------—--------------—
// Logger
//--------------—--------------—--------------—--------------—--------------—
fun Any.logVerbose(message: String) = Log.v(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.logDebug(message: String) = Log.d(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.logError(message: String) = Log.e(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.logInfo(message: String) = Log.i(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.logWarn(message: String) = Log.w(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

//--------------—--------------—--------------—--------------—--------------—
// Log Self
//--------------—--------------—--------------—--------------—--------------—
@Suppress("unused")
fun String.logSelfVerbose() = Log.v(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), this)

fun String.logSelfDebug() = Log.d(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), this)

@Suppress("unused")
fun String.logSelfError() = Log.e(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), this)

@Suppress("unused")
fun String.logSelfInfo() = Log.i(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), this)

@Suppress("unused")
fun String.logSelfWarn() = Log.w(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), this)