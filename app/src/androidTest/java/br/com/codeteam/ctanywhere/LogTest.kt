package br.com.codeteam.ctanywhere

import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import br.com.codeteam.ctanywhere.view.ext.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import timber.log.Timber

/**
 * Created by Bruno Rodrigues e Rodrigues on 17/05/2018.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class LogTest {

    val context = InstrumentationRegistry.getTargetContext()

    @Before
    fun setup() {
        Timber.plant(Timber.DebugTree())
    }

    @Test
    fun logD() {
        LogDebug("Testando o Log Debug")
        TimberDebug("Testando o Log Debug Timber")
    }

    @Test
    fun logE() {
        LogError("Testando o log Error")
        TimberError("Testando o Log Error Timber")
    }

    @Test
    fun logI() {
        LogInfo("Testando o log Info")
        TimberInfo("Testando o Log Info Timber")
    }

    @Test
    fun logV() {
        LogVerbose("Testando o log Verbose")
        TimberVerbose("Testando o Log Verbose Timber")
    }

    @Test
    fun logW() {
        LogWarn("Testando o log Warn")
        TimberWarn("Testando o Log Warn Timber")
    }
}