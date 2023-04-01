package com.app.postapi.Library;

public class LibraryModel {

    String   book_name;
    String issue_date;
    String return_date;

    public LibraryModel(String book_name, String issue_date, String return_date) {
        this.book_name = book_name;
        this.issue_date = issue_date;
        this.return_date = return_date;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

}
