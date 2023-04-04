package com.app.postapi.Events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.Assignment.AssignmentAdapterParent;
import com.app.postapi.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    EventActivity activity;
    ArrayList<EventsModel> eventsModels;

    public EventsAdapter(EventActivity activity, ArrayList<EventsModel> eventsModels) {
        this.activity = activity;
        this.eventsModels = eventsModels;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.row_events,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_event_name.setText(activity.eventsModels.get(position).getEvent_name());
        holder.tv_event_date.setText(activity.eventsModels.get(position).getEvent_date());

        Glide
                .with(activity)
                .load(activity.eventsModels.get(position).getEvent_image())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return eventsModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv_event_name, tv_event_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            tv_event_name = itemView.findViewById(R.id.tv_event_name);
            tv_event_date = itemView.findViewById(R.id.tv_event_date);
        }
    }
}
