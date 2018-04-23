package br.com.codeteam.ctanywhere

import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import br.com.codeteam.ctanywhere.utils.Json
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import timber.log.Timber

/**
 * Teste unitário para testar a classe de preferences
 *
 *
 * Created by bruno on 15/03/17.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class JsonTest {

    val context = InstrumentationRegistry.getTargetContext()

    @Before
    fun setup() {
        //Context appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    fun toJson() {
        val register = Register("ctanywhere")

        Timber.d("toJson: %s", Json.toJson(register))

        assertEquals(Json.toJson(register), "{\"name\":\"ctanywhere\"}")
    }

    @Test
    fun toJsonPretty() {
        val register = Register("ctanywhere")

        Timber.d("toJson: %s", Json.toJsonPretty(register))

    }

    @Test
    fun toObject() {
        val register = Json.fromJson("{\"name\":\"ctanywhere\"}", Register::class.java)

        Timber.d("toObject: %s", register.name)

        assertEquals(register.toString(), Register("ctanywhere").toString())
    }

    inner class Register(var name: String?) {

        override fun toString(): String {
            val sb = StringBuilder("Register{")
            sb.append("name='").append(name).append('\'')
            sb.append('}')
            return sb.toString()
        }
    }
}
