package br.com.codeteam.ctanywhere;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.codeteam.ctanywhere.preferences.Pref;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Teste unitário para testar a classe de preferences
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PrefTest {
    private static final String TAG = "PrefTest";

    private static final String NAME = "Madeleine";
    private static final String NAME_CHANGE = "Julieta";
    private static final String KEY_NAME = "NAME";

    private static final boolean TRUE = true;
    private static final String KEY_TRUE = "TRUE";

    private Context appContext;

    @Before
    public void setup() {
        this.appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void write() {
        Pref.INSTANCE.write(KEY_NAME, NAME, this.appContext);
        assertEquals(Pref.INSTANCE.read(KEY_NAME, this.appContext), NAME);

        Pref.INSTANCE.write(KEY_TRUE, TRUE, this.appContext);
        assertTrue(Pref.INSTANCE.<Boolean>read(KEY_TRUE, this.appContext));
    }

    @Test
    public void clear() {
        this.write();

        Pref.INSTANCE.clearAll(this.appContext);
        assertNull(Pref.INSTANCE.read(KEY_NAME, this.appContext));
    }

    @Test
    public void registerListener() {
        this.write();

        Pref.INSTANCE.registerPreferenceChanged(this.appContext, new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                Log.d(TAG, "onSharedPreferenceChanged: " + Pref.INSTANCE.read(key, appContext));
                assertEquals(Pref.INSTANCE.read(key, appContext), NAME_CHANGE);
            }
        });

        Pref.INSTANCE.write(KEY_NAME, NAME_CHANGE, this.appContext);
    }
}
