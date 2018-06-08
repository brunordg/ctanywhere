package br.com.codeteam.ctanywhere

import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import br.com.codeteam.ctanywhere.view.ext.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Bruno Rodrigues e Rodrigues on 17/05/2018.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class LogTest {

    //val context = InstrumentationRegistry.getTargetContext()

    @Before
    fun setup() {

    }

    @Test
    fun logD() {
        logDebug("Testando o Log Debug")
    }

    @Test
    fun logE() {
        logError("Testando o log Error")
    }

    @Test
    fun logI() {
        logInfo("Testando o log Info")
    }

    @Test
    fun logV() {
        logVerbose("Testando o log Verbose")
    }

    @Test
    fun logW() {
        logWarn("Testando o log Warn")
    }
}