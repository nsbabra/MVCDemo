package app1.mvcdemo.nsbabra.mvcdemo;

/**
 * Created by nsbabra on 2/9/16.
 */
public interface LoginInteractor {
    void login(String username, String password, OnLoginFinishedListener listener);
}
