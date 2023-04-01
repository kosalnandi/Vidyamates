package com.app.postapi.Library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.postapi.R;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    ImageView iv_back;
    RecyclerView recyclerView;
    ArrayList<LibraryModel> libraryModel;
    LibraryPresenter libraryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

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
        iv_back = (ImageView) findViewById(R.id.iv_back);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        libraryPresenter = new LibraryPresenter(LibraryActivity.this);
        libraryPresenter.getLibraryList();

    }

    void setAdapter() {
          recyclerView.setLayoutManager(new LinearLayoutManager(LibraryActivity.this));
          LibraryAdapter libraryAdapter = new LibraryAdapter(LibraryActivity.this,libraryModel);
          recyclerView.setAdapter(libraryAdapter);
    }
}