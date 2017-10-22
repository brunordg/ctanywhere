package br.com.codeteam.ctanywhere.commons

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

abstract class BaseFragment : Fragment(), BaseView {

    override fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type) {
        SnackCustom(activity as BaseActivity).build(id, type).show()
    }

    override fun showSnackBar(message: String, type: SnackCustom.Type) {
        SnackCustom(activity as BaseActivity).build(message, type).show()
    }

    fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
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
    fun showAlert(context: Context, title: String, message: String) {
        with(AlertDialog.Builder(context)) {
            setTitle(title)
            setMessage(message)
        }
    }

    fun AlertDialog.Builder.positiveButton(name: String = "OK", clickListener: (which: Int) -> Any = {}) {
        setPositiveButton(name, { _, which -> clickListener(which)})
    }

    fun AlertDialog.Builder.negativeButton(name: String = "Cancelar", clickListener: (which: Int) -> Any = {}) {
        setNegativeButton(name, { _, which -> clickListener(which)})
    }

}
