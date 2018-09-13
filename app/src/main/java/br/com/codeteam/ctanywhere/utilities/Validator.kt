package br.com.codeteam.ctanywhere.utilities

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import br.com.codeteam.ctanywhere.R

object Validator {
    @JvmStatic
    fun isEmptyOrNull(edt: EditText, context: Context, message: String = context.getString(R.string.campo_requerido)): Boolean {
        return if (TextUtils.isEmpty(edt.text.toString())) {
            edt.error = message
            true
        } else {
            edt.error = null
            false
        }
    }

    @JvmStatic
    fun isMinor(edt: EditText, context: Context, size: Int, message: String = String.format(context.getString(R.string.campo_minimo), size)): Boolean {
        return if (edt.text.length < size) {
            edt.error = message
            true
        } else {
            edt.error = null
            false
        }
    }

    @JvmStatic
    fun isMajor(edt: EditText, context: Context, size: Int, message: String = String.format(context.getString(R.string.campo_maximo), size)): Boolean {
        return if (edt.text.length > size) {
            edt.error = message
            true
        } else {
            edt.error = null
            false
        }
    }

    @JvmStatic
    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    @JvmStatic
    fun isDomain(domain: String): Boolean {
        return Patterns.DOMAIN_NAME.matcher(domain).matches()
    }

    @JvmStatic
    fun isIPAddress(ip: String): Boolean {
        return Patterns.IP_ADDRESS.matcher(ip).matches()
    }

    @JvmStatic
    fun isPhone(phone: String): Boolean {
        return Patterns.PHONE.matcher(phone).matches()
    }

    @JvmStatic
    fun isWebUrl(webUrl: String): Boolean {
        return Patterns.WEB_URL.matcher(webUrl).matches()
    }
}
