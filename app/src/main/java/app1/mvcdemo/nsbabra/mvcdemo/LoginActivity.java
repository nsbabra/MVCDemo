package app1.mvcdemo.nsbabra.mvcdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Socket;


public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    public static final String TAG = "LoginActivity";

    private EditText mUsername;
    private EditText mPassword;
    private ProgressBar mProgressBar;
    private Button mButton;


    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mUsername = (EditText)findViewById(R.id.username);
        mPassword = (EditText)findViewById(R.id.password);
        mProgressBar = (ProgressBar)findViewById(R.id.progress);
        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(this);

        mPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgressbar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUsernameError() {
        mUsername.setError(getString(R.string.username_error));
        Toast.makeText(this,"Username error", Toast.LENGTH_LONG).show();;
    }

    @Override
    public void setPasswordError() {
        mPassword.setError(getString(R.string.password_error));
        Toast.makeText(this,"Password error", Toast.LENGTH_LONG).show();;
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this,"Login Done, Buraaaahhh",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(final View v) {
        mPresenter.validateCredentials(getUserName(), getPassword());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public String getUserName() {
        return mUsername.getText().toString();
    }

    public String getPassword() {
        return mPassword.getText().toString();
    }
}
