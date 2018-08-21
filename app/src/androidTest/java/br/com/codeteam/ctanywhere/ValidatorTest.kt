package br.com.codeteam.ctanywhere

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import br.com.codeteam.ctanywhere.utils.Converter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Teste unitário para testar os validadores
 *
 *
 * Created by Bruno Rodrigues e Rodrigues on 29/03/17.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class ValidatorTest {

    @Before
    fun setup() {
        //val appContext = InstrumentationRegistry.getTargetContext()
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Test
    fun isEmergencyNumber() {
        Assert.assertEquals("01120202020", Converter.toPhoneNumber("20202020", "11"))
    }
}
