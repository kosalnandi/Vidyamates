package com.app.postapi.VideoClass;

public class VideoClassModel {

    String schedule_date;
    String schedule_time;
    String subject_name;
    String teacher_id;
    String teacher_name;
    String video_link;

    public VideoClassModel(String schedule_date, String schedule_time, String subject_name, String teacher_id, String teacher_name, String video_link) {
        this.schedule_date = schedule_date;
        this.schedule_time = schedule_time;
        this.subject_name = subject_name;
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.video_link = video_link;
    }

    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public String getSchedule_time() {
        return schedule_time;
    }

    public void setSchedule_time(String schedule_time) {
        this.schedule_time = schedule_time;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }




}
