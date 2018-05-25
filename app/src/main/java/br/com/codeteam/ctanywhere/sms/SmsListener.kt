package br.com.codeteam.ctanywhere.sms

/**
 * Created by Bruno Rodrigues e Rodrigues on 25/05/2018.
 */
interface SmsListener {
    fun messageReceived(messageText: String)
}