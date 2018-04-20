package br.com.codeteam.ctanywhere.commons

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import br.com.codeteam.ctanywhere.exception.CTRuntimeException
import timber.log.Timber

abstract class BasePresenter<View : BaseView>: BaseInterfacePresenter<View> {

    private var view: View? = null

    override fun attach(view: View) {
        this.view = view
    }

    override fun view(): View {
        this.isViewValid()

        return this.view!!
    }

    fun getContext(): Context? {
        this.isViewValid()

        return when (this.view) {
            is Fragment -> (this.view as Fragment).context
            else -> (this.view as AppCompatActivity).applicationContext
        }
    }

    private fun isViewValid(): Boolean {
        if (null == this.view) {
            Timber.e("View is NULL on presenter, please call the fun attach(view: T) on your view")
            throw CTRuntimeException("View is NULL on presenter, please call the fun attach(view: T) on your view")
        }

        return true
    }
}
