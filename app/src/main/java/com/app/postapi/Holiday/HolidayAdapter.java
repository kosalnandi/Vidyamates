package com.app.postapi.Holiday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.R;

import java.util.ArrayList;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> {

    HolidayActivity activity;
    ArrayList<HolidayModel> holidayModelArrayList;
    public HolidayAdapter(HolidayActivity activity, ArrayList<HolidayModel> holidayModels) {
        this.activity = activity;
        this.holidayModelArrayList = holidayModels;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.row_holi,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_subject.setText(holidayModelArrayList.get(position).getName());
        holder.tv_date.setText(
                                holidayModelArrayList.get(position).getHoliday_from()
                                +" to "+
                                holidayModelArrayList.get(position).getHoliday_to()
        );
    }

    @Override
    public int getItemCount() {
        return holidayModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView tv_subject, tv_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_subject = (TextView)itemView.findViewById(R.id.tv_subject);
            tv_date = (TextView)itemView.findViewById(R.id.tv_date);
        }
    }
}
