package ph.jomaribenito.churchtracker.base;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import ph.jomaribenito.churchtracker.ChurchTrackerApplication;
import ph.jomaribenito.churchtracker.R;

public abstract class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    /*public final NetworkConnectionReceiver networkConnectionReceiver = new NetworkConnectionReceiver();
    public final IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");*/

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setupToolbar();
        setOrientationAsPortrait();
//        ButterKnife.bind(this);
    }

    protected void setOrientationAsPortrait(){
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setupToolbar();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        setupToolbar();
    }

    protected void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    public ChurchTrackerApplication getChurchTrackerApplication() {
        return (ChurchTrackerApplication) getApplication();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        registerReceiver(networkConnectionReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        unregisterReceiver(networkConnectionReceiver);
    }
}
