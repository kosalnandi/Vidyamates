package com.app.postapi.VideoClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.R;

import java.util.ArrayList;

public class VideoClassAdapter extends RecyclerView.Adapter<VideoClassAdapter.MyViewHolder> {

    VideoClassActivity activity;
    ArrayList<VideoClassModel> videoClassModelArrayList;

    public VideoClassAdapter(VideoClassActivity activity, ArrayList<VideoClassModel> videoClassModels) {
        this.activity = activity;
        this.videoClassModelArrayList = videoClassModels;
    }


    @NonNull
    @Override
    public VideoClassAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(activity);
        view = mInflater.inflate(R.layout.row_video_class, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoClassAdapter.MyViewHolder holder, int position) {


        holder.schedule_time.setText("Time: " +activity.videoClassModels.get(position).getSchedule_time());
        holder.subject_name.setText("Subject: "+activity.videoClassModels.get(position).getSubject_name());
        holder.teacher_name.setText("Teacher: "+activity.videoClassModels.get(position).getTeacher_name());
    }

    @Override
    public int getItemCount() {
        return videoClassModelArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView schedule_date, schedule_time, subject_name, teacher_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            schedule_date = (TextView)itemView.findViewById(R.id.tv_date);
            schedule_time = (TextView)itemView.findViewById(R.id.tv_time);
            subject_name = (TextView)itemView.findViewById(R.id.tv_subjects);
            teacher_name = (TextView)itemView.findViewById(R.id.tv_teacher);
        }
    }
}
