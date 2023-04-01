package com.app.postapi.RecordedVideo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.Home.HomeAdapter;
import com.app.postapi.R;

import java.util.ArrayList;

public class RecordedAdapter extends RecyclerView.Adapter<RecordedAdapter.MyViewHolder> {

    RecordedVideoActivity activity;
    ArrayList<RecordedVideoModel> recordedVideoModels;

    public RecordedAdapter(RecordedVideoActivity activity, ArrayList<RecordedVideoModel> recordedVideoModels) {
        this.activity = activity;
        this.recordedVideoModels = recordedVideoModels;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.row_recorded_video,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_subject.setText(recordedVideoModels.get(position).getSubject());
        holder.tv_count.setText(recordedVideoModels.get(position).getCount());
    }

    @Override
    public int getItemCount() {
        return recordedVideoModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_subject, tv_count;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_count = itemView.findViewById(R.id.tv_count);
        }
    }
}
