package br.com.codeteam.ctanywhere.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage


/**
 * Created by Bruno Rodrigues e Rodrigues on 25/05/2018.
 */
class SmsBroadcastReceiver() : BroadcastReceiver() {

    @Suppress("DEPRECATION")
    override fun onReceive(context: Context?, intent: Intent?) {
        val data = intent?.extras

        val pdus = arrayListOf(data?.get("pdus")!!)

        for (i in pdus.indices) {
            val smsMessage = SmsMessage.createFromPdu(pdus[i] as ByteArray)

            val sender = smsMessage.displayOriginatingAddress

            if (sender == "GADGETSAINT") {

                val messageBody = smsMessage.messageBody

                //Pass the message text to interface
                if (smsListener.isEmpty()) {
                    throw RuntimeException("Necessário adicionar um Listener")
                }

                for (listener in smsListener) {
                    listener.messageReceived(messageBody)
                }
            }
        }
    }

    companion object {
        var smsListener: ArrayList<SmsListener> = ArrayList()

        fun addListenerSms(listener: SmsListener) {
            smsListener.add(listener)
        }
    }
}