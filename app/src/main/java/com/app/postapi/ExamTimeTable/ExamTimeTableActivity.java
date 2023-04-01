package com.app.postapi.ExamTimeTable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.app.postapi.R;
import com.app.postapi.databinding.ActivityExamTimeTableBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamTimeTableActivity extends AppCompatActivity {

    private ActivityExamTimeTableBinding binding;
    ArrayList<ExamTimeTableModel> examTimeTableModelParent;
    ArrayList<ExamTimeTableModel> examTimeTableModelChild;
    ExamPresenter presenter;

    HashMap<String, ArrayList<ExamTimeTableModel>> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExamTimeTableBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ExamPresenter(ExamTimeTableActivity.this);
        presenter.getTimeTableList();

        backPress();
    }

   public void setAdapter() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(ExamTimeTableActivity.this));
        ExamAdapterParent adapter = new ExamAdapterParent(ExamTimeTableActivity.this,examTimeTableModelParent,examTimeTableModelChild);
        binding.recyclerView.setAdapter(adapter);
    }

    private void backPress() {
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}