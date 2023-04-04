package com.app.postapi.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Suvo on 11-May-16.
 */
public class SettingSharedPreferences {
    private final String USERID="token";
    private final String NAME="company_name";
    private final String NAme="name";
    private final String EMAIL="email";
    private final String CONTACT="status";
    private final String STATUS="profile_percentage";
    private final String ADDRESS="address";
    private final String ITEMCODE="otp";
   private final String STUDENTID="studentid";
   private final String STUDENTUSERID="studentuserid";
   private final String MOBILE="mobile";
   private final String TRANSACTIONPASSWORD="transactionpassword";
   private final String REFRESHEDTOKEN = "refreshedtoken";
   private final int EXISTS=0;

    Context context;

    SharedPreferences customerloginPreferences,firebasePreferences,tokenPreferences;
   // private SharedPreferences.Editor selectedproductEditor;
   // private SharedPreferences selectedproduct;
    // Editor object
    SharedPreferences.Editor customerEditorLogin,firebasePreferencesEditor,editorToken;
    public SettingSharedPreferences(Context context){
        this.context=context;

        customerloginPreferences=context.getSharedPreferences("Customer Login", Context.MODE_PRIVATE);
        customerEditorLogin=customerloginPreferences.edit();

        firebasePreferences=context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        firebasePreferencesEditor=firebasePreferences.edit();

        tokenPreferences=context.getSharedPreferences("REFRESHED TOKEN", Context.MODE_PRIVATE);
        editorToken=tokenPreferences.edit();
    }

//we use sharePreference Editor object to set the value
    public void setStudentId(String studentId){
        customerEditorLogin.putString(STUDENTID,studentId).commit();
    }
//to get we use SharePreference object to get the value
    public String getStudentId(){
        return customerloginPreferences.getString(STUDENTID,null);
    }


    public void setNAme(String nAme){
        firebasePreferencesEditor.putString(NAme,nAme).commit();
    }

    public String getNAme(){
        return firebasePreferences.getString(NAme,null);
    }

    public void setUSERID(String userId){
        customerEditorLogin.putString(USERID,userId).commit();
    }

    public String getUSERID(){
        return customerloginPreferences.getString(USERID,null);
    }



    public void setNAME(String name){
        customerEditorLogin.putString(NAME,name).commit();
    }

    public String getNAME(){
        return customerloginPreferences.getString(NAME,null);
    }

    public void saveRefreshedToken(String s){
        editorToken.putString(REFRESHEDTOKEN,s).commit();
    }

    public String getRefreshedToken(){
        return tokenPreferences.getString(REFRESHEDTOKEN,null);
    }


    public void setEMAIL(String email){
        customerEditorLogin.putString(EMAIL,email).commit();
    }

    public void setSTATUS(String status){
        customerEditorLogin.putString(STATUS,status).commit();
    }


    public void setITEMCODE(String itemcode){
        customerEditorLogin.putString(ITEMCODE,itemcode).commit();
    }

    public void setMOBILE(String mobile){
        customerEditorLogin.putString(MOBILE,mobile).commit();
    }


    public void setUSERNAME(String userName){
        customerEditorLogin.putString(NAME,userName).commit();
    }

    public String getITEMCODE(){
        return customerloginPreferences.getString(ITEMCODE,null);
    }

    public String getMOBILE(){
        return customerloginPreferences.getString(MOBILE,null);
    }

    public String getEMAIL(){
        return customerloginPreferences.getString(EMAIL,null);
    }

    public String getSTATUS(){
        return customerloginPreferences.getString(STATUS,null);
    }

    public void setADDRESS(String address){
        customerEditorLogin.putString(ADDRESS,address).commit();
    }

    public String getADDRESS(){
        return customerloginPreferences.getString(ADDRESS,null);
    }
    public void setSTUDENTUSERID(String studentuserid){
        customerEditorLogin.putString(STUDENTUSERID,studentuserid).commit();
    }

    public String getSTUDENTUSERID(){
        return customerloginPreferences.getString(STUDENTUSERID,null);
    }



    public void logoutUser(){
        // Clearing all user data from Shared Preferences
        customerEditorLogin.clear().commit();

        // After logout redirect user to Login Activity
      //  Intent i = new Intent(context, LoginActivity.class);
        // Closing all the Activities
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        // Add new Flag to start new Activity
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(i);
    }



}
