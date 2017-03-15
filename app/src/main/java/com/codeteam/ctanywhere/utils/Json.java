package com.codeteam.ctanywhere.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe para facilitar o uso de parse de JSON
 * Created by bruno on 15/03/17.
 */
public class Json {


    /**
     * Converte {@link Object} to Json
     * @param obj
     * @return String
     */
    public static String toJson(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();

        return gson.toJson(obj);
    }

    /**
     * Converte a {@link String} Json para o Objeto que representa
     * @param json
     * @param clazz objeto que vai ser convertideo a partir da String json
     * @return Retorna o objeto que representa o Json
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();

        return gson.fromJson(json, clazz);
    }

    /**
     * Converte o objeto em um Json formatado
     * @param value
     * @return String
     */
    public static String toJsonPretty(Object value) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        return gson.toJson(value);
    }
}
