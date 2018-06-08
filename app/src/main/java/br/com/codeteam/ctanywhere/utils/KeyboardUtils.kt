package br.com.codeteam.ctanywhere.utils

import android.support.v7.app.AppCompatActivity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by Bruno Rodrigues on 24/11/2017.
 * Classe para auxiliar as funções do teclado
 */
object KeyboardUtils {
    fun hideSoftInput(activity: AppCompatActivity) {
        var view = activity.currentFocus

        if (null == view) view = View(activity)

        val iml = activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager

        iml.hideSoftInputFromInputMethod(view.windowToken, 0)
    }

    fun showSoftInput(edit: EditText, context: Context) {
        edit.isFocusable = true
        edit.isFocusableInTouchMode = true
        edit.requestFocus()

        val iml = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        iml.showSoftInput(edit, 0)
    }

    fun toggleSoftInput(context: Context) {
        val iml = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        iml.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}