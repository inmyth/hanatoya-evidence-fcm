package jp.hanatoya.evidence.fcm.login;

import jp.hanatoya.evidence.fcm.BasePresenter;
import jp.hanatoya.evidence.fcm.BaseView;
import jp.hanatoya.evidence.fcm.log.LogContract;



public interface LoginContract {

    public interface Presenter extends BasePresenter{


    }


    public interface View extends BaseView<LoginContract.Presenter> {

        void loginClick();

        void switchLoginPb(boolean isLoginVisible);
    }

}
