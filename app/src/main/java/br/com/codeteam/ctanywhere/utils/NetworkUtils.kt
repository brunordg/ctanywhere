package br.com.codeteam.ctanywhere.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.support.annotation.RequiresPermission
import android.support.v7.app.AlertDialog
import android.telephony.TelephonyManager
import br.com.codeteam.ctanywhere.R


/**
 * Classe para ajudar o tratamento de operações de Rede
 * Created by Bruno Rodrigues on 24/11/2017.
 */
object NetworkUtils {

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

    /**
     * Verifica a conexão, é possíve a navegação até o settings e também exibe uma mensagem
     */
    fun isOnline(context: Context, message: Boolean, goSettings: Boolean): Boolean {
        if (isNetworkAvailable(context)) {
            return true
        }

        if (message) {
            val alertDialog = AlertDialog.Builder(context)

            with(alertDialog) {
                setTitle(context.getString(R.string.titulo_conexao))
                setMessage(context.getString(R.string.mensagem_validacao_internet))
                setCancelable(false)
            }

            if (goSettings) {
                with(alertDialog) {
                    setPositiveButton(context.getString(R.string.configuracao), { dialog, _ ->
                        dialog.dismiss()
                        context.startActivity(Intent(android.provider.Settings.ACTION_SETTINGS))
                    })

                    setNegativeButton(context.getText(R.string.cancelar), { dialog, _ ->
                        dialog.dismiss()
                    })
                }
            } else {
                alertDialog.setNeutralButton(context.getText(R.string.ok), { dialog, _ ->
                    dialog.dismiss()
                })
            }

            alertDialog.show()
        }

        return false
    }

    /**
     * Verifica a conexão
     */
    @SuppressLint("MissingPermission")
    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as (ConnectivityManager)
        val activeNetwork = cm.activeNetworkInfo

        return activeNetwork.isConnectedOrConnecting
    }
}