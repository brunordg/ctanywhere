package br.com.codeteam.ctanywhere.preferences

import br.com.codeteam.ctanywhere.log.Log
import com.orhanobut.hawk.LogInterceptor

class CTInterceptor : LogInterceptor {

    override fun onLog(message: String?) {
        if (message != null) {
            Log.d(message)
        }
    }
}