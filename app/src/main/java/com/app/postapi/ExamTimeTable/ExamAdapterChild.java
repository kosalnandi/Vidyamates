package com.app.postapi.ExamTimeTable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.R;

import java.util.ArrayList;

public class ExamAdapterChild extends RecyclerView.Adapter<ExamAdapterChild.MyViewHolder> {

    ExamTimeTableActivity activity;
    ArrayList<ExamTimeTableModel> examTimeTableModelChild;

    public ExamAdapterChild(ArrayList<ExamTimeTableModel> examTimeTableModels, ExamTimeTableActivity activity) {
        this.examTimeTableModelChild = examTimeTableModels;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.row_exam_child,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_subject.setText("Subject: "+examTimeTableModelChild.get(position).getSubject());
        holder.tv_exam_date.setText("Date :"+examTimeTableModelChild.get(position).getExam_date());
        holder.tv_timing.setText("Time :"+examTimeTableModelChild.get(position).getTiming());

    }

    @Override
    public int getItemCount() {

        return examTimeTableModelChild.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_subject, tv_exam_date, tv_timing;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_exam_date = itemView.findViewById(R.id.tv_exam_date);
            tv_timing = itemView.findViewById(R.id.tv_timing);
        }
    }
}
