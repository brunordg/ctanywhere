package br.com.codeteam.ctanywhere.utils

import android.content.ContentValues.TAG
import android.os.Build
import android.telephony.PhoneNumberUtils
import android.util.Log
import com.google.gson.Gson
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil

/**
 * Created by Bruno Rodrigues e Rodrigues on 29/01/17.
 */
object Converter {

    fun toPhoneNumber(phone: String, ddd: String): String {
        var phone = phone

        try {
            phone = PhoneNumberUtils.stripSeparators(phone)

            if (phone.length == 8 || phone.length == 9) {
                phone = ddd + phone
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                phone = PhoneNumberUtils.formatNumberToE164(phone, "BR")
            } else {
                val phoneNumberUtil = PhoneNumberUtil.getInstance()
                val phoneNumber = phoneNumberUtil.parse(phone, "BR")

                if (phoneNumberUtil.isValidNumberForRegion(phoneNumber, "BR")) {
                    phone = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164)
                }
            }

            phone = phone.replace("+55", "0")

        } catch (e: NumberParseException) {
            Log.d(TAG, "toPhoneNumber: Erro ao formatar")
        }

        return phone
    }

    fun <T> asList(vararg ts: T): List<T> {
        var result = ArrayList<T>()

        for (t in ts) {
            result.add(t)
        }

        return result
    }
}
