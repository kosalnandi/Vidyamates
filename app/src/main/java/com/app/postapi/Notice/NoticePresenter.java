package com.app.postapi.Notice;

import android.widget.Toast;

import com.app.postapi.BaseClasses.BasePresenter;
import com.app.postapi.BaseClasses.SharedMethods;
import com.app.postapi.Loaders.JSONFunctions;
import com.app.postapi.Utils.AppData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class NoticePresenter extends BasePresenter {

    private final int NOTICE_URL = 1;

    public NoticePresenter(NoticeActivity activity) {
        super(activity);
        this.activity = activity;
    }

    void getNoticeList() {
        if (JSONFunctions.isInternetOn(activity)) {

            String url = AppData.commonUrl + AppData.notice;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("student_id", getSsp().getStudentId());
            getJsonFunctions().makeHttpRequest(url,"POST",hashMap,false,NOTICE_URL);
            getDialog().show();
            getDialog().setMessage("Loading please wait");
        }

        else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }


    NoticeActivity activity;
    @Override
    public void getJSONResponseResult(String result, int url_no) {

        if (getDialog().isShowing()) {
            getDialog().dismiss();
            switch (url_no) {
                case NOTICE_URL:
                    if (SharedMethods.isSuccess(result,activity)) {
                        getNoticeResponse(result);
                    }
            }
        }
    }

    private void getNoticeResponse(String response) {

        System.out.println("Inside the getNoticeResponse" +response);

      if (response != null) {
          try {
              JSONObject jsonObject = new JSONObject(response);
              int result = jsonObject.getInt("result");
              String message = jsonObject.getString("message");

              if (result == 1) {

                  JSONArray data = jsonObject.getJSONArray(AppData.data);
                  activity.noticeModel = new ArrayList<NoticeListModel>();

                  //loop for first array
                  for (int i = 0; i < data.length(); i++) {
                      JSONArray jsonArray = data.getJSONArray(i);
                      NoticeListModel noticeListModel = new NoticeListModel();
                      ArrayList<NoticeModel> allNotice = new ArrayList<>();

                      //loop for second array to get the object
                      for (int j =0; j < jsonArray.length(); j++) {
                          JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                          Gson gson = new Gson();
                          NoticeModel materialModel = gson.fromJson(jsonObject1.toString(),NoticeModel.class);
                          allNotice.add(materialModel);
                      }

                      noticeListModel.setAllNoticeList(allNotice);
                      activity.noticeModel.add(noticeListModel);
                  }


                  if (activity.noticeModel.size()!=0) {
                      activity.setAdapter();
                  }

                  else {
                      Toast.makeText(activity, "No Data Available", Toast.LENGTH_SHORT).show();
                  }
              }

              else  {
                  Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
              }
          }
          catch (Exception e) {
              e.printStackTrace();
          }
      }

      else {
          Toast.makeText(activity, "null response", Toast.LENGTH_SHORT).show();
      }

    }
}
