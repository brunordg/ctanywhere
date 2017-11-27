package br.com.codeteam.ctanywhere.commons

interface BaseInterfacePresenter<View : BaseView> {
    fun attach(view: View)
    fun view(): View?
}