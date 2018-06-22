package br.com.codeteam.ctanywhere.view.toast

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import br.com.codeteam.ctanywhere.R

class Toast(context: Context?) : Toast(context) {

    companion object {

        const val DEFAULT = 0
        const val SUCCESS = 1
        const val WARNING = 2
        const val ERROR = 3
        const val INFO = 4
        const val CONFUSING = 5

        const val LENGTH_SHORT = 0
        const val LENGTH_LONG = 1

        fun makeTest(context: Context, @StringRes message: Int, duration: Int, type: Int = 0, androidIcon: Boolean = false): Toast {
            return makeTest(context, context.getString(message), duration, type, androidIcon)
        }

        fun makeTest(context: Context, message: String, duration: Int, type: Int = 0, androidIcon: Boolean = false): Toast {
            val imageResource = when (type) {
                SUCCESS -> R.drawable.ic_check_black_24dp
                WARNING -> R.drawable.ic_pan_tool_black_24dp
                ERROR -> R.drawable.ic_clear_black_24dp
                INFO -> R.drawable.ic_info_outline_black_24dp
                CONFUSING -> R.drawable.ic_refresh_black_24dp
                else -> 0
            }

            return makeTest(context, message, duration, type, androidIcon, imageResource)
        }

        @SuppressLint("InflateParams")
        fun makeTest(context: Context, message: String, duration: Int, type: Int = 0, androidIcon: Boolean, imageResource: Int): Toast {
            val toast = Toast(context)
            toast.duration = duration

            val layout = LayoutInflater.from(context).inflate(R.layout.toast_layout, null, false)
            val label = layout.findViewById<TextView>(R.id.toast_text)
            val linearLayout = layout.findViewById<LinearLayout>(R.id.toast_type)
            val img = layout.findViewById<ImageView>(R.id.toast_icon)
            val img1 = layout.findViewById<ImageView>(R.id.imageView4)

            label.text = message

            img1.visibility = if (androidIcon) View.VISIBLE else View.GONE

            if (imageResource > 0) {
                img.setImageResource(imageResource)
            }


            when (type) {
                SUCCESS -> linearLayout.setBackgroundResource(R.drawable.success_shape)
                WARNING -> linearLayout.setBackgroundResource(R.drawable.warning_shape)
                ERROR -> linearLayout.setBackgroundResource(R.drawable.error_shape)
                INFO -> linearLayout.setBackgroundResource(R.drawable.info_shape)
                CONFUSING -> linearLayout.setBackgroundResource(R.drawable.confusing_shape)
                else -> {
                    linearLayout.setBackgroundResource(R.drawable.default_shape)
                    img.visibility = View.GONE
                }
            }

            toast.view = layout

            return toast
        }
    }
}