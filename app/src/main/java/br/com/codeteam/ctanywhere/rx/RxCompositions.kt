package br.com.codeteam.ctanywhere.rx

import android.util.Patterns
import br.com.codeteam.ctanywhere.utils.StringUtils
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Single

object RxCompositions {

    fun lengthGreaterThan(length: Int): ObservableTransformer<String, String> {
        return ObservableTransformer { observable ->
            observable.flatMap {
                Observable.just(it).map { it.trim() }
                        .filter { it.length > length }
                        .singleOrError()
                        .onErrorResumeNext {
                            if (it is NoSuchElementException) {
                                Single.error(Exception("Tamanho mínimo: $length"))
                            } else {
                                Single.error(it)
                            }
                        }
                        .toObservable()
            }
        }
    }

    fun lengthLessThan(length: Int): ObservableTransformer<String, String> {
        return ObservableTransformer { observable ->
            observable.flatMap {
                Observable.just(it).map { it.trim() }
                        .filter { it.length < length }
                        .singleOrError()
                        .onErrorResumeNext {
                            if (it is NoSuchElementException) {
                                Single.error(Exception("Tamanho máximo: $length"))
                            } else {
                                Single.error(it)
                            }
                        }
                        .toObservable()
            }
        }
    }

    fun isEmailValid(): ObservableTransformer<String, String> {
        return ObservableTransformer { observable ->
            observable.flatMap {
                Observable.just(it).map { it.trim() }
                        .filter { Patterns.EMAIL_ADDRESS.matcher(it).matches() }
                        .singleOrError()
                        .onErrorResumeNext {
                            if (it is NoSuchElementException) {
                                Single.error(Exception("Email inválido"))
                            } else {
                                Single.error(it)
                            }
                        }
                        .toObservable()
            }
        }
    }

    fun isBlankOrNull(): ObservableTransformer<String, String> {
        return ObservableTransformer { observable ->
            observable.flatMap {
                Observable.just(it).map { it.trim() }
                        .filter { StringUtils.isBlankOrNull(it) }
                        .singleOrError()
                        .onErrorResumeNext {
                            if (it is NoSuchElementException) {
                                Single.error(Exception("Requerido"))
                            } else {
                                Single.error(it)
                            }
                        }
                        .toObservable()
            }
        }
    }


}