package br.com.codeteam.ctanywhere.sms

import android.Manifest
import android.content.Context
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import br.com.codeteam.ctanywhere.view.ext.hasPermissions

/**
 * Created by Bruno Rodrigues e Rodrigues on 25/05/2018.
 */
class SmsPermission {

    companion object {
        const val SMS_PERMISSION_CODE = 44
    }

    fun isSmsPermissionGranted(context: Context): Boolean {
        return context.hasPermissions(Manifest.permission.READ_SMS)
    }

    fun requestReadAndSendSmsPermission(activity: AppCompatActivity) {
        ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_SMS), SMS_PERMISSION_CODE)
    }
}