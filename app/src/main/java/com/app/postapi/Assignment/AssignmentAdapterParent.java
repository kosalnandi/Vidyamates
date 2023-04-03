package com.app.postapi.Assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.ExamTimeTable.ExamAdapterParent;
import com.app.postapi.R;

import java.util.ArrayList;

public class AssignmentAdapterParent extends RecyclerView.Adapter<AssignmentAdapterParent.MyViewHolder> {

    AssignmentActivity activity;
    ArrayList<AssignmentModel> assignmentModelParent;
    ArrayList<AssignmentModel> assignmentModelChildren;


    public AssignmentAdapterParent(AssignmentActivity activity,
                                   ArrayList<AssignmentModel> assignmentModelParent,
                                   ArrayList<AssignmentModel> assignmentModelChildren) {
        this.activity = activity;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.row_assignment_parent,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        /*  ExamAdapterChild examAdapterChild = new ExamAdapterChild(
                this.examTimeTableModelChild = activity.hashMap.get(activity.examTimeTableModelParent.get(position).getExam_name()),activity);*/

        AssignmentAdapterChild assignmentAdapterChild = new AssignmentAdapterChild(
                this.assignmentModelChildren = activity.hashMap.get(activity.assignmentModelParent.get(position).getSubject_name()),activity);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        holder.recyclerView.setAdapter(assignmentAdapterChild);
    }

    @Override
    public int getItemCount() {
        return activity.assignmentModelParent.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }
}
