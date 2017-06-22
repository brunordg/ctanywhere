package br.com.codeteam.ctanywhere.utils

import com.google.gson.GsonBuilder

/**
 * Classe para facilitar o uso de parse de JSON
 * Created by bruno on 15/03/17.
 */
object Json {


    /**
     * Converte [Object] to Json
     * @param obj
     * @return String
     */
    fun toJson(value: Any): String {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setLenient()

        return gsonBuilder.create().toJson(value)
    }

    /**
     * Converte a [String] Json para o Objeto que representa
     * @param json
     * @param clazz objeto que vai ser convertideo a partir da String json
     * @return Retorna o objeto que representa o Json
     */
    fun <T> toObject(json: String, clazz: Class<T>): T {
        return GsonBuilder().setLenient().create().fromJson(json, clazz);
    }

    /**
     * Converte o objeto em um Json formatado
     * @param value
     * @return String
     */
    fun toJsonPretty(value: Any): String {
        return GsonBuilder().setLenient().setPrettyPrinting().create().toJson(value)
    }
}
