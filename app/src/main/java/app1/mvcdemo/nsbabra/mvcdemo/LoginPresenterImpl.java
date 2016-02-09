package app1.mvcdemo.nsbabra.mvcdemo;

/**
 * Created by nsbabra on 2/8/16.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(final String username, final String password) {
        if(loginView != null){
            loginView.showProgressbar();
        }
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onUserNameError() {
        loginView.hideProgressbar();
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.hideProgressbar();
        loginView.setPasswordError();
    }

    @Override
    public void onSuccess() {
        loginView.hideProgressbar();
        loginView.navigateToHome();
    }
}
