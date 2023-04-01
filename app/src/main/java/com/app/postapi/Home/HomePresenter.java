package com.app.postapi.Home;

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

public class HomePresenter  extends BasePresenter {

    HomeActivity activity;

    private final int RECO_SUB = 1;

    public HomePresenter(HomeActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void setListService() {

        if (JSONFunctions.isInternetOn(activity)) {
            String url = AppData.commonUrl + AppData.studentList;

            HashMap<String, String> hashMap = new HashMap<>();
            //doubt
            hashMap.put("userid", getSsp().getUSERID());
            getJsonFunctions().makeHttpRequest(url,"Post",hashMap,false,RECO_SUB);
            getDialog().show();
            getDialog().setMessage("Loading please wait ");
        }
    }

    @Override
    public void getJSONResponseResult(String result, int url_no) {

        if (getDialog().isShowing()) {
            getDialog().dismiss();

            switch (url_no) {
                case RECO_SUB:
                    if (SharedMethods.isSuccess(result,activity)) {
                        getListResponse(result);
                    }

            }
        }
    }

    //doubt
    private void getListResponse(String response) {

        System.out.println("Inside getListResponse");

        if (response != null) {

           try {
               JSONObject object = new JSONObject(response);
               int result = object.getInt("result");
               String message = object.getString("message");

               if (result == 1) {

                   // Doubt why JsonArray instead of JsonObject
                   JSONArray jsonArray = object.getJSONArray(AppData.data);
                   activity.studentListModels = new ArrayList<>();
                   activity.strStudentList = new ArrayList<>();
                   //doubt
                   for (int i = 0; i < jsonArray.length(); i++) {

                       JSONObject obj = jsonArray.getJSONObject(i);
                       Gson gson = new Gson();
                       StudentListModel materialModel = gson.fromJson(obj.toString(), StudentListModel.class);

                       activity.studentListModels.add(materialModel);

                       //activity.strStudentList.add(materialModel.getStudent_name());
                   }

                   if( activity.studentListModels.size()!=0){
                       activity.setAdapter();
                   }
                   else{
                       Toast.makeText(activity, "No Data Available", Toast.LENGTH_SHORT).show();;
                   }

               } else {
                   Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();

               }

           } catch (JSONException e) {
               e.printStackTrace();
           }
        }
    }
}
