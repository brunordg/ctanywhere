package br.com.codeteam.ctanywhere.commons

import br.com.codeteam.ctanywhere.exception.CTException

abstract class BasePresenter<View : BaseView> {

    private var view: View? = null

    fun attach(view: View) {
        this.view = view
    }

    fun view(): View? {

        if (this.view == null) {
            throw CTException("View is NULL on presenter, please call the fun attach(view: T) on your view")
        }

        return this.view
    }
}
