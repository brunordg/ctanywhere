package br.com.codeteam.ctanywhere.commons

interface CallbackListener<T> {

    fun onSuccess(data: T)

    fun onFailure(e: Throwable)
}