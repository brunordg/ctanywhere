package br.com.codeteam.ctanywhere.base

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.fragment.app.Fragment
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

abstract class BaseFragment<P: BasePresenter<BaseView>> : Fragment(), BaseView {

    lateinit var presenter: P

    protected abstract fun instantiatePresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.instantiatePresenter()
    }

    override fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type) {
        SnackCustom(activity as BaseActivity<*>).build(id, type).show()
    }

    override fun showSnackBar(message: String, type: SnackCustom.Type) {
        SnackCustom(activity as BaseActivity<*>).build(message, type).show()
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

    fun getBaseActivity(): BaseActivity<*> {
        return activity as BaseActivity<*>
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
