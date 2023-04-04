package com.app.postapi.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.postapi.Assignment.AssignmentActivity;
import com.app.postapi.Events.EventActivity;
import com.app.postapi.ExamTimeTable.ExamTimeTableActivity;
import com.app.postapi.Home.HomeActivity;
import com.app.postapi.Library.LibraryActivity;
import com.app.postapi.Notice.NoticeActivity;
import com.app.postapi.R;
import com.app.postapi.Settings.SettingActivity;
import com.app.postapi.VideoClass.VideoClassActivity;

import java.util.Objects;

public class StudentDashboardActivity extends AppCompatActivity {

    ImageView iv_back, iv_setting, iv_time_table, iv_attendance, iv_notice, iv_assignment,
              iv_leave, iv_events, iv_fees, iv_library;

    TextView tv_exam_material, tv_study_material, tv_exam_time_table, tv_progress_report, tv_query,
             tv_video_class, tv_digital_material, tv_online_test;

    ConstraintLayout const_exam_material, const_study_material;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //the way to remove tool bar
        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}

        setContentView(R.layout.activity_student_dashboard);

        initUi();
        click();
    }

    private void click() {

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        iv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        iv_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });


        iv_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, LibraryActivity.class);
                startActivity(intent);
            }
        });

        tv_exam_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                const_exam_material.setVisibility(View.VISIBLE);
                const_study_material.setVisibility(View.GONE);
            }
        });
        tv_study_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                const_study_material.setVisibility(View.VISIBLE);
                const_exam_material.setVisibility(View.GONE);
            }
        });

        tv_video_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, VideoClassActivity.class);
                startActivity(intent);
            }
        });
        tv_exam_time_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, ExamTimeTableActivity.class);
                startActivity(intent);
            }
        });
        iv_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, AssignmentActivity.class);
                startActivity(intent);
            }
        });
        iv_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initUi() {

        iv_back = findViewById(R.id.iv_back);
        tv_digital_material = findViewById(R.id.tv_digital);
        tv_progress_report = findViewById(R.id.tv_progress);
        iv_fees = findViewById(R.id.iv_fee);
        tv_exam_time_table = findViewById(R.id.tv_exam_timetable);
        tv_online_test = findViewById(R.id.tv_online_test);
        tv_query = findViewById(R.id.tv_query);
        iv_library = findViewById(R.id.iv_library);
        iv_events = findViewById(R.id.iv_events);
        iv_setting = findViewById(R.id.iv_settings);
        iv_time_table = findViewById(R.id.iv_timetable);
        iv_attendance = findViewById(R.id.iv_attendence);
        iv_notice = findViewById(R.id.iv_notice);
        tv_video_class = findViewById(R.id.tv_video_class1);
        iv_leave = findViewById(R.id.iv_leave);
        iv_assignment = findViewById(R.id.iv_assignment);
        tv_exam_material = findViewById(R.id.tv_exam_material);
        tv_study_material = findViewById(R.id.tv_study_material);
        const_study_material = findViewById(R.id.cons_study_material);
        const_exam_material = findViewById(R.id.cons_exam_material);

    }
}