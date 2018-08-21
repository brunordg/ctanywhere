package br.com.codeteam.ctanywhere.ext

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

@Suppress("unused")
fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context

    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }

        context = context.baseContext
    }

    return null
}