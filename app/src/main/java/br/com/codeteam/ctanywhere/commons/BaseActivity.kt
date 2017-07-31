package br.com.codeteam.ctanywhere.commons

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar

abstract class BaseActivity : AppCompatActivity() {

    fun label(): String {
        return resources.getString(packageManager.getActivityInfo(componentName, 0).labelRes)
    }
}
