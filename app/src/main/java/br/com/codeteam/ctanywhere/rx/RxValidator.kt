package br.com.codeteam.ctanywhere.rx

import android.content.Context
import android.widget.EditText
import br.com.codeteam.ctanywhere.R
import io.reactivex.Observable
import timber.log.Timber

object RxValidator {

    fun isEmailValid(edt: EditText, context: Context) {
        Observable.just(edt.text.toString())
                .compose(RxCompositions.lengthGreaterThan(6))
                .compose(RxCompositions.isEmailValid())
                .subscribe({
                    edt.error = null
                }, {
                    Timber.d("onError: ${context.resources.getResourceName(edt.id)} ${it.message}")
                    edt.error = it.message
                }, {
                    edt.error = null
                })
    }

    fun isMinor(edt: EditText, context: Context, size: Int, message: String = String.format(context.getString(R.string.campo_minimo), size)) {
        Observable.just(edt.text.toString())
                .compose(RxCompositions.isBlankOrNull())
                .compose(RxCompositions.lengthLessThan(size))
                .subscribe({
                    edt.error = null
                }, {
                    Timber.d("onError: ${context.resources.getResourceName(edt.id)}:  ${it.message}")
                    edt.error = message
                }, {
                    edt.error = null
                })
    }

    fun isMajor(edt: EditText, context: Context, size: Int, message: String = String.format(context.getString(R.string.campo_minimo), size)) {
        Observable.just(edt.text.toString())
                .compose(RxCompositions.isBlankOrNull())
                .compose(RxCompositions.lengthGreaterThan(size))
                .subscribe({
                    edt.error = null
                }, {
                    Timber.d("onError: ${context.resources.getResourceName(edt.id)} ${it.message}")
                    edt.error = message
                }, {
                    edt.error = null
                })
    }
}