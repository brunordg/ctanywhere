package br.com.codeteam.ctanywhere.utils

import android.content.Context
import android.text.TextUtils
import android.widget.EditText
import br.ctanywhere.R

/**
 * Created by Bruno Rodrigues e Rodrigues on 29/01/17.
 */

object Validator {

    fun isEmptyOrNull(edt: EditText, context: Context, message: String = context.getString(R.string.campo_requerido)) : Boolean {
        return if (TextUtils.isEmpty(edt.text.toString())) {
            edt.error = message
            true
        } else {
            edt.error = null
            false
        }
    }
}
