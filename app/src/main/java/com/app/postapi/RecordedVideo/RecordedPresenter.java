package com.app.postapi.RecordedVideo;

import android.content.Context;
import android.widget.Toast;

import com.app.postapi.BaseClasses.BasePresenter;
import com.app.postapi.BaseClasses.SharedMethods;
import com.app.postapi.Home.StudentListModel;
import com.app.postapi.Loaders.JSONFunctions;
import com.app.postapi.Utils.AppData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class RecordedPresenter extends BasePresenter {

    RecordedVideoActivity activity;

    private final int LIST_URL = 1;
    public RecordedPresenter( RecordedVideoActivity activity) {
        super(activity);
        this.activity = activity;
    }


    void getListService() {

        if (JSONFunctions.isInternetOn(activity)) {
            String url = AppData.commonUrl + AppData.videoSubject;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("user_id",getSsp().getUSERID());
            hashMap.put("student_id",getSsp().getStudentId());

            getJsonFunctions().makeHttpRequest(url,"POST",hashMap,false,LIST_URL);
            getDialog().show();
            getDialog().setMessage("Loading please wait...");
        }
    }


    @Override
    public void getJSONResponseResult(String result, int url_no) {

        if (getDialog().isShowing()) {
            getDialog().dismiss();
            switch (url_no) {
                case LIST_URL:
                    if (SharedMethods.isSuccess(result,activity)) {
                        getListResponse(result);
                    }
            }
        }
    }

    private void getListResponse(String response) {

        System.out.println("inside get list response");

        try {
            JSONObject jsonObject = new JSONObject(response);
            int result = jsonObject.getInt("result");
            String message = jsonObject.getString("message");

            if (result == 1) {

                JSONArray jsonArray = jsonObject.getJSONArray(AppData.data);
                activity.recordedVideoModels = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    Gson gson = new Gson();
                    RecordedVideoModel materialModel = gson.fromJson(jsonObject1.toString(), RecordedVideoModel.class);

                    activity.recordedVideoModels.add(materialModel);

                }
                if( activity.recordedVideoModels.size()!=0){
                    activity.setAdapter();
                }
                else{
                    Toast.makeText(activity, "No Data Available", Toast.LENGTH_SHORT).show();;
                }

            }
            else {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
