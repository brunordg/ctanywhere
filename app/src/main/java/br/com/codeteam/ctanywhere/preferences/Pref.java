package br.com.codeteam.ctanywhere.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by bruno on 02/03/17.
 */

public class Pref {
    private static final String FILE = "PREFERENCE_FILE_KEY";
    
    /**
     * Escreve nas SharedPreferences privadas
     * @param key
     * @param value
     * @param context
     */
    public static void write(String key, Object value, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        
        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set<?>) {
            editor.putStringSet(key, (Set<String>) value);
        } else {
            throw new RuntimeException("Tipo de preference (" + value.getClass().getSimpleName() + ") não suportado, os tipos suportados são {Boolean, Float, Integer, Long, String, Set<String>}");
        }
        
        editor.apply();
    }
    
    /**
     * Lê as SharedPreferences privadas
     * @param key
     * @param context
     * @param <T>
     * @return Retorna o objeto solicitado
     */
    public static <T> T read(String key, Context context) {
        return (T) context.getSharedPreferences(context.getPackageName() + FILE, Context.MODE_PRIVATE).getAll().get(key);
    }
    
    /**
     * Limpa todos as SharedPreferences do projeto
     * @param context
     */
    public static void clearAll(Context context) {
        context.getSharedPreferences(context.getPackageName() + FILE, Context.MODE_PRIVATE).edit().clear().commit();
    }
    
    /**
     * Registra o Listener quando é alterado alguma SharedPreference do app
     * @param context
     * @param listener
     */
    public static void registerPreferenceChanged(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        context.getSharedPreferences(context.getPackageName() + FILE, Context.MODE_PRIVATE).registerOnSharedPreferenceChangeListener(listener);
    }
    
    /**
     * Desregistra o Listener de alteração de SharedPreferences
     * @param context
     * @param listener
     */
    public static void unregisterPreferenceChanged(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        context.getSharedPreferences(context.getPackageName() + FILE, Context.MODE_PRIVATE).unregisterOnSharedPreferenceChangeListener(listener);
    }
}
