package br.com.codeteam.ctanywhere.commons

import android.content.Context
import br.com.codeteam.ctanywhere.exception.CTRuntimeException

abstract class BasePresenter<View : BaseView>: BaseInterfacePresenter<View> {

    private var view: View? = null

    override fun attach(view: View) {
        this.view = view
    }

    override fun view(): View {
        this.isViewValid()

        return this.view!!
    }

    fun getContext(): Context {
        this.isViewValid()

        return this.view!!.getContext()
    }

    private fun isViewValid(): Boolean {
        if (null == this.view) {
            throw CTRuntimeException("View is NULL on presenter, please call the fun attach(view: T) on your view")
        }

        return true
    }
}
