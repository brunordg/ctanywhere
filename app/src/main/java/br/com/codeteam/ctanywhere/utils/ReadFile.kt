package br.com.codeteam.ctanywhere.utils

import android.content.Context

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Classe para ler arquivos
 * Created by bruno on 02/03/17.
 */
object ReadFile {

    @Throws(IOException::class)
    fun readFileAssets(fileInAssets: String, context: Context): String {
        val sb: StringBuilder
        var reader: BufferedReader
        var line: String

        try {
            reader = BufferedReader(InputStreamReader(context.assets.open(fileInAssets)))

            sb = StringBuilder()
            line = reader.readLine()

            while (line != null) {
                sb.append(line)
                line = reader.readLine()
            }

            reader.close()

        } catch (e: Exception) {
            throw IOException(e)
        }

        return sb.toString()
    }
}
