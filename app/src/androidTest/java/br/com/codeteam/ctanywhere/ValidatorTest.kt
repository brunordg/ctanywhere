package br.com.codeteam.ctanywhere

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import br.com.codeteam.ctanywhere.utils.Converter
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

        Converter.toPhoneNumber("1-800-275-2273", "11")
        //Converter.toPhoneNumber("20973709", "11");

        //        String ddd = "11";
        //        String telefone = "953279911";
        //        String original = telefone;
        //
        //        telefone = PhoneNumberUtils.normalizeNumber(telefone);
        //
        //        if (telefone.length() == 8 || telefone.length() == 9) {
        //            telefone = ddd + telefone;
        //        }
        //
        //        telefone = PhoneNumberUtils.formatNumberToE164(telefone, "BR");
        //
        //        if (telefone == null) {
        //            Log.d(TAG, "isEmergencyNumber: Número não é nacional? " + original);
        //            return;
        //        }
        //        telefone = telefone.replace("+55", "0");
        //
        //        Log.d(TAG, "isEmergencyNumber: " + telefone);
        //
        //        assertTrue(PhoneNumberUtils.isLocalEmergencyNumber(this.appContext, "190"));
    }

    companion object {

        val TAG = "ValidatorTest"
    }
}
