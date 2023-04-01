package com.app.postapi.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.postapi.R;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    //Image View
    ImageView iv_back,iv_profile_image,
              iv_profile_off,iv_contact_off;
    //Text View
    TextView tv_name, tv_class, tv_address, tv_state,
             tv_parents_name, tv_dob, tv_section, tv_roll_no,
             tv_email, tv_mobile;

    ConstraintLayout const_profile,const_contact_details;

    ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the way to remove tool bar
        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}

        setContentView(R.layout.activity_profile);

        initUi();
        click();
    }

    private void click() {

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initUi() {

        iv_back = findViewById(R.id.iv_back);
        iv_profile_image = findViewById(R.id.iv_profile_image);
        iv_profile_off = findViewById(R.id.iv_profile_off);
        iv_contact_off = findViewById(R.id.iv_contact_off);
        const_profile = findViewById(R.id.cons_profile);
        const_contact_details = findViewById(R.id.cons_cntact_details);
        tv_name = findViewById(R.id.tv_name);
        tv_class = findViewById(R.id.tv_class);
        tv_address = findViewById(R.id.tv_address);
        tv_state = findViewById(R.id.tv_state);
        tv_parents_name = findViewById(R.id.tv_parents_name);
        tv_dob = findViewById(R.id.tv_dob);
        tv_section = (TextView)findViewById(R.id.tv_section);
        tv_roll_no = (TextView)findViewById(R.id.tv_roll_no);
        tv_email = findViewById(R.id.tv_email);
        tv_mobile = findViewById(R.id.tv_mobile);

        profilePresenter = new ProfilePresenter(ProfileActivity.this);
        profilePresenter.showProfile();
    }
}