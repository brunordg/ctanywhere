package br.com.codeteam.ctanywhere.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.codeteam.ctanywhere.exception.CTRuntimeException
import timber.log.Timber

@Suppress("unused")
abstract class BasePresenter<View : BaseView> {

    private var isAttach = false

    var view: View? = null

    open fun onViewCreated() { }

    abstract fun onViewDestroyed()

    fun attach(view: View) {
        this.isAttach = true

        this.view = view
    }

    fun view(): View? {
        this.isViewValid()

        return view
    }

    fun getContext(): Context {
        this.isViewValid()

        return when (this.view) {
            is Fragment -> (this.view as Fragment).requireContext()
            else -> (this.view as AppCompatActivity).applicationContext
        }
    }

    private fun isViewValid(): Boolean {
        if (null == this.view && !this.isAttach) {
            Timber.e("View is NULL on presenter, please call the fun attach(view: T) on your view")
            throw CTRuntimeException("View is NULL on presenter, please call the fun attach(view: T) on your view")
        }

        return true
    }
}
