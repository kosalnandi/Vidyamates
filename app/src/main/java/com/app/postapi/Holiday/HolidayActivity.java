package com.app.postapi.Holiday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.postapi.R;

import java.util.ArrayList;
import java.util.Objects;

public class HolidayActivity extends AppCompatActivity {

    ImageView iv_back;
    RecyclerView recyclerView;
    ArrayList<HolidayModel> holidayModels;
    HolidayPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}
        setContentView(R.layout.activity_holiday);

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
        presenter = new HolidayPresenter(HolidayActivity.this);
        presenter.getHolidayService();
    }
    void setAdapter() {

        recyclerView.setLayoutManager(new LinearLayoutManager(HolidayActivity.this));
        HolidayAdapter holidayAdapter = new HolidayAdapter(HolidayActivity.this,holidayModels);
        recyclerView.setAdapter(holidayAdapter);
    }
}