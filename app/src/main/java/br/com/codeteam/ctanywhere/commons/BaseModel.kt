package br.com.codeteam.ctanywhere.commons

import br.com.codeteam.ctanywhere.utils.Json
import org.json.JSONObject

abstract class BaseModel {

    fun toJson(): String {
        return Json.toJson(this)
    }

    fun toJsonObject(): JSONObject {
        return JSONObject(toJson())
    }
}