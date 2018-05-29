package br.com.codeteam.ctanywhere.view.ext

import android.support.v7.app.AlertDialog

/**
 * Created by Bruno Rodrigues e Rodrigues on 18/05/2018.
 */
fun AlertDialog.Builder.positiveButton(name: String = "OK", clickListener: (which: Int) -> Any = {}) {
    setPositiveButton(name, { _, which -> clickListener(which) })
}

fun AlertDialog.Builder.negativeButton(name: String = "Cancelar", clickListener: (which: Int) -> Any = {}) {
    setNegativeButton(name, { _, which -> clickListener(which) })
}

fun AlertDialog.Builder.neutralButton(name: String = "Fechar", clickListener: (which: Int) -> Any = {}) {
    setNeutralButton(name, { _, which -> clickListener(which) })
}