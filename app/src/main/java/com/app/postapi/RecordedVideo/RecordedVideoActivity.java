package com.app.postapi.RecordedVideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.postapi.R;

import java.util.ArrayList;
import java.util.Objects;

public class RecordedVideoActivity extends AppCompatActivity {

    ImageView iv_back;
    RecyclerView recyclerView;
    ArrayList<RecordedVideoModel> recordedVideoModels;
    RecordedPresenter recordedPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}

        setContentView(R.layout.activity_recorded_video);

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
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recordedPresenter = new RecordedPresenter(RecordedVideoActivity.this);
        recordedPresenter.getListService();

    }

    void setAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(RecordedVideoActivity.this));
        RecordedAdapter recordedAdapter = new RecordedAdapter(RecordedVideoActivity.this,recordedVideoModels);
        recyclerView.setAdapter(recordedAdapter);
    }
}