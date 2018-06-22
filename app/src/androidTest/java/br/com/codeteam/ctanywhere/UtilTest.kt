package br.com.codeteam.ctanywhere

import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import br.com.codeteam.ctanywhere.utils.StringUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Bruno Rodrigues e Rodrigues on 28/05/2018.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class UtilTest {

    //val context = InstrumentationRegistry.getTargetContext()

    @Before
    fun setup() {

    }

    @Test
    fun onlyNumber() {
        val message = "Digit 94 26 44 para acessar o Conecta Center"

        Assert.assertEquals("942644", StringUtils.onlyNumber(message))
    }
}