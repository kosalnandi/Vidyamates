package com.app.postapi.Home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.Dashboard.StudentDashboardActivity;
import com.app.postapi.R;
import com.app.postapi.Utils.AppData;
import com.app.postapi.Utils.SettingSharedPreferences;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    HomeActivity activity;
    ArrayList<StudentListModel> list;
    public HomeAdapter(ArrayList<StudentListModel> list, HomeActivity activity) {
        this.activity = activity;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.row_home,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //binding our row design with studentListModel
        holder.tv_name.setText(activity.studentListModels.get(position).getStudent_name());
        holder.tv_school.setText(activity.studentListModels.get(position).getInstitution_name());
        holder.tv_class.setText(

                "Class" +activity.studentListModels.get(position).getClass_name()
                +"/" +"Sec " +activity.studentListModels.get(position).getSection_name()
                +"/" +"Roll "+activity.studentListModels.get(position).getRoll_no()
                +"/ " +activity.studentListModels.get(position).getHouse_name()
        );

        //setup Image View
        Glide
                .with(activity)
                .load(activity.studentListModels.get(position).getPhoto())
                .into(holder.imageView);
//Doubt
        holder.constraintLayout.setOnClickListener(v -> {
            String studentId = activity.studentListModels.get(position).getId();
            String studentName = activity.studentListModels.get(position).getStudent_name();
            String address = activity.studentListModels.get(position).getAddress();
            String institutionId = activity.studentListModels.get(position).getInstitution_id();

            //we have saved the studentId in the homeActivity because for: e.g.
            //father have 4 children then we have for different studentsId's
            SettingSharedPreferences ssp = new SettingSharedPreferences(activity.getApplicationContext());
            ssp.setStudentId(studentId);

            AppData.studentID = studentId;
            AppData.studentName = studentName;
            AppData.studentAddress = address;
            AppData.institutionID = institutionId;

            AppData.mobileNo = activity.studentListModels.get(position).getContact_no();
            AppData.emailID = activity.studentListModels.get(position).getEmail();


            Intent intent = new Intent(activity.getApplicationContext(), StudentDashboardActivity.class);
            activity.startActivity(intent);

        });
    }


    @Override
    public int getItemCount() {
        return activity.studentListModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_school, tv_class;
        ConstraintLayout constraintLayout;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_class = (TextView)itemView.findViewById(R.id.tv_class);
            tv_school = (TextView)itemView.findViewById(R.id.tv_school);
            imageView = (ImageView)itemView.findViewById(R.id.iv_profile_img);
            constraintLayout = (ConstraintLayout)itemView.findViewById(R.id.const_student);
        }
    }
}