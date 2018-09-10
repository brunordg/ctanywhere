package br.com.codeteam.ctanywhere.utilities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AlertDialog
import br.com.codeteam.ctanywhere.R


/**
 * Classe para ajudar o tratamento de operações de Rede
 * Created by Bruno Rodrigues on 24/11/2017.
 */
object NetworkUtils {

    /**
     * Verifica a conexão, é possíve a navegação até o settings e também exibe uma mensagem
     */
    @Suppress("unused")
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
                    setPositiveButton(context.getString(R.string.configuracao)) { dialog, _ ->
                        dialog.dismiss()
                        context.startActivity(Intent(android.provider.Settings.ACTION_SETTINGS))
                    }

                    setNegativeButton(context.getText(R.string.cancelar)) { dialog, _ ->
                        dialog.dismiss()
                    }
                }
            } else {
                alertDialog.setNeutralButton(context.getText(R.string.ok)) { dialog, _ ->
                    dialog.dismiss()
                }
            }

            alertDialog.show()
        }

        return false
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    @Suppress("unused")
    fun isWifi(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        return networkInfo.isConnected
    }

    /**
     * Verifica a conexão
     */
    @SuppressLint("MissingPermission")
    fun isNetworkAvailable(context: Context): Boolean {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as (ConnectivityManager)).activeNetworkInfo.isConnected
    }
}