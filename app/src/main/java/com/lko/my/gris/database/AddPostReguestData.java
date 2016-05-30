package com.lko.my.gris.database;

/**
 * Created by QServer on 5/21/2016.
 */
public class AddPostReguestData {

    private String auto_id ;
    private String date ;
    private String student_id;
    private  String department;
    private String filetext;
    private  String status;
    private  String answer;

    public AddPostReguestData() {
    }


    public AddPostReguestData(String date, String department, String filetext, String status) {
        this.date = date;
        this.department = department;
        this.filetext = filetext;
        this.status = status;
    }

    public AddPostReguestData(String date, String filetext, String status,String answer,String department) {
        this.date = date;

        this.filetext = filetext;
        this.status = status;
        this.answer = answer;
    }

    public AddPostReguestData(String date, String student_id, String department, String filetext, String status,String answers) {
        this.date = date;
        this.student_id = student_id;
        this.department = department;
        this.filetext = filetext;
        this.status = status;
        this.answer = answers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFiletext() {
        return filetext;
    }

    public void setFiletext(String filetext) {
        this.filetext = filetext;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(String auto_id) {
        this.auto_id = auto_id;
    }
}
