package com.app.postapi.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.app.postapi.Home.HomeActivity;
import com.app.postapi.Login.LoginActivity;
import com.app.postapi.R;
import com.app.postapi.Utils.SettingSharedPreferences;
import com.app.postapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        goToNextScreen(2000);
    }

    @SuppressLint("HandlerLeak")
    private void goToNextScreen(long delay) {

        new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                SettingSharedPreferences ssp = new SettingSharedPreferences(getApplicationContext());
                if (ssp.getUSERID() != null ) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.sendEmptyMessageDelayed(0, delay);
    }
}