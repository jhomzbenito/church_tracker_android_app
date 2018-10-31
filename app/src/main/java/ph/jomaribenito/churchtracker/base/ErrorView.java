package ph.jomaribenito.churchtracker.base;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ErrorView extends MvpView {
    public void processError(Throwable throwable);
}
