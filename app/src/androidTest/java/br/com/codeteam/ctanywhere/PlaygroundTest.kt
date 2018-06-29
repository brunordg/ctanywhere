package br.com.codeteam.ctanywhere

import android.content.Context
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlaygroundTest {

    lateinit var context: Context

    @Before
    fun setup() {
        context = InstrumentationRegistry.getTargetContext()
    }

    @Test
    fun callFun() {
        this.someMethod(10) {println("Result $it")}
    }

    inline fun someMethod(a: Int, func: (Int) -> Unit): Int {

        val result = 2 * a

        func(result)

        return result
    }

}