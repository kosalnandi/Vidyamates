package com.app.postapi.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.postapi.R;

import java.util.ArrayList;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<StudentListModel> studentListModels;
    //doubt
    ArrayList<String> strStudentList = null;
    HomePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}

        setContentView(R.layout.activity_home);

        initUi();
    }

    private void initUi() {

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        presenter = new HomePresenter(HomeActivity.this);
        presenter.setListService();
    }

    public void setAdapter() {

        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        HomeAdapter homeAdapter = new HomeAdapter(studentListModels,HomeActivity.this);
        recyclerView.setAdapter(homeAdapter);
    }
}