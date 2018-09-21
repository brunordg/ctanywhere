package br.com.codeteam.ctanywhere.base

import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

abstract class BaseFragment: Fragment() {

    fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type) {
        SnackCustom(activity as BaseActivity).build(id, type).show()
    }

    fun showSnackBar(message: String, type: SnackCustom.Type) {
        SnackCustom(activity as BaseActivity).build(message, type).show()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun transparentStatusBar() {
        activity?.window?.statusBarColor = Color.TRANSPARENT
    }

    /**
     * <b>Example:</b><br/>
     *      showAlert(this, "Titulo", "Mensagem") {
     *          positiveButton { Toast.makeText(this@BaseActivity, "Positive Button", Toast.LENGTH_SHORT).show() }
     *          negativeButton { "No" }
     *          create()
     *          show()
     *      }
     */
    fun showAlert(context: Context, title: String, message: String, dialogBuilder: AlertDialog.Builder.() -> Unit) {
        with(AlertDialog.Builder(context)) {
            setTitle(title)
            setMessage(message)
        }.dialogBuilder()
    }
}
