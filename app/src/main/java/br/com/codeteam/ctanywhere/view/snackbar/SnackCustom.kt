package br.com.codeteam.ctanywhere.view.snackbar

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import br.com.codeteam.ctanywhere.R
import br.com.codeteam.ctanywhere.ext.getDrawableCompat
import com.google.android.material.snackbar.Snackbar

class SnackCustom(private val activity: AppCompatActivity) {

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

        val snackView = snack.view

        val params = snackView.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(12, 12, 12, 12)

        snackView.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarGreen))
        snackView.layoutParams = params
        snackView.background = activity.getDrawableCompat(R.drawable.bg_snackbar)

        ViewCompat.setElevation(snackView, 6f)

        when (type) {
            Type.WARN -> snackView.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarYellow))
            Type.ERROR -> snackView.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarRed))
            Type.SUCCESS -> snackView.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarGreen))
            Type.INFO -> snackView.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarBlue))
            else -> snackView.setBackgroundColor(ContextCompat.getColor(this.activity, R.color.SnackbarDefault))
        }

        return snack
    }

    enum class Type(var value: String) {
        WARN("WARN"),
        ERROR("ERROR"),
        INFO("INFO"),
        SUCCESS("SUCCESS"),
        DEFAULT("DEFAULT")
    }
}
