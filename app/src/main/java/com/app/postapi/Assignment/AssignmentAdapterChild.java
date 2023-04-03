package com.app.postapi.Assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.R;

import java.util.ArrayList;

public class AssignmentAdapterChild extends RecyclerView.Adapter<AssignmentAdapterChild.MyViewHolder> {

    AssignmentActivity activity;
    ArrayList<AssignmentModel> assignmentModelChild;

    public AssignmentAdapterChild(
            ArrayList<AssignmentModel> assignmentModelChild,
            AssignmentActivity activity
                                 ) {
        this.assignmentModelChild = assignmentModelChild;
        this.activity = activity;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.row_assignment_child,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

      /*  String separated[] = activity.assignmentModelChild.get(position).getAssigning_date().split("/");
        int year = Integer.parseInt(separated[0].split("")[0]);
        String[] month = separated[0].split("");
        holder.tv_date.setText(String.valueOf(year)+ "/n" + month[1]);*/

        holder.tv_date.setText(assignmentModelChild.get(position).getAssigning_date());
        holder.tv_submission_date.setText("Submission_date: "+assignmentModelChild.get(position).getSubmission_date());
        holder.tv_subject.setText("Subject: "+assignmentModelChild.get(position).getSubject());
        holder.tv_description.setText("Description: "+assignmentModelChild.get(position).getDescription());
        holder.tv_teacher_name.setText("Teacher: "+assignmentModelChild.get(position).getTeacher_name());

    }

    @Override
    public int getItemCount() {
        return assignmentModelChild.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_date, tv_submission_date, tv_subject, tv_description, tv_teacher_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_submission_date = itemView.findViewById(R.id.tv_submission_date);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_teacher_name = itemView.findViewById(R.id.tv_teacher_name);
        }
    }
}
