package br.com.codeteam.ctanywhere.base

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

interface BaseView {
    fun showSnackBar(message: String, type: SnackCustom.Type)

    fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type)

    fun transparentStatusBar()

    fun TextView.setFont(fontPath: String)

    fun ImageView.imageBackground(drawable: Int)
}