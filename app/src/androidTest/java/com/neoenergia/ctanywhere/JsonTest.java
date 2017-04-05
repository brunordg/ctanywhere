package com.neoenergia.ctanywhere;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import br.com.codeteam.ctanywhere.utils.Json;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Teste unitário para testar a classe de preferences
 *
 * Created by bruno on 15/03/17.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class JsonTest {
    private static final String TAG = "JsonTest";

    private Context appContext;

    @Before
    public void setup() {
        this.appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void toJson() {
        Register register = new Register("ctanywhere");

        Log.d(TAG, "toJson: " + Json.toJson(register));

        assertEquals(Json.toJson(register), "{\"name\":\"ctanywhere\"}");
    }

    @Test
    public void toJsonPretty() {
        Register register = new Register("ctanywhere");

        Log.d(TAG, "toJson: " + Json.toJsonPretty(register));
    }

    @Test
    public void toObject() {
        Register register = Json.toObject("{\"name\":\"ctanywhere\"}", Register.class);

        Log.d(TAG, "toObject: " + register.getName());

        assertEquals(register.toString(), new Register("ctanywhere").toString());
    }

    public class Register {
        private String name;

        public Register(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Register{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
