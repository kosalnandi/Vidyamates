package com.app.postapi.VideoClass;

import android.content.Context;
import android.widget.Toast;

import com.app.postapi.BaseClasses.BasePresenter;
import com.app.postapi.BaseClasses.SharedMethods;
import com.app.postapi.Loaders.JSONFunctions;
import com.app.postapi.Utils.AppData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class VideoClassPresenter extends BasePresenter {

    VideoClassActivity activity;
    private final int VIDEO_NO = 1;

    public VideoClassPresenter( VideoClassActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void getVideoClassService() {
        if (JSONFunctions.isInternetOn(activity)) {
            String url = AppData.commonUrl + AppData.videoClasses;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("user_id", getSsp().getUSERID());
            hashMap.put("student_id", getSsp().getStudentId());
            getJsonFunctions().makeHttpRequest(url,"POST",hashMap,false,VIDEO_NO);
            getDialog().show();
            getDialog().setMessage("Loading");

        }
    }

    @Override
    public void getJSONResponseResult(String result, int url_no) {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
            switch (url_no) {
                case VIDEO_NO:
                    if (SharedMethods.isSuccess(result,activity)) {
                        getVideoResponse(result);
                    }
                    break;
            }
        }
    }

    private void getVideoResponse(String response) {

        if (response != null) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                int result = jsonObject.getInt("result");
                String message = jsonObject.getString("message");
                if (result == 1) {
                    JSONArray array = jsonObject.getJSONArray(AppData.data);
                    activity.videoClassModels = new ArrayList<>();

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject1 = array.getJSONObject(i);
                        Gson gson = new Gson();
                        VideoClassModel videoClassModel = gson.fromJson(jsonObject1.toString(),VideoClassModel.class);
                        activity.videoClassModels.add(videoClassModel);
                    }
                    if (activity.videoClassModels.size() != 0) {
                        activity.setAdapter();
                    } else  {
                        Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                }
                else  {
                    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
