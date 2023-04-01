package com.app.postapi.Notice;

public class NoticeModel {

    String notice_id;
    String institution_id;
    String subject_name;
    String description;
    String notice_date;

    public NoticeModel(String notice_id, String institution_id, String subject_name, String description, String notice_date) {
        this.notice_id = notice_id;
        this.institution_id = institution_id;
        this.subject_name = subject_name;
        this.description = description;
        this.notice_date = notice_date;
    }

    public String getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(String notice_id) {
        this.notice_id = notice_id;
    }

    public String getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(String institution_id) {
        this.institution_id = institution_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(String notice_date) {
        this.notice_date = notice_date;
    }



}
