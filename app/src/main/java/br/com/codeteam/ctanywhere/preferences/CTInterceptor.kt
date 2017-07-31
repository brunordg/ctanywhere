package br.com.codeteam.ctanywhere.preferences

import com.orhanobut.hawk.LogInterceptor
import timber.log.Timber

class CTInterceptor : LogInterceptor {

    override fun onLog(message: String?) {
        if (message != null) {
            Timber.d(message)
        }
    }
}