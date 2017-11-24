package br.com.codeteam.ctanywhere.utils

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.support.annotation.RequiresPermission
import android.telephony.TelephonyManager


/**
 * Classe para ajudar o tratamento de operações de Rede
 * Created by Bruno Rodrigues on 24/11/2017.
 */
class NetworkUtils {
    companion object {

        /**
         * Verifica se o app está em uma aplicação boa ou ruim
         * Necessário verificar se o usuário tem permissão para acessar as informações de rede
         */
        @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
        fun isGood(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val networkInfo = cm.activeNetworkInfo
            val isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting

            if (isConnected) {
                when (networkInfo.type) {
                    ConnectivityManager.TYPE_WIFI -> return true
                    ConnectivityManager.TYPE_MOBILE ->
                        return when (networkInfo.subtype) {
                            TelephonyManager.NETWORK_TYPE_GPRS -> false
                            TelephonyManager.NETWORK_TYPE_EDGE -> false
                            TelephonyManager.NETWORK_TYPE_1xRTT -> false
                            TelephonyManager.NETWORK_TYPE_CDMA -> false
                            TelephonyManager.NETWORK_TYPE_UNKNOWN -> true
                            TelephonyManager.NETWORK_TYPE_HSPA -> true
                            TelephonyManager.NETWORK_TYPE_HSUPA -> true
                            TelephonyManager.NETWORK_TYPE_UMTS -> true
                            TelephonyManager.NETWORK_TYPE_EVDO_0 -> true
                            TelephonyManager.NETWORK_TYPE_EVDO_A -> true
                            else -> false
                        }
                }
            }

            return false
        }
    }
}