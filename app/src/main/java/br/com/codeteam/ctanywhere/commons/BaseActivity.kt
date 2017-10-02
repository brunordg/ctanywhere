package br.com.codeteam.ctanywhere.commons

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.FragmentTransaction
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun getContext(): Context {
        return applicationContext
    }

    override fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type) {
        SnackCustom(this).build(id, type).show()
    }

    override fun showSnackBar(message: String, type: SnackCustom.Type) {
        SnackCustom(this).build(message, type).show()
    }

    fun label(): String {
        return resources.getString(packageManager.getActivityInfo(componentName, 0).labelRes)
    }

    /**
     * <b>Example:</b> loadFragment { replace(R.id.frame_layout, Fragment1())}
     */
    fun loadFragment(loadToBackStack: Boolean = false, load: FragmentTransaction.() -> Any) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val nameFragment = fragmentTransaction.load()

        if (loadToBackStack) {
            fragmentTransaction.addToBackStack(nameFragment::class.java.simpleName)
        }

        fragmentTransaction.commit()
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
    fun showAlert(context: Context, title: String, message: String, showAlertDialog: AlertDialog.Builder.() -> Any) {
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
