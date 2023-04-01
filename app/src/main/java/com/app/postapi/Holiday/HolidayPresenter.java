package com.app.postapi.Holiday;

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

public class HolidayPresenter extends BasePresenter {

    private final int HOLIDAY_URL = 1;

    HolidayActivity activity;
    public HolidayPresenter(HolidayActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void getHolidayService() {

        if (JSONFunctions.isInternetOn(activity)) {

            String url = AppData.commonUrl + AppData.holidayList;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("student_id",getSsp().getStudentId());
            getJsonFunctions().makeHttpRequest(url,"POST",hashMap,false,HOLIDAY_URL);
            getDialog().show();
            getDialog().setMessage("Loading Please Wait...");
        }
        else {
            Toast.makeText(activity, "No internet connection", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void getJSONResponseResult(String result, int url_no) {

        if (getDialog().isShowing()) {
            getDialog().dismiss();
            switch (url_no){
                case HOLIDAY_URL:
                    if (SharedMethods.isSuccess(result,activity)) {
                        getHolidayResponse(result);
                    }
                    break;
            }
        }
    }

    private void getHolidayResponse(String response) {

        System.out.println("Inside getParentHolidayResponse method:"+response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int result = jsonObject.getInt("result");
            String message = jsonObject.getString("message");

            if (result == 1) {
                JSONArray jsonArray = jsonObject.getJSONArray(AppData.data);
                activity.holidayModels = new ArrayList<>();

                for (int i = 0; i <  jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    Gson gson = new Gson();
                    HolidayModel materialModel =  gson.fromJson(jsonObject1.toString(), HolidayModel.class);
                    activity.holidayModels.add(materialModel);
                }
                if( activity.holidayModels.size() != 0){
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
