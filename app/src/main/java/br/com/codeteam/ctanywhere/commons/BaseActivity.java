package br.com.codeteam.ctanywhere.commons;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bruno Rodrigues e Rodrigues on 11/04/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    
    public ProgressDialog mProgressDialog;
    
    /**
     * Show ProgressDialog
     */
    public void showProgressDialog() {
        
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new ProgressDialog(this);
            this.mProgressDialog.setIndeterminate(true);
        }
        
        this.mProgressDialog.show();
    }
    
    /**
     * Hide ProgressDialog
     */
    public void hideProgressDialog() {
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        this.hideProgressDialog();
    }
}
