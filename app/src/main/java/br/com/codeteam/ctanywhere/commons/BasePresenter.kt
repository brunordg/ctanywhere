package br.com.codeteam.ctanywhere.commons

import android.content.Context
import br.com.codeteam.ctanywhere.exception.CTRuntimeException

abstract class BasePresenter<View : BaseView>: BaseInterfacePresenter<View> {

    private var view: View? = null

    override fun attach(view: View) {
        this.view = view
    }

    override fun view(): View? {
        this.isViewValid()

        return this.view
    }

    fun getContext(): Context? {
        this.isViewValid()

        if (this.view is BaseActivity || this.view is BaseFragment) {
            if (this.view?.getContext() == null) throw CTRuntimeException("Context is null on: " + this.view?.javaClass?.simpleName)

            return this.view?.getContext()!!
        }

        return null
    }

    private fun isViewValid(): Boolean {
        if (this.view == null) {
            throw CTRuntimeException("View is NULL on presenter, please call the fun attach(view: T) on your view")
        }

        return true
    }
}
