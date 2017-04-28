package br.com.codeteam.ctanywhere.log;

import timber.log.Timber;

/**
 * Created by Bruno Rodrigues e Rodrigues on 28/04/17.
 */

public class CTLog {
    
    /**
     * Encapsula o Timber error
     * @param e
     * @param message
     * @param args
     */
    public static void e(Throwable e, String message, Object... args) {
        Timber.e(e, message, args);
    }
    
    public static void e(String message, Object... args) {
        Timber.e(message, args);
    }
    
    /**
     * Encapsula o Timber Debug
     * @param message
     * @param args
     */
    public static void d(String message, Object... args) {
        Timber.d(message, args);
    }
    
    /**
     * Encapsula o Timber Info
     * @param message
     * @param args
     */
    public static void i(String message, Object... args) {
        Timber.i(message, args);
    }
    
    /**
     * Encapsula o Timber WTF
     * @param message
     * @param args
     */
    public static void wtf(String message, Object... args) {
        Timber.wtf(message, args);
    }
}
