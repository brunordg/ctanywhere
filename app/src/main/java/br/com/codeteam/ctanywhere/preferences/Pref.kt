package br.com.codeteam.ctanywhere.preferences

import android.content.Context
import android.content.SharedPreferences

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

        when (value) {
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
     * Compara o valor de uma Preference com um valor aleatório passado como parâmetro
     */
    fun equals(key: String, value: Any, context: Context): Boolean {
        val content = context.getSharedPreferences(context.packageName + FILE, Context.MODE_PRIVATE).all[key]

        val type = when (content) {
            is Boolean -> value is Boolean
            is Float -> value is Float
            is Int -> value is Int
            is Long -> value is Long
            is String -> value is String
            else -> false
        }

        if (!type) {
            throw RuntimeException("Os tipos de conparação são diferentes ( Value: " + value.javaClass.simpleName + " )")
        }

        return when (content) {
            is Boolean -> content == value
            is Float -> content == value
            is Int -> content == value
            is Long -> content == value
            is String -> content.equals(value)
            else -> throw RuntimeException("Este tipo de objeto não é possível executar uma comparação (" + value.javaClass.simpleName + ") os tipos suportados são {Boolean, Float, Integer, Long, String}")
        }
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
