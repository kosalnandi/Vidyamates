package com.app.postapi.Notice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.app.postapi.R;

import java.util.ArrayList;
import java.util.Objects;

public class NoticeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView iv_back;
    ArrayList<NoticeListModel> noticeModel;
    NoticePresenter noticePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}

        setContentView(R.layout.activity_notice);

        initUi();
        click();
    }

    private void click() {
        iv_back.setOnClickListener(v -> {
            finish();
        });
    }

    private void initUi() {

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        iv_back = (ImageView)findViewById(R.id.iv_back);
        noticePresenter = new NoticePresenter(NoticeActivity.this);
        noticePresenter.getNoticeList();
    }

    void setAdapter() {

        recyclerView.setLayoutManager(new LinearLayoutManager(NoticeActivity.this));
        NoticeAdapter noticeAdapter = new NoticeAdapter(NoticeActivity.this,noticeModel);
        recyclerView.setAdapter(noticeAdapter);
    }
}