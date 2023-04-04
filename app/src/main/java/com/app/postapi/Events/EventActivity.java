package com.app.postapi.Events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.app.postapi.R;
import com.app.postapi.databinding.ActivityEventBinding;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    private ActivityEventBinding binding;
    ArrayList<EventsModel> eventsModels;
    EventsPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new EventsPresenter(EventActivity.this);
        presenter.getEventList();
    }

    void setAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(EventActivity.this,2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        EventsAdapter parentadapter = new EventsAdapter(EventActivity.this,eventsModels);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setAdapter(parentadapter);
    }
}