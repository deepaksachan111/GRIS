package com.lko.my.gris.database;

/**
 * Created by QServer on 5/21/2016.
 */
public class AddStudent {

    private String studentid;
    private String studentemail;
    private String studentpassword;
    private String studentname;
    private String studentcourse;
    private String studentmobile;



    public AddStudent(){

    }


    public AddStudent(String studentid, String studentemail, String studentpassword, String studentname, String studentcourse, String studentmobile) {
        this.studentid = studentid;
        this.studentemail = studentemail;
        this.studentpassword = studentpassword;
        this.studentname = studentname;
        this.studentcourse = studentcourse;
        this.studentmobile = studentmobile;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }

    public String getStudentpassword() {
        return studentpassword;
    }

    public void setStudentpassword(String studentpassword) {
        this.studentpassword = studentpassword;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentcourse() {
        return studentcourse;
    }

    public void setStudentcourse(String studentcourse) {
        this.studentcourse = studentcourse;
    }

    public String getStudentmobile() {
        return studentmobile;
    }

    public void setStudentmobile(String studentmobile) {
        this.studentmobile = studentmobile;
    }
}
