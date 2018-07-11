package br.com.codeteam.ctanywhere.view.ext

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * Created by Bruno Rodrigues e Rodrigues on 21/05/2018.
 */
fun Context.hasPermissions(vararg permissions: String): Boolean {
    for (permission in permissions) {
        if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
            return false
        }
    }

    return true
}

@Suppress("unused")
fun Context.checkSelfPermissions(permission: String) = ContextCompat.checkSelfPermission(this, permission)

fun Context.getColorCompat(@ColorRes res: Int): Int = ContextCompat.getColor(this, res)

@Suppress("unused")
fun Context.getDrawableCompat(@DrawableRes res: Int): Drawable = ContextCompat.getDrawable(this, res)!!



