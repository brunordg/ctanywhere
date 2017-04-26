package br.com.codeteam.ctanywhere.commons;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Bruno Rodrigues e Rodrigues on 11/04/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    
    public ProgressBar mProgressBar;
    
    /**
     * Show ProgressDialog
     */
    public void showProgressDialog() {
        
        if (this.mProgressBar == null) {
            this.mProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
            this.mProgressBar.setIndeterminate(true);
        }
        
        this.mProgressBar.setVisibility(View.VISIBLE);
    }
    
    /**
     * Hide ProgressDialog
     */
    public void hideProgressDialog() {
        if (this.mProgressBar != null && this.mProgressBar.isShown()) {
            this.mProgressBar.setVisibility(View.GONE);
        }
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        this.hideProgressDialog();
    }
}
