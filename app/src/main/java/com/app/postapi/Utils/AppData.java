package com.app.postapi.Utils;



import com.app.postapi.Home.StudentListModel;

import java.util.ArrayList;

public class AppData {
    //Live server
   //public static  final String commonUrl ="https://vision.kazma.co.in/Webservice/";
    public static  final String commonUrl ="https://greynew.kazma.co.in/";
  //  public static  final String commonUrl ="https://skyhigh-institute.in/";


    public static String name = null;
    public static final String TAG = "MVP";

    public static final String appid = "17886108a6d6df758e271df8368871";
    // webservices
    public static final String result = "result";
    public static final String data = "data";
    public static final String Report = "Report";
    public static final String profile = "profile";
    public static final String services = "services";
    public static final String gallery = "gallery";
    public static final String MESSAGE = "message";
    public static final String message = "message";

        //vendor
        public static final String login = "api.parent-login";
    public static final String studentList = "api.parent-student-list";
    public static final String calender = "api.parent-check-attendance";
    public static final String notice="api.parent-notice";
    public static final String leaveList="api.parent-leave-list";
    public static final String APPLYLEAVE="api.parent-apply-leave";
    public static final String assignmentList = "api.parent-check-home-work";
    public static final String showProfile = "api.parent-profile";
    public static final String videoSubject = "api.parent-video-subject";
    public static final String recordedSubject = "api.parent-video-topic";
    public static final String recordedVideo = "api.parent-video-list";
    public static final String holidayList = "api.parent-holiday";
    public static final String eventList = "api.event";
    public static final String libraryList = "api.library-book-list";
    public static final String videoClasses = "api.class-schedule";
    public static final String feeReminder = "api.feedetails";
    public static final String QUERYLIST="api.get-query";
    public static final String QUERYSEND="api.set-query";
    public static final String STUDENTTIMETABLE="api.parent-student-time-table";
    public static final String EXAMTIMETABLE="api.parent-child-exam-time-table";
    public static final String PROGRESSREPORT="api.parent-progress-report";
    public static final String LEAVINGCERTUFICATE=commonUrl+"api.parent-leavingCertificate";
    public static final String LEAVINGCERTIFICATESTATUSLIST=commonUrl+"api.parent-getLeavingCertificateList";

    public static final String cashfreetoken= commonUrl+"api.cashfreetoken";
    public static final String requestPayment= commonUrl+"api.savepayment";





    public static String subjectID="";
    public static String SubjectName="";
    public static String videoLink="";
    public static String Duration="";
    public static String subjectName="";
    public static String subjectDescriptiom="";
    public static String testID="";
    public static String pricetype="";
    public static String subject="";
    public static String testType="";
    public static String questionNo="";
    public static String totalquestion="";
    public static String option="";
    public static String nextOption="";
    public static String uniqueID="";
    public static String prevQuesNo="";
    public static String questionId="";
    public static String nextQues="";
    public static String Quesposition="";
    public static String taskId="";
    public static String assignmentStatus="";
    public static String AssignmentsubjectName = "";
    public static String upload="";
    public static String studentID="";
    public static String studentAddress="";
    public static String studentName="";
    public static String urlDigital="";
    public static String topicID="";
    public static String topicName="";
    public static String lon="";
    public static String select="";
    public static String url="";
    public static String status="";
    public static String institutionID="";
    public static String orderID="";
    public static String Amount="";
    public static String registrationNo="";
    public static String monthNo="";



    public static final int request_url_no_1 = 1;
    public static final int request_url_no_2 = 2;
    public static final int request_url_no_3 = 3;
    public static final int request_url_no_4 = 4;
    public static final int request_url_no_5 = 5;


    public static ArrayList<StudentListModel> studentListModel;
    public static ArrayList<String> studentNameListModel;


    public static String mobileNo="";
    public static String emailID="";
}
