package jp.hanatoya.evidence.fcm.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.hanatoya.evidence.fcm.Events;
import jp.hanatoya.evidence.fcm.MyApp;
import jp.hanatoya.evidence.fcm.R;
import jp.hanatoya.evidence.fcm.log.LogFragment;
import jp.hanatoya.evidence.fcm.log.LogPresenter;
import jp.hanatoya.evidence.fcm.login.LoginFragment;
import jp.hanatoya.evidence.fcm.login.LoginPresenter;
import jp.hanatoya.evidence.fcm.util.Debug;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {


//    @OnClick(R.id.btn)
//    public void showToken(){
//        String token = FirebaseInstanceId.getInstance().getToken();
//
//        // Log and toast
//        Log.d("btn token", token);
//        Toast.makeText(MainActivity.this, token, Toast.LENGTH_LONG).show();
//
//    }

    @BindView(R.id.container) FrameLayout container;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private Subscription busSubscription;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

//        LoginFragment loginFragment = LoginFragment.newInstance();
//        new LoginPresenter(loginFragment);


//        Debug.addLogs(MyApp.getInstance().getDaoSession().getNoticeDao());
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.add(R.id.container, loginFragment);
//        ft.commit();

        LogFragment logFragment = LogFragment.newInstance();
        new LogPresenter(MyApp.getInstance().getDaoSession().getNoticeDao(), logFragment);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, logFragment);
        ft.commit();


        MyApp.getInstance()
                .getBus()
                .toObserverable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {

                    @Override
                    public void call(Object o) {
                        if (o instanceof Events.GotFCM){
                            Events.GotFCM event = (Events.GotFCM) o;
                            Toast.makeText(MainActivity.this, event.message, Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (busSubscription != null && !busSubscription.isUnsubscribed()) {
            busSubscription.unsubscribe();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key); // could have key : google.sent_time Value containing long so casting to string may error
                Log.d("On Resume Intent", "Key: " + key + " Value: " + value);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.web:
//                presenter.exportUserSettings();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
