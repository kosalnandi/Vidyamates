package com.app.postapi.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.postapi.Holiday.HolidayActivity;
import com.app.postapi.Profile.ProfileActivity;
import com.app.postapi.R;
import com.app.postapi.RecordedVideo.RecordedVideoActivity;

import java.util.Objects;

public class SettingActivity extends AppCompatActivity {

    ImageView iv_cancel;
    TextView tv_profile;
    ConstraintLayout holiday_constraintLayout, const_recorded_video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //the way to remove tool bar
        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}

        setContentView(R.layout.activity_setting);

        initUi();
        click();
    }

    private void click() {

        iv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        holiday_constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, HolidayActivity.class);
                startActivity(intent);
            }
        });

        const_recorded_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, RecordedVideoActivity.class);
                startActivity(intent);
            }
        });


    }


    private void initUi() {

        //ImageViews
        iv_cancel = (ImageView)findViewById(R.id.iv_cancel);
        //TextViews
        tv_profile = (TextView)findViewById(R.id.tv_profile);
        //Constraint layout
        holiday_constraintLayout = (ConstraintLayout)findViewById(R.id.cons_holidays) ;
        const_recorded_video = (ConstraintLayout)findViewById(R.id.cons_recordedVideo);
    }
}