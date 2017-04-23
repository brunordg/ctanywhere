package br.com.codeteam.ctanywhere.commons;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;


public class BaseFragment extends Fragment {
    
    public ProgressDialog mProgressDialog;
    
    /**
     * Show ProgressDialog
     */
    public void showProgressDialog() {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new ProgressDialog(getActivity());
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
    public void onStop() {
        super.onStop();
        this.hideProgressDialog();
    }
    
    //    @Override
//    protected void onStop() {
//        super.onStop();
//        this.hideProgressDialog();
//    }
}
