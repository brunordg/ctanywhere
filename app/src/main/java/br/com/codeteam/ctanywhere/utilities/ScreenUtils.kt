package br.com.codeteam.ctanywhere.utilities

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.TextView
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import br.com.codeteam.ctanywhere.context.ApplicationConstants

object ScreenUtils {
    fun getScreenWidth(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        windowManager.let {
            val dm = DisplayMetrics()
            it.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }
    }

    fun getScreenHeight(context: Context): Int {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.let {
            val dm = DisplayMetrics()
            it.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }
    }

    fun getVectorForPreLollipop(resourceId: Int, activity: Context): Drawable? =
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                VectorDrawableCompat.create(activity.resources, resourceId, activity.theme)
            } else {
                activity.resources.getDrawable(resourceId, activity.theme)
            }

    fun setVectorForPreLollipop(textView: TextView, resourceId: Int, activity: Context, position: ApplicationConstants) {
        val icon = getVectorForPreLollipop(resourceId, activity)

        when (position) {
            ApplicationConstants.DRAWABLE_LEFT -> textView.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
            ApplicationConstants.DRAWABLE_RIGHT -> textView.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            ApplicationConstants.DRAWABLE_TOP -> textView.setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null)
            ApplicationConstants.DRAWABLE_BOTTOM -> textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, icon)
        }
    }
}