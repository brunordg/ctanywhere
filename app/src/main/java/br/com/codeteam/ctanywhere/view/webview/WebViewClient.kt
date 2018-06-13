package br.com.codeteam.ctanywhere.view.webview

import android.annotation.TargetApi
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

abstract class WebViewClient: WebViewClient() {

    abstract fun handleUri(url: String): Boolean

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

        if (this.handleUri(request?.url.toString())) {
            return true
        }

        view?.loadUrl(request?.url.toString())

        return true
    }

    @Suppress("OverridingDeprecatedMember")
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        if (this.handleUri(url)) {
            return true
        }

        view.loadUrl(url)

        return true
    }
}