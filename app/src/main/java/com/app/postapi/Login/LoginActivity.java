package com.app.postapi.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.app.postapi.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText ET_password, ET_username;
    Button login_btn;
    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // to hide tool bar
        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}

        setContentView(R.layout.login_main);

        initUi();
        click();
    }

    private void initUi() {

        ET_username = (EditText) findViewById(R.id.et_user_name);
        ET_password = (EditText) findViewById(R.id.et_password);
        login_btn = (Button) findViewById(R.id.login_Btn);

        presenter = new LoginPresenter(LoginActivity.this);
    }

    private void click() {

        login_btn.setOnClickListener(v -> {

            String username = ET_username.getText().toString().trim();
            String password = ET_password.getText().toString().trim();

            presenter.login(username,password);

        });
    }

}