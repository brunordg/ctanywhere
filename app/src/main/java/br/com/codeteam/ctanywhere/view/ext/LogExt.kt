package br.com.codeteam.ctanywhere.view.ext

import android.util.Log
import timber.log.Timber

/**
 * Created by Bruno Rodrigues e Rodrigues on 17/05/2018.
 */

fun Any.LogVerbose(message: String) = Log.v(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.LogDebug(message: String) = Log.d(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.LogError(message: String) = Log.e(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.LogInfo(message: String) = Log.i(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.LogWarn(message: String) = Log.w(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23), message)

fun Any.TimberVerbose(message: String) = Timber.tag(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23)).v(message)

fun Any.TimberDebug(message: String) = Timber.tag(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23)).d(message)

fun Any.TimberError(message: String) = Timber.tag(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23)).e(message)

fun Any.TimberInfo(message: String) = Timber.tag(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23)).i(message)

fun Any.TimberWarn(message: String) = Timber.tag(if (this::class.java.simpleName.length <= 23) this::class.java.simpleName else this::class.java.simpleName.substring(23)).w(message)
