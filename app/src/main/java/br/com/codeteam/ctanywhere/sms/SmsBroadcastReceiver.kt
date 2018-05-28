package br.com.codeteam.ctanywhere.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage


/**
 * Created by Bruno Rodrigues e Rodrigues on 25/05/2018.
 */
class SmsBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val pdus = intent?.extras?.get("pdus") as Array<*>
        val format = intent.extras.getString("format")
        var text = ""

        for (pdu in pdus) {
            val smsMsg = getSmsMsg(pdu as ByteArray?, format)
            val subMsg = smsMsg?.displayMessageBody

            subMsg?.let { text = "$text$it" }
        }

        for (smsListener in smsListener) {
            smsListener.messageReceived(text)
        }
    }

    private fun getSmsMsg(pdu: ByteArray?, format: String?): SmsMessage? {
        @Suppress("DEPRECATION")
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> SmsMessage.createFromPdu(pdu, format)
            else -> SmsMessage.createFromPdu(pdu)
        }
    }

    companion object {
        var smsListener: ArrayList<SmsListener> = ArrayList()

        @JvmStatic
        fun addListenerSms(listener: SmsListener) {
            smsListener.add(listener)
        }

        @JvmStatic
        fun removeAllListener() {
            smsListener.clear()
        }
    }
}