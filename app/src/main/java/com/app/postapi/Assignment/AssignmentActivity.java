package com.app.postapi.Assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.app.postapi.R;
import com.app.postapi.databinding.ActivityAssignmentBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class AssignmentActivity extends AppCompatActivity {

    private ActivityAssignmentBinding binding;
    AssignmentPresenter presenter;
    ArrayList<AssignmentModel> assignmentModelParent;
    ArrayList<AssignmentModel> assignmentModelChild;

    HashMap<String, ArrayList<AssignmentModel>> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAssignmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new AssignmentPresenter(AssignmentActivity.this);
        presenter.getAssignmentList();

        backPress();
    }

    private void backPress() {
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    void setAdapter() {

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(AssignmentActivity.this));
        AssignmentAdapterParent assignmentAdapterParent = new AssignmentAdapterParent(
                AssignmentActivity.this,assignmentModelParent,assignmentModelChild);
        binding.recyclerView.setAdapter(assignmentAdapterParent);
    }
}