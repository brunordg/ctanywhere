package br.com.codeteam.ctanywhere.utils

import android.content.Context
import android.text.TextUtils
import android.widget.EditText
import br.ctanywhere.R

object Validator {

    fun isEmptyOrNull(edt: EditText, context: Context, message: String = context.getString(R.string.campo_requerido)): Boolean {
        return if (TextUtils.isEmpty(edt.text.toString())) {
            edt.error = message
            true
        } else {
            edt.error = null
            false
        }
    }

    fun isMinor(edt: EditText, context: Context, size: Int, message: String = String.format(context.getString(R.string.campo_minimo), size)): Boolean {
        return if (edt.text.length < size) {
            edt.error = message
            true
        } else {
            edt.error = null
            false
        }
    }


    fun isMajor(edt: EditText, context: Context, size: Int, message: String = String.format(context.getString(R.string.campo_maximo), size)): Boolean {
        return if (edt.text.length > size) {
            edt.error = message
            true
        } else {
            edt.error = null
            false
        }
    }
}
