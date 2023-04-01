package com.app.postapi.Notice;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class NoticeListModel implements Serializable {

    @SerializedName("data")
    @Expose

    private ArrayList<NoticeModel> noticeModels;

    public ArrayList<NoticeModel> getAllNoticeList() {
        return noticeModels;
    }

    public void setAllNoticeList(ArrayList<NoticeModel> allNoticeList) {
        this.noticeModels = allNoticeList;
    }
}
