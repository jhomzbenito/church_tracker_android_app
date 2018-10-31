package ph.jomaribenito.churchtracker.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mobsandgeeks.saripaar.ValidationError;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by joedsantiago on 14/03/2017.
 */

public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V,P> {
    private ProgressDialog mProgressDialog;

    public abstract void initialize();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(getActivity());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initialize();
    }


    public BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }

    public void showProgressDialog() {
        showProgressDialog("Please wait...");
    }

    public void showProgressDialog(String message, boolean cancelable) {
        mProgressDialog.setCancelable(cancelable);
        mProgressDialog.setCanceledOnTouchOutside(cancelable);
        showProgressDialog(message);
    }

    public void showProgressDialog(String message) {
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    public void showProgressDialog(String title, String message, boolean cancelable) {
        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(cancelable);
        mProgressDialog.show();
    }

    public void showProgressDialog(int titleId, int messageId, boolean cancelable) {
        mProgressDialog.setTitle(titleId <= 0 ? "" : getString(titleId));
        mProgressDialog.setMessage(messageId <= 0 ? "" : getString(messageId));
        mProgressDialog.setCancelable(cancelable);
        mProgressDialog.show();
    }

    public void showError(String error){
        Toast.makeText(getBaseActivity(), error, Toast.LENGTH_LONG).show();
        hideProgressDialog();
    }

    public void showToast(String message){
        Toast.makeText(getBaseActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void hideProgressDialog() {
        if(mProgressDialog != null){
            mProgressDialog.dismiss();
        }
    }

    protected void displayErrors(List<ValidationError> errors) {

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());

            if (view instanceof TextInputLayout) {
                ((TextInputLayout) view).setError(message);
            } else if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                showError(message);
            }
        }
    }
}
