package com.app.postapi.Login;

import android.content.Intent;
import android.widget.Toast;

import com.app.postapi.BaseClasses.BasePresenter;
import com.app.postapi.BaseClasses.SharedMethods;
import com.app.postapi.Home.HomeActivity;
import com.app.postapi.Loaders.JSONFunctions;
import com.app.postapi.Login.LoginActivity;
import com.app.postapi.Utils.AppData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginPresenter  extends BasePresenter {

    LoginActivity activity;

    private final int LOGIN_URL = 1;

    public LoginPresenter(LoginActivity activity) {
        super(activity);
        this.activity = activity;
    }


    void login(String username, String password) {

        if (JSONFunctions.isInternetOn(activity)) {
            String url = AppData.commonUrl + AppData.login;

            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("username", username);
            hashMap.put("password", password);

            // hashMap.put("fcm_token",getSsp().getRefreshedToken());
            hashMap.put("fcm_token","agfyff");

            getJsonFunctions().makeHttpRequest(url, "POST", hashMap, false, LOGIN_URL);
            getDialog().show();
            getDialog().setMessage("Please Wait.....");
        }
        else {
            Toast.makeText(activity, "No Internet", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void getJSONResponseResult(String result, int url_no) {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
        }
        switch (url_no) {
            case LOGIN_URL:
                if (SharedMethods.isSuccess(result, activity)) {
                    getLoginResponse(result);
                }
                break;

        }
    }

    private void getLoginResponse(String response) {
        System.out.println("Inside getLoginResponse method:" + response);
        try {
            JSONObject object = new JSONObject(response);
            int result = object.getInt("result");
            String Message = object.getString("message");

            if(result == 1) {
                JSONObject jsonObject = object.getJSONObject(AppData.data);
                getSsp().setNAME(jsonObject.getString("name"));
                getSsp().setUSERID(jsonObject.getString("user_id"));
                getSsp().setStudentId(jsonObject.getString("student_id"));
                getSsp().setADDRESS(jsonObject.getString("address"));

                Toast.makeText(activity, Message, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity.getBaseContext(), HomeActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }

            else{
                Toast.makeText(activity, Message, Toast.LENGTH_SHORT).show();
            }


        } catch (JSONException ex) {
            Toast.makeText(activity, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
