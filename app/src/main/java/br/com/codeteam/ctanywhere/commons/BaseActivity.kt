package br.com.codeteam.ctanywhere.commons

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar

/**
 * Created by Bruno Rodrigues e Rodrigues on 11/04/17.
 */

abstract class BaseActivity : AppCompatActivity() {

    var mProgressBar: ProgressBar? = null

    /**
     * Show ProgressDialog
     */
    fun showProgressDialog() {
        if (this.mProgressBar == null) {
            this.mProgressBar = ProgressBar(this, null, android.R.attr.progressBarStyleSmall)
            this.mProgressBar!!.isIndeterminate = true
        }

        this.mProgressBar!!.visibility = View.VISIBLE
    }

    /**
     * Hide ProgressDialog
     */
    fun hideProgressDialog() {
        if (this.mProgressBar != null && this.mProgressBar!!.isShown) {
            this.mProgressBar!!.visibility = View.GONE
        }

    }

    override fun onStop() {
        super.onStop()
        this.hideProgressDialog()
    }
}
