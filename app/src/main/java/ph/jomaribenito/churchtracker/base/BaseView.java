package ph.jomaribenito.churchtracker.base;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface BaseView extends MvpView {

    void showError(String error);

    void showProgressDialog();

    void showProgressDialog(String title, String message, boolean cancelable);

    void showProgressDialog(int titleId, int messageId, boolean cancelable);

    void hideProgressDialog();

}
