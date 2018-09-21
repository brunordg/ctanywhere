package br.com.codeteam.ctanywhere.ext

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Typeface
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable

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

@Suppress("unused")
fun TextView.setFont(fontPath: String) {
    typeface = Typeface.createFromAsset(context.assets, fontPath)
}

@SuppressLint("RestrictedApi")
@Suppress("unused")
fun ImageView.imageBackground(drawable: Int, context: Context) {
    setImageDrawable(AppCompatDrawableManager.get().getDrawable(context, drawable))
}
