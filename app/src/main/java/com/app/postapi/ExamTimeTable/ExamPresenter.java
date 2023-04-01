package com.app.postapi.ExamTimeTable;

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

public class ExamPresenter extends BasePresenter {

    ExamTimeTableActivity activity;
    private final int EXAM_NO = 1;

    public ExamPresenter( ExamTimeTableActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void getTimeTableList() {

        if (JSONFunctions.isInternetOn(activity)) {
            String url = AppData.commonUrl + AppData.EXAMTIMETABLE;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("student_id", getSsp().getStudentId());
            getDialog().show();
            getDialog().setMessage("Loading ruko: ");
            getJsonFunctions().makeHttpRequest(url,"POST",hashMap,false,EXAM_NO);

        }
        else {
            Toast.makeText(activity, "No internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getJSONResponseResult(String result, int url_no) {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
            switch (url_no) {
                case EXAM_NO:
                    if (SharedMethods.isSuccess(result,activity)) {
                        getTimeTableResponse(result);
                    }
            }
        }
    }

    private void getTimeTableResponse(String response) {

        if (response != null) {

          try {
              JSONObject jsonObject = new JSONObject(response);
              int result = jsonObject.getInt("result");
              String message = jsonObject.getString("message");

              if (result == 1) {

                  JSONArray jsonArray = jsonObject.getJSONArray(AppData.data);
                  activity.examTimeTableModelParent = new ArrayList<>();

                  for (int i = 0; i < jsonArray.length(); i++) {
                      ExamTimeTableModel examTimeTableModel = new ExamTimeTableModel();

                      JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                      examTimeTableModel.setExam_name(jsonObject1.getString("exam_name"));
                      activity.examTimeTableModelParent.add(examTimeTableModel);

                      JSONArray jsonArray1 = jsonObject1.getJSONArray("schedule");
                      activity.examTimeTableModelChild = new ArrayList<>();

                      for (int j = 0; j <jsonArray1.length(); j++) {
                          ExamTimeTableModel examTimeTableModel1 = new ExamTimeTableModel();
                          JSONObject jsonObject2 = jsonArray1.getJSONObject(j);

                          examTimeTableModel1.setSubject(jsonObject2.getString("subject"));
                          examTimeTableModel1.setExam_date(jsonObject2.getString("exam_date"));
                          examTimeTableModel1.setTiming(jsonObject2.getString("timing"));
                          activity.examTimeTableModelChild.add(examTimeTableModel1);

                          activity.hashMap.put(jsonObject1.getString("exam_name"), activity.examTimeTableModelChild);
                      }

                      activity.setAdapter();
                  }

              }
          }

          catch (JSONException e) {
              e.printStackTrace();
          }
        }
    }
}
