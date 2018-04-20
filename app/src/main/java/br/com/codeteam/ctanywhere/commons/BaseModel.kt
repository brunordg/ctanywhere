package br.com.codeteam.ctanywhere.commons

import br.com.codeteam.ctanywhere.utils.Json

abstract class BaseModel {

    fun toJson(): String {
        return Json.toJson(this)
    }
}