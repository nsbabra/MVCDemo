package app1.mvcdemo.nsbabra.mvcdemo;

import android.os.Handler;
import android.text.TextUtils;


/**
 * Created by nsbabra on 2/9/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(TextUtils.isEmpty(username)){
                    listener.onUserNameError();
                }else if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                }else{
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
