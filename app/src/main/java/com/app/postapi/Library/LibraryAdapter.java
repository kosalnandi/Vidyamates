package com.app.postapi.Library;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.postapi.R;

import java.util.ArrayList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.MyViewHolder> {

    LibraryActivity activity;
    ArrayList<LibraryModel> libraryModel;

    public LibraryAdapter(LibraryActivity activity, ArrayList<LibraryModel> libraryModel) {
        this.activity = activity;
        this.libraryModel = libraryModel;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.row_library,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_book_name.setText(activity.libraryModel.get(position).getBook_name());
        holder.tv_issue_date.setText(activity.libraryModel.get(position).getIssue_date());
        holder.tv_return_date.setText(activity.libraryModel.get(position).getReturn_date());
    }

    @Override
    public int getItemCount() {
        return libraryModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_name, tv_issue_date, tv_return_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_book_name = itemView.findViewById(R.id.tv_book_name);
            tv_issue_date = itemView.findViewById(R.id.tv_issue_date);
            tv_return_date = itemView.findViewById(R.id.tv_return);
        }
    }
}
