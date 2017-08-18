package br.com.codeteam.ctanywhere.preferences

import android.content.Context
import android.content.SharedPreferences
import br.com.codeteam.ctanywhere.utils.Validator

object Pref {
    private val FILE = "PREFERENCE_FILE_KEY"

    /**
     * Escreve nas SharedPreferences privadas
     * @param key
     * @param value
     * @param context
     */
    fun write(key: String, value: Any, context: Context) {
        val sharedPreferences = context.getSharedPreferences(context.packageName + FILE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        when(value) {
            is Boolean -> editor.putBoolean(key, value)
            is Float -> editor.putFloat(key, value)
            is Int -> editor.putInt(key, value)
            is Long -> editor.putLong(key, value)
            is String -> editor.putString(key, value)
            is Set<*> -> editor.putStringSet(key, value as Set<String>)
            else -> throw RuntimeException("Tipo de preference (" + value.javaClass.simpleName + ") não suportado, os tipos suportados são {Boolean, Float, Integer, Long, String, Set<String>}")
        }

        editor.apply()
    }

    /**
     * Lê as SharedPreferences privadas
     * @param key
     * *
     * @param context
     * *
     * @param <T>
     * *
     * @return Retorna o objeto solicitado
    </T> */
    fun <T> read(key: String, context: Context): T {
        return context.getSharedPreferences(context.packageName + FILE, Context.MODE_PRIVATE).all[key] as T
    }

    /**
     * Limpa todos as SharedPreferences do projeto
     * @param context
     */
    fun clearAll(context: Context) {
        context.getSharedPreferences(context.packageName + FILE, Context.MODE_PRIVATE).edit().clear().apply()
    }

    /**
     * Registra o Listener quando é alterado alguma SharedPreference do app
     * @param context
     * *
     * @param listener
     */
    fun registerPreferenceChanged(context: Context, listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        context.getSharedPreferences(context.packageName + FILE, Context.MODE_PRIVATE).registerOnSharedPreferenceChangeListener(listener)
    }

    /**
     * Desregistra o Listener de alteração de SharedPreferences
     * @param context
     * *
     * @param listener
     */
    fun unregisterPreferenceChanged(context: Context, listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        context.getSharedPreferences(context.packageName + FILE, Context.MODE_PRIVATE).unregisterOnSharedPreferenceChangeListener(listener)
    }
}
