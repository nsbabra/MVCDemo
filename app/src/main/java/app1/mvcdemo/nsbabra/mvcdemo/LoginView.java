package app1.mvcdemo.nsbabra.mvcdemo;

/**
 * Created by nsbabra on 2/8/16.
 */
public interface LoginView {
    void showProgressbar();

    void hideProgressbar();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
