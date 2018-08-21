package br.com.codeteam.ctanywhere

import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import br.com.codeteam.ctanywhere.base.BaseModel
import br.com.codeteam.ctanywhere.ext.logDebug
import br.com.codeteam.ctanywhere.ext.toJson
import br.com.codeteam.ctanywhere.utils.Json
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

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

    //val context = InstrumentationRegistry.getTargetContext()

    @Before
    fun setup() {
        //Context appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    fun toJson() {
        val register = Register("ctanywhere")

        logDebug("toJson: ${Json.toJson(register)}")

        assertEquals(Json.toJson(register), "{\"name\":\"ctanywhere\"}")
    }

    @Test
    fun toJsonPretty() {
        val register = Register("ctanywhere")

        logDebug("toJson: ${Json.toJsonPretty(register)}")
    }

    @Test
    fun toObject() {
        val register = Json.fromJson("{\"name\":\"ctanywhere\"}", Register::class.java)

        logDebug("toObject: ${register.name}")

        assertEquals(register.toString(), Register("ctanywhere").toString())
    }

    @Test
    fun toJsonExt() {
        assertEquals("{\"name\":\"ctanywhere\"}", Register("ctanywhere").toJson())
    }

    inner class Register(var name: String?) {
        override fun toString(): String {
            return toJson()
        }
    }
}
