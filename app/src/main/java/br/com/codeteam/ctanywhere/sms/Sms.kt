package br.com.codeteam.ctanywhere.sms

import android.Manifest
import android.content.Context
import android.support.v4.app.ActivityCompat
import br.com.codeteam.ctanywhere.commons.BaseActivity
import br.com.codeteam.ctanywhere.view.ext.hasPermissions
import br.com.codeteam.ctanywhere.view.ext.positiveButton

/**
 * Created by Bruno Rodrigues e Rodrigues on 25/05/2018.
 */
class Sms {

    companion object {
        const val SMS_PERMISSION_CODE = 44
    }

    fun isSmsPermissionGranted(context: Context): Boolean {
        return context.hasPermissions(Manifest.permission.READ_SMS)
    }

    fun requestReadAndSendSmsPermission(activity: BaseActivity) {
        ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_SMS), SMS_PERMISSION_CODE)
    }

    fun showRequestPermissionsInfoAlertDialog(makeSystemRequest: Boolean, activity: BaseActivity) {
        activity.showAlert(activity, "Ler Token", "Ler SMS de Token") {
            positiveButton {
                if (makeSystemRequest) requestReadAndSendSmsPermission(activity)
            }
            create()
            show()
        }
    }
}