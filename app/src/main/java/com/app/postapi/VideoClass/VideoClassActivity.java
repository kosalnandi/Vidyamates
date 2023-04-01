package com.app.postapi.VideoClass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.postapi.R;

import java.util.ArrayList;

public class VideoClassActivity extends AppCompatActivity {

    ImageView iv_back;
    RecyclerView recyclerView;
    ArrayList<VideoClassModel> videoClassModels;
    VideoClassPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_class);

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
        iv_back = (ImageView)findViewById(R.id.iv_back);
        recyclerView = findViewById(R.id.recyclerView);
        presenter = new VideoClassPresenter(VideoClassActivity.this);
        presenter.getVideoClassService();
    }

    void setAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(VideoClassActivity.this));
        VideoClassAdapter videoClassAdapter = new VideoClassAdapter(VideoClassActivity.this,videoClassModels);
        recyclerView.setAdapter(videoClassAdapter);
    }
}