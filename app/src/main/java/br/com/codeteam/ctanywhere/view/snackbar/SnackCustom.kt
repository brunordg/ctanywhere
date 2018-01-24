package br.com.codeteam.ctanywhere.view.snackbar

import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.view.ViewGroup
import br.com.codeteam.ctanywhere.R

class SnackCustom(val activity: AppCompatActivity) {

    private val sb: SpannableStringBuilder? = null

    private val span: ImageSpan? = null


    fun buildFormat(messageId: Int, type: Type): Snackbar {
        return build(this.activity.getString(messageId), type)
    }

    fun build(messageId: Int, type: Type): Snackbar {
        return build(this.activity.getString(messageId), type)
    }

    fun build(message: String, type: Type): Snackbar {

        var viewGroup: ViewGroup?

        viewGroup = this.activity.findViewById<ViewGroup?>(android.R.id.content)

        if (viewGroup == null) {
            viewGroup = this.activity.window.decorView.rootView as ViewGroup
        }

        val foregroundColorSpan = ForegroundColorSpan(ContextCompat.getColor(this.activity, R.color.whiteTransparent))
        val snackText = SpannableStringBuilder(message)

        snackText.setSpan(foregroundColorSpan, 0, snackText.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

        val snack = Snackbar.make(viewGroup, snackText, Snackbar.LENGTH_LONG)

        val snackViewSuccess = snack.view

        snackViewSuccess.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarGreen))

        when (type) {
            Type.WARN -> snackViewSuccess.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarYellow))
            Type.ERROR -> snackViewSuccess.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarRed))
            Type.SUCCESS -> snackViewSuccess.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarGreen))
            else -> snackViewSuccess.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarBlue))
        }

        return snack
    }

    enum class Type(var value: String) {
        WARN("WARN"),
        ERROR("ERROR"),
        INFO("INFO"),
        SUCCESS("SUCCESS")
    }
}
