package br.com.codeteam.ctanywhere

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import br.com.codeteam.ctanywhere.preferences.Pref
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Teste unitário para testar a classe de preferences
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class PrefTest {

    private var appContext: Context? = null

    @Before
    fun setup() {
        this.appContext = InstrumentationRegistry.getTargetContext()
    }

    @Test
    fun write() {
        Pref.write(KEY_NAME, NAME, this.appContext!!)
        assertEquals(Pref.read(KEY_NAME, this.appContext!!), NAME)

        Pref.write(KEY_TRUE, TRUE, this.appContext!!)
        assertTrue(Pref.read(KEY_TRUE, this.appContext!!))
    }

    @Test
    fun clear() {
        this.write()

        Pref.clearAll(this.appContext!!)
        assertNull(Pref.read(KEY_NAME, this.appContext!!))
    }

    @Test
    fun registerListener() {
        this.write()

        Pref.registerPreferenceChanged(this.appContext!!, SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            Log.d(TAG, "onSharedPreferenceChanged: " + Pref.read<Any>(key, appContext!!))
            assertEquals(Pref.read(key, appContext!!), NAME_CHANGE)
        })

        Pref.write(KEY_NAME, NAME_CHANGE, this.appContext!!)
    }

    @Test
    fun compare() {
        Pref.write(KEY_NAME, NAME, this.appContext!!)

        assertEquals(Pref.equals(KEY_NAME, NAME, appContext!!), true)
    }

    companion object {
        private val TAG = "PrefTest"

        private val NAME = "Madeleine"
        private val NAME_CHANGE = "Julieta"
        private val KEY_NAME = "NAME"

        private val TRUE = true
        private val KEY_TRUE = "TRUE"
    }
}
