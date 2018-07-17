package br.com.codeteam.ctanywhere.ext

import br.com.codeteam.ctanywhere.utils.Json

@Suppress("unused")
fun Any.toJson(): String = Json.toJson(this)