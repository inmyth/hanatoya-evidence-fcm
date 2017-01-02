package jp.hanatoya.evidence.fcm.login;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.hanatoya.evidence.fcm.R;
import jp.hanatoya.evidence.fcm.log.LogContract;


public class LoginFragment extends Fragment implements LoginContract.View{

    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.til_username) TextInputLayout tilUsername;
    @BindView(R.id.til_password) TextInputLayout tilPassword;
    @BindView(R.id.pb) ProgressBar pb;
    @BindView(R.id.login) Button login;

    @OnClick(R.id.login)
    @Override
    public void loginClick(){
        clearErrors();

        if (TextUtils.isEmpty(username.getText())){
            tilUsername.setError(getString(R.string.error_required));
            return;
        }

        if (TextUtils.isEmpty(password.getText())){
            tilPassword.setError(getString(R.string.error_required));
            return;
        }

//        login if fcmtoken is available

                String token = FirebaseInstanceId.getInstance().getToken();

        // Log and toast
        Toast.makeText(getActivity(), token, Toast.LENGTH_LONG).show();
    }


    private LoginPresenter presenter;

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = (LoginPresenter) presenter;
    }

    @Override
    public void switchLoginPb(boolean isLoginVisible) {
        if (isLoginVisible){
            pb.setVisibility(View.GONE);
            login.setVisibility(View.VISIBLE);
        }else{
            pb.setVisibility(View.VISIBLE);
            login.setVisibility(View.GONE);
        }
    }

    private void clearErrors(){
        tilUsername.setError(null);
        tilUsername.setErrorEnabled(false);
        tilPassword.setError(null);
        tilPassword.setErrorEnabled(false);
    }

}



