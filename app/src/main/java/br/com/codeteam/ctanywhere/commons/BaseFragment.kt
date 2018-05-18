package br.com.codeteam.ctanywhere.commons

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AppCompatDrawableManager
import android.widget.ImageView
import android.widget.TextView
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

abstract class BaseFragment : Fragment(), BaseView {

    override fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type) {
        SnackCustom(activity as BaseActivity).build(id, type).show()
    }

    override fun showSnackBar(message: String, type: SnackCustom.Type) {
        SnackCustom(activity as BaseActivity).build(message, type).show()
    }

    override fun TextView.setFont(fontPath: String) {
        typeface = Typeface.createFromAsset(context.assets, fontPath)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun transparentStatusBar() {
        activity?.window?.statusBarColor = Color.TRANSPARENT
    }

    @SuppressLint("RestrictedApi")
    override fun ImageView.imageBackground(drawable: Int) {
        setImageDrawable(AppCompatDrawableManager.get().getDrawable(context, drawable))
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
    fun showAlert(context: Context, title: String, message: String, dialogBuilder: AlertDialog.Builder.() -> Unit) {
        with(AlertDialog.Builder(context)) {
            setTitle(title)
            setMessage(message)
        }.dialogBuilder()
    }
}
