package br.com.codeteam.ctanywhere.commons

import android.content.Context
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun getContext(): Context {
        return applicationContext
    }

    override fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type) {
        SnackCustom(this).build(id, type)
    }

    override fun showSnackBar(message: String, type: SnackCustom.Type) {
        SnackCustom(this).build(message, type)
    }

    fun label(): String {
        return resources.getString(packageManager.getActivityInfo(componentName, 0).labelRes)
    }
}
