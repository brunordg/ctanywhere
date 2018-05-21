package br.com.codeteam.ctanywhere.view.ext

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

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

fun Context.checkSelfPermissions(permission: String) = ContextCompat.checkSelfPermission(this, permission)

fun Context.getColorCompat(@ColorRes res: Int): Int = ContextCompat.getColor(this, res)

fun Context.getDrawableCompat(@DrawableRes res: Int): Drawable = ContextCompat.getDrawable(this, res)!!