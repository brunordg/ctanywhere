package br.com.codeteam.ctanywhere.commons

import android.content.Context
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun getContext(): Context {
        return applicationContext
    }

    fun label(): String {
        return resources.getString(packageManager.getActivityInfo(componentName, 0).labelRes)
    }
}
