package br.com.codeteam.ctanywhere.commons

import android.content.Context
import android.support.annotation.StringRes
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

interface BaseView {
    fun getContext(): Context
    fun showSnackBar(message: String, type: SnackCustom.Type)
    fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type)
}