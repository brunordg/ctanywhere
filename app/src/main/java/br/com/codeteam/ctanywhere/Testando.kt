package br.com.codeteam.ctanywhere

import android.support.annotation.IntDef

class Testando {

    companion object {

        const val ADD = 0L
        const val SUBTRACTION = 1L
        const val MULTIPLY = 2L
        const val DIVIDE = 3L
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(Testando.Companion.ADD, Testando.Companion.SUBTRACTION, Testando.Companion.MULTIPLY, Testando.Companion.DIVIDE)
    annotation class OperationDef

    fun operationProvider(a: Int, b: Int, @OperationDef operation: Long): Int {
        return when(operation) {
            ADD -> a + b
            SUBTRACTION -> a - b
            DIVIDE -> a / b
            else -> a * b
        }
    }
}