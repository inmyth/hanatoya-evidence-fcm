package jp.hanatoya.evidence.fcm.login;

import android.support.annotation.NonNull;

public class LoginPresenter  implements LoginContract.Presenter{

    @NonNull
    private LoginContract.View view;


    public LoginPresenter(@NonNull LoginContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        view.switchLoginPb(true);

    }
}
