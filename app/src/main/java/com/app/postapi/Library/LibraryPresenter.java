package com.app.postapi.Library;

import android.content.Context;
import android.widget.Toast;

import com.app.postapi.BaseClasses.BasePresenter;
import com.app.postapi.BaseClasses.SharedMethods;
import com.app.postapi.Loaders.JSONFunctions;
import com.app.postapi.Notice.NoticeModel;
import com.app.postapi.Utils.AppData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LibraryPresenter extends BasePresenter {

    LibraryActivity activity;

    private final int LIBRARY_URL = 1;

    public LibraryPresenter(LibraryActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void getLibraryList() {

        if (JSONFunctions.isInternetOn(activity)) {
            String url = AppData.commonUrl + AppData.libraryList;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("student_id",getSsp().getStudentId());
            getJsonFunctions().makeHttpRequest(url, "POST",hashMap,false, LIBRARY_URL);
            getDialog().show();
            getDialog().setMessage("Loading please wait");
        }
        else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getJSONResponseResult(String result, int url_no) {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
            switch (url_no) {
                case LIBRARY_URL:
                    if (SharedMethods.isSuccess(result,activity)) {
                        getLibraryResponse(result);
                    }
            }
        }
    }

    private void getLibraryResponse(String response) {

        if (response != null) {

            try {
                JSONObject jsonObject = new JSONObject(response);
                int result = jsonObject.getInt("result");
                String message = jsonObject.getString("message");

                if (result == 1) {
                    JSONArray jsonArray = jsonObject.getJSONArray(AppData.data);
                    activity.libraryModel = new ArrayList<>();

                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        Gson gson = new Gson();
                        LibraryModel materialModel = gson.fromJson(jsonObject1.toString(), LibraryModel.class);
                        activity.libraryModel.add(materialModel);
                    }
                    if (activity.libraryModel.size()!= 0) {
                        activity.setAdapter();
                    }
                    else {
                        Toast.makeText(activity, "No Data Available", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
