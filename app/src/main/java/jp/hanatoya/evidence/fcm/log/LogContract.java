package jp.hanatoya.evidence.fcm.log;

import java.util.List;

import jp.hanatoya.evidence.fcm.BasePresenter;
import jp.hanatoya.evidence.fcm.BaseView;
import jp.hanatoya.evidence.fcm.login.LoginContract;
import jp.hanatoya.evidence.fcm.repo.Notice;

public class LogContract {

    public interface Presenter extends BasePresenter{
        void refreshList();

    }

    public interface View extends BaseView<LogContract.Presenter>{

        void refreshList(List<Notice> noticeList);
    }
}
