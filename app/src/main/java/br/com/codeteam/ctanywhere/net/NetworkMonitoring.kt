package br.com.codeteam.ctanywhere.net

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import br.com.codeteam.ctanywhere.utilities.NetworkUtils

class NetworkMonitoring : BroadcastReceiver() {

    var list: ArrayList<NetworkListener> = ArrayList()

    override fun onReceive(context: Context?, intent: Intent?) {

        if (context == null) {
            return
        }

        this.list.forEach { it.changeNetworkd(NetworkUtils.isNetworkAvailable(context)) }
    }

    fun addListener(networkListener: NetworkListener) {
        this.list.add(networkListener)
    }

    fun removeListener(networkListener: NetworkListener) {
        this.list.remove(networkListener)
    }

    fun removeAll() {
        this.list = ArrayList()
    }

}