package com.app.postapi.Events;

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

public class EventsPresenter extends BasePresenter {

    EventActivity activity;
    private final int URL_NO = 1;

    public EventsPresenter( EventActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void getEventList() {
        if (JSONFunctions.isInternetOn(activity)) {
            String url = AppData.commonUrl + AppData.eventList;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("institution_id", AppData.institutionID);
            //hashMap.put("institution_id", "4");we can even set the value statically
            getJsonFunctions().makeHttpRequest(url,"POST",hashMap,false,URL_NO);
            getDialog().show();
            getDialog().setMessage("Loading");
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
               case URL_NO:
                   if (SharedMethods.isSuccess(result,activity)) {
                       getEventResponse(result);
                   }
           }
       }
    }

    private void getEventResponse(String response) {

        if (response != null) {

            try {

                JSONObject jsonObject = new JSONObject(response);
                int result = jsonObject.getInt("result");
                String message = jsonObject.getString("message");

                if (result == 1) {
                    JSONArray jsonArray = jsonObject.getJSONArray(AppData.data);
                    activity.eventsModels = new ArrayList<>();

                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        Gson gson = new Gson();
                        EventsModel eventsModel = gson.fromJson(jsonObject1.toString(),EventsModel.class);
                        activity.eventsModels.add(eventsModel);
                    }
                    activity.setAdapter();
                }
                else {
                    Toast.makeText(activity, "No Data Available", Toast.LENGTH_SHORT).show();
                }

            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
