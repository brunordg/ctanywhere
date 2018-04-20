package br.com.codeteam.ctanywhere.commons

import android.support.annotation.StringRes
import android.widget.ImageView
import android.widget.TextView
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

interface BaseView {
    fun showSnackBar(message: String, type: SnackCustom.Type)
    fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type)
    fun transparentStatusBar()
    fun TextView.setFont(fontPath : String)
    fun ImageView.imageBackground(drawable: Int)
}