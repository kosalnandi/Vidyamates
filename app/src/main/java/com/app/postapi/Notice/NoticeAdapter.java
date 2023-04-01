package com.app.postapi.Notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder> {

    NoticeActivity activity;
    ArrayList<NoticeListModel> noticeListModels;

    public NoticeAdapter( NoticeActivity activity, ArrayList<NoticeListModel> noticeListModels) {
        this.activity = activity;
        this.noticeListModels = noticeListModels;
    }


    @Override
    public NoticeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(activity);
        view = mInflater.inflate(R.layout.row_notice, parent, false);
        return new NoticeAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NoticeAdapter.MyViewHolder holder, final int position) {
        holder.setIsRecyclable(false);

        //doubt
        String[] separated = activity.noticeModel.get(position).getAllNoticeList().get(0).getNotice_date().split("/");

        int year = Integer.parseInt(separated[0].split(" ")[0]);
        String[] month = separated[0].split(" ");




        holder.tv_name.setText(activity.noticeModel.get(position).getAllNoticeList().get(0).getInstitution_id());
        holder.tv_exam_type.setText(activity.noticeModel.get(position).getAllNoticeList().get(0).getSubject_name());
        holder.tv_desc.setText(activity.noticeModel.get(position).getAllNoticeList().get(0).getDescription());
        holder.tv_date.setText(String.valueOf(year) + "\n" + month[1] );


    }


    @Override
    public int getItemCount() {
        return activity.noticeModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_date,tv_name,tv_exam_type,tv_desc;



        public MyViewHolder(View itemView) {
            super(itemView);


            tv_name = itemView.findViewById(R.id.tv_time);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_exam_type = itemView.findViewById(R.id.tv_subjects);
            tv_desc = itemView.findViewById(R.id.tv_teacher);

        }
    }

}

