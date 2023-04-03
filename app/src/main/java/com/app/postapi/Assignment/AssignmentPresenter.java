package com.app.postapi.Assignment;

import android.content.Context;
import android.widget.Toast;

import com.app.postapi.BaseClasses.BasePresenter;
import com.app.postapi.BaseClasses.SharedMethods;
import com.app.postapi.Loaders.JSONFunctions;
import com.app.postapi.Utils.AppData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class AssignmentPresenter extends BasePresenter {

    AssignmentActivity activity;
    private final int URL_NO = 1;

    public AssignmentPresenter(AssignmentActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void getAssignmentList() {

        if (JSONFunctions.isInternetOn(activity)) {
            String url = AppData.commonUrl + AppData.assignmentList;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("student_id",getSsp().getStudentId());
            getJsonFunctions().makeHttpRequest(url,"POST",hashMap,false,URL_NO);
            getDialog().show();
            getDialog().setMessage("Loading wait...");
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
                        getAssignmentResponse(result);
                    }
            }
        }
    }

    private void getAssignmentResponse(String response) {

        if (response != null) {

           try {
               JSONObject jsonObject = new JSONObject(response);
               int result = jsonObject.getInt("result");
               String message = jsonObject.getString("message");

               if (result == 1) {
                   JSONArray jsonArray = jsonObject.getJSONArray(AppData.data);
                   activity.assignmentModelParent = new ArrayList<>();

                   for (int i = 0; i < jsonArray.length(); i++) {
                       AssignmentModel assignmentModel = new AssignmentModel();
                       JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                       assignmentModel.setSubject_name(jsonObject1.getString("subject_name"));
                       activity.assignmentModelParent.add(assignmentModel);

                       JSONArray jsonArray1 = jsonObject1.getJSONArray("list");
                       activity.assignmentModelChild = new ArrayList<>();

                       for (int j = 0; j < jsonArray1.length(); j++) {
                           AssignmentModel assignmentModel1 = new AssignmentModel();
                           JSONObject jsonObject2 = jsonArray1.getJSONObject(j);

                           assignmentModel1.setTask_id(jsonObject2.getString("task_id"));
                           assignmentModel1.setTeacher_id(jsonObject2.getString("teacher_id"));
                           assignmentModel1.setTeacher_name(jsonObject2.getString("teacher_name"));
                           assignmentModel1.setSubject_id(jsonObject2.getString("subject_id"));
                           assignmentModel1.setSubject(jsonObject2.getString("subject"));
                           assignmentModel1.setAssigning_date(jsonObject2.getString("assigning_date"));
                           assignmentModel1.setSubmission_date(jsonObject2.getString("submission_date"));
                           assignmentModel1.setDescription(jsonObject2.getString("description"));
                           assignmentModel1.setStatus(jsonObject2.getString("status"));

                           activity.assignmentModelChild.add(assignmentModel1);
                           activity.hashMap.put(jsonObject1.getString("subject_name"),activity.assignmentModelChild);
                       }
                       activity.setAdapter();
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
