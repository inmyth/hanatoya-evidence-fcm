package jp.hanatoya.evidence.fcm;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import jp.hanatoya.evidence.fcm.repo.DaoMaster;
import jp.hanatoya.evidence.fcm.repo.DaoSession;
import jp.hanatoya.evidence.fcm.util.RxBus;


public class MyApp extends Application {

    private static MyApp instance;
    private RxBus bus;
    private DaoSession daoSession;

    private static final String SCHEMA_NAME = "jp.hanatoya.evidence.fcm.android";
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        bus = new RxBus();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, SCHEMA_NAME , null);
        SQLiteDatabase db = helper.getWritableDatabase();
        daoSession = new DaoMaster(db).newSession();


    }

    public DaoSession getDaoSession() {
        return daoSession;
    }


    public static MyApp getInstance() {
        return instance;
    }

    public RxBus getBus() {
        return bus;
    }
}
