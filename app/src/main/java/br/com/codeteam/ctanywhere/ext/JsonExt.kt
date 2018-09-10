package br.com.codeteam.ctanywhere.ext

import br.com.codeteam.ctanywhere.utilities.Json

@Suppress("unused")
fun Any.toJson(): String = Json.toJson(this)