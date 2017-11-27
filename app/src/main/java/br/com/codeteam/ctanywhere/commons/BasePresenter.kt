package br.com.codeteam.ctanywhere.commons

import br.com.codeteam.ctanywhere.exception.CTException

abstract class BasePresenter<View : BaseView>: BaseInterfacePresenter<View> {

    private var view: View? = null

    override fun attach(view: View) {
        this.view = view
    }

    override fun view(): View? {

        if (this.view == null) {
            throw CTException("View is NULL on presenter, please call the fun attach(view: T) on your view")
        }

        return this.view
    }
}
