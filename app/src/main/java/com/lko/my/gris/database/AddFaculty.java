package com.lko.my.gris.database;

/**
 * Created by QServer on 4/23/2016.
 */
public class AddFaculty {
    private String facultyid;
    private String email;
    private String password;
    private String name;
    private String department;
    private String mobile;


    public AddFaculty() {
    }

    public AddFaculty(String facultyid,String email, String password, String name, String department, String mobile) {

        this.facultyid = facultyid;
        this.email = email;
        this.password = password;
        this.name = name;
        this.department = department;
        this.mobile = mobile;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
