package br.com.codeteam.ctanywhere.utilities

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

object FileUtils {
    @JvmStatic
    @Throws(IOException::class)
    fun loadJSONFromAsset(context: Context, jsonFileName: String): String {
        (context.assets).open(jsonFileName).let {
            val buffer = ByteArray(it.available())

            it.read(buffer)
            it.close()
            buffer
        }.let { return String(it, Charset.forName("UTF-8")) }
    }
}