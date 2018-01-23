package br.com.codeteam.ctanywhere.utils

import android.content.ContentValues.TAG
import android.os.Build
import android.telephony.PhoneNumberUtils
import android.util.Log
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil

object Converter {
    fun toPhoneNumber(phone: String, ddd: String): String {
        var phoneAux = phone

        try {
            phoneAux = PhoneNumberUtils.stripSeparators(phoneAux)

            if (phoneAux.length == 8 || phoneAux.length == 9) {
                phoneAux = ddd + phoneAux
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                phoneAux = PhoneNumberUtils.formatNumberToE164(phoneAux, "BR")
            } else {
                val phoneNumberUtil = PhoneNumberUtil.getInstance()
                val phoneNumber = phoneNumberUtil.parse(phoneAux, "BR")

                if (phoneNumberUtil.isValidNumberForRegion(phoneNumber, "BR")) {
                    phoneAux = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164)
                }
            }

            phoneAux = phoneAux.replace("+55", "0")

        } catch (e: NumberParseException) {
            Log.d(TAG, "toPhoneNumber: Erro ao formatar")
        }

        return phoneAux
    }

    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()

        for (t in ts) {
            result.add(t)
        }

        return result
    }
}
