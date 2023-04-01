package com.app.postapi.BaseClasses;

import android.app.ProgressDialog;
import android.content.Context;

import com.app.postapi.Loaders.JSONFunctions;
import com.app.postapi.Utils.SettingSharedPreferences;

public abstract class BasePresenter implements JSONFunctions.OnJSONResponseListener {
    private final JSONFunctions jsonFunctions;
    private final ProgressDialog progressDialog;
    private final SettingSharedPreferences ssp;

    public BasePresenter(Context context){
        jsonFunctions = new JSONFunctions(BasePresenter.this);
        progressDialog = new ProgressDialog(context);
        ssp = new SettingSharedPreferences(context);
    }

    public JSONFunctions getJsonFunctions() {
        return jsonFunctions;
    }

    public ProgressDialog getDialog() {
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    public SettingSharedPreferences getSsp() {
        return ssp;
    }
}
