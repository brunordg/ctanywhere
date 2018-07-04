package br.com.codeteam.ctanywhere.view.ext

import br.com.codeteam.ctanywhere.utils.Json

fun Any.toJson(): String = Json.toJson(this)