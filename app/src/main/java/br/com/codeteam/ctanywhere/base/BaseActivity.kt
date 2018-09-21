package br.com.codeteam.ctanywhere.base

import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import br.com.codeteam.ctanywhere.view.snackbar.SnackCustom

abstract class BaseActivity: AppCompatActivity() {

    /**
     * Exibi o SnackBar Custom
     */
    @Suppress("unused")
    fun showSnackBar(@StringRes id: Int, type: SnackCustom.Type) {
        SnackCustom(this).build(id, type).show()
    }

    /**
     * Exibi o SnackBar Custom
     */
    @Suppress("unused")
    fun showSnackBar(message: String, type: SnackCustom.Type) {
        SnackCustom(this).build(message, type).show()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Suppress("unused")
    fun transparentStatusBar() {
        window.statusBarColor = Color.TRANSPARENT
    }

    @Suppress("unused")
    fun label(): String {
        return resources.getString(packageManager.getActivityInfo(componentName, 0).labelRes)
    }

    /**
     * <b>Example:</b> loadFragment { replace(R.id.frame_layout, Fragment1())}
     */
    @Suppress("unused")
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
    @Suppress("unused")
    fun showAlert(context: Context, title: String, message: String, dialogBuilder: AlertDialog.Builder.() -> Unit) {
        with(AlertDialog.Builder(context)) {
            setTitle(title)
            setMessage(message)
            setCancelable(false)
        }.dialogBuilder()
    }

    @Suppress("unused")
    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}
