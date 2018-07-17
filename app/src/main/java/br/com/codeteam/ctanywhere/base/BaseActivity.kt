package br.com.codeteam.ctanywhere.base

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.fragment.app.FragmentTransaction
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

abstract class BaseActivity<P: BasePresenter<BaseView>> : AppCompatActivity(), BaseView {

    lateinit var presenter: P

    protected abstract fun instantiatePresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.instantiatePresenter()
    }

    /**
     * Exibi o SnackBar Custom
     */
    override fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type) {
        SnackCustom(this).build(id, type).show()
    }

    /**
     * Exibi o SnackBar Custom
     */
    override fun showSnackBar(message: String, type: SnackCustom.Type) {
        SnackCustom(this).build(message, type).show()
    }

    override fun TextView.setFont(fontPath: String) {
        typeface = Typeface.createFromAsset(context.assets, fontPath)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun transparentStatusBar() {
        window.statusBarColor = Color.TRANSPARENT
    }

    @SuppressLint("RestrictedApi")
    override fun ImageView.imageBackground(drawable: Int) {
        setImageDrawable(AppCompatDrawableManager.get().getDrawable(context, drawable))
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
    fun showAlert(context: Context, title: String, message: String, dialogBuilder: AlertDialog.Builder.() -> Unit) {
        with(AlertDialog.Builder(context)) {
            setTitle(title)
            setMessage(message)
            setCancelable(false)
        }.dialogBuilder()
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}
