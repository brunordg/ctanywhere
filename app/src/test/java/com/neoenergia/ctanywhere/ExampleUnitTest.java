package com.neoenergia.ctanywhere;

import android.telephony.PhoneNumberUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
    
        assertTrue(PhoneNumberUtils.isEmergencyNumber("190"));
        assertEquals(4, 2 + 2);
    }
}