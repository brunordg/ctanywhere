package br.com.codeteam.ctanywhere.view.webview

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.os.Build
import android.os.Handler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

abstract class WebViewClient(private var timeout: Long = 30000) : WebViewClient() {

    private var isTimeout = true

    abstract fun handleUri(url: String): Boolean

    abstract fun handleTimeout()

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)

        Handler().postDelayed({
            if (isTimeout) {
                handleTimeout()
            }
        }, timeout)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        isTimeout = false
    }

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