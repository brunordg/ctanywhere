package com.codeteam.ctanywhere.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe para ler arquivos
 * Created by bruno on 02/03/17.
 */
public class ReadFile {

    public static String readFileAssets(String fileInAssets, Context context) throws IOException {
        BufferedReader reader = null;
        StringBuilder sb;
        String line;

        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileInAssets)));

            sb = new StringBuilder();
            line = reader.readLine();

            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }

        } catch (Exception e) {
            throw new IOException(e);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return sb.toString();
    }
}
