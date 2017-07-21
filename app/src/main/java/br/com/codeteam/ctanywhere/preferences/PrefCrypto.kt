package br.com.codeteam.ctanywhere.preferences

import android.content.Context
import com.orhanobut.hawk.Hawk

object PrefCrypto {

    fun init(context: Context) = Hawk.init(context).setLogInterceptor(CTInterceptor()).build()

    fun <T> write(key: String, value: T) = Hawk.put(key, value)

    fun <T> get(key: String): T = Hawk.get<T>(key)

    fun delete(key: String): Boolean = Hawk.delete(key)

    fun contains(key: String): Boolean = Hawk.contains(key)

    fun count(): Long = Hawk.count()

    fun deleteAll(): Boolean = Hawk.deleteAll()
}