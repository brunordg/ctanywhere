package br.com.codeteam.ctanywhere.context

import android.app.Application
import br.com.codeteam.ctanywhere.log.Log
import br.ctanywhere.BuildConfig

abstract class ApplicationContext : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.init(BuildConfig.DEBUG)
    }
}
