package com.app.postapi.Profile;

import android.content.Context;
import android.widget.Toast;

import com.app.postapi.BaseClasses.BasePresenter;
import com.app.postapi.BaseClasses.SharedMethods;
import com.app.postapi.Loaders.JSONFunctions;
import com.app.postapi.Utils.AppData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ProfilePresenter extends BasePresenter {

    ProfileActivity activity;

    private final int LOGIN_URL = 1;

    public ProfilePresenter(ProfileActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void showProfile() {

        if (JSONFunctions.isInternetOn(activity)) {

            String url = AppData.commonUrl + AppData.showProfile;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("user_id",getSsp().getUSERID());
            hashMap.put("student_id",getSsp().getStudentId());

           getJsonFunctions().makeHttpRequest(url,"POST",hashMap,false,LOGIN_URL);
           getDialog().show();
           getDialog().setMessage("Loading please wait...");
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
                case LOGIN_URL:

                    if (SharedMethods.isSuccess(result,activity)) {
                        getLoginResponse(result);
                    }
            }
        }
    }

    private void getLoginResponse(String response) {

        System.out.println("Inside getLoginResponse method:" + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int result = jsonObject.getInt("result");
            String message = jsonObject.getString("message");

            if (result == 1) {
                JSONObject object = jsonObject.getJSONObject(AppData.data);
                activity.tv_name.setText(object.getString("fullname"));
                activity.tv_address.setText(object.getString("address"));
                activity.tv_state.setText(object.getString("state"));
                activity.tv_parents_name.setText(object.getString("parent_name"));
                activity.tv_dob.setText(object.getString("dob"));
                activity.tv_email.setText(object.getString("email"));
                activity.tv_mobile.setText(object.getString("mobile_no"));
                activity.tv_section.setText(object.getString("section"));
                activity.tv_roll_no.setText(object.getString("roll_no"));
                activity.tv_class.setText(object.getString("class")
                                          +"/Sec-"+object.getString("section")
                                          +"/Roll-"+object.getString("roll_no"));

            }

            else {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
