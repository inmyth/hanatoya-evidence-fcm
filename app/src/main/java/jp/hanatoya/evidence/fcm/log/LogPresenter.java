package jp.hanatoya.evidence.fcm.log;


import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import jp.hanatoya.evidence.fcm.login.LoginContract;
import jp.hanatoya.evidence.fcm.repo.Notice;
import jp.hanatoya.evidence.fcm.repo.NoticeDao;

public class LogPresenter implements LogContract.Presenter{

    @NonNull private NoticeDao noticeDao;
    @NonNull private LogContract.View view;

    public LogPresenter(@NonNull NoticeDao noticeDao, @NonNull LogContract.View view) {
        this.noticeDao = noticeDao;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void refreshList() {
        List<Notice> noticeList = noticeDao.loadAll();
        view.refreshList(noticeList);
    }
}
