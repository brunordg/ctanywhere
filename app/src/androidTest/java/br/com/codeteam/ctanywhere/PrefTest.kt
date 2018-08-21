package br.com.codeteam.ctanywhere

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import br.com.codeteam.ctanywhere.preferences.Pref
import br.com.codeteam.ctanywhere.preferences.PrefCrypto
import org.junit.Assert.*
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

    lateinit var context: Context

    @Before
    fun setup() {
        context = InstrumentationRegistry.getTargetContext()

        PrefCrypto.init(context)
    }

    @Test
    fun write() {
        Pref.write(KEY_NAME, NAME, context)
        assertEquals(Pref.read(KEY_NAME, context), NAME)

        Pref.write(KEY_TRUE, TRUE, context)
        assertTrue(Pref.read(KEY_TRUE, context))

        PrefCrypto.write(KEY_NAME, NAME)
        assertEquals(PrefCrypto.get(KEY_NAME), NAME)

        PrefCrypto.write(KEY_TRUE, TRUE)
        assertTrue(PrefCrypto.get(KEY_TRUE))
    }

    @Test
    fun clear() {
        this.write()

        Pref.clearAll(context)
        assertNull(Pref.read(KEY_NAME, context))

        PrefCrypto.deleteAll()
        assertNull(PrefCrypto.get(NAME))
    }

    @Test
    fun registerListener() {
        this.write()

        Pref.registerPreferenceChanged(context, SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            Log.d(TAG, "onSharedPreferenceChanged: " + Pref.read<Any>(key, context))
            assertEquals(Pref.read(key, context), NAME_CHANGE)
        })

        Pref.write(KEY_NAME, NAME_CHANGE, context)
    }

    @Test
    fun deletePrefCrypto() {
        PrefCrypto.write(KEY_NAME, NAME)
        PrefCrypto.delete(KEY_NAME)

        assertNull(PrefCrypto.get(KEY_NAME))
    }

    @Test
    fun countPrefCrypto() {
        PrefCrypto.deleteAll()
        PrefCrypto.write(KEY_NAME, NAME)
        assertEquals(PrefCrypto.count(), 1)

        PrefCrypto.deleteAll()
        assertEquals(PrefCrypto.count(), 0)
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
