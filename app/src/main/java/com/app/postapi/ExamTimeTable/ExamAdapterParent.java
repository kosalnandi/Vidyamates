package com.app.postapi.ExamTimeTable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.Holiday.HolidayAdapter;
import com.app.postapi.R;

import java.util.ArrayList;

public class ExamAdapterParent extends RecyclerView.Adapter<ExamAdapterParent.MyViewHolder> {

    ExamTimeTableActivity activity;
    ArrayList<ExamTimeTableModel> examTimeTableModelParent;
    ArrayList<ExamTimeTableModel> examTimeTableModelChild;

    public ExamAdapterParent(ExamTimeTableActivity activity,
                             ArrayList<ExamTimeTableModel> examTimeTableModelParent,
                             ArrayList<ExamTimeTableModel> examTimeTableModelChild) {
        this.activity = activity;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.row_exam_parent,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_exam_name.setText("Exam Name: "+activity.examTimeTableModelParent.get(position).getExam_name());

        ExamAdapterChild examAdapterChild = new ExamAdapterChild(
                this.examTimeTableModelChild = activity.hashMap.get(activity.examTimeTableModelParent.get(position).getExam_name()),activity);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        holder.recyclerView.setAdapter(examAdapterChild);
    }
/* HolidayAdapterChild myAdapter = new HolidayAdapterChild(
                this.holidayModelsChild = activity.hashMap.get(activity.holidayModelParent.get(position).getMonth_name()),
                activity
        );*/
    @Override
    public int getItemCount() {
        return activity.examTimeTableModelParent.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_exam_name;
        RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_exam_name = itemView.findViewById(R.id.tv_exam_name);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }
}
