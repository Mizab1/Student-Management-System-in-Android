package me.mizab.studentmanagementsystem.model;

public class StudInfo {
    private int id;
    private String name;
    private String age;
    private String rollNo;
    private String enrollNo;
    private String email;
    private String branch;
    private String year;
    private String phone;

    public StudInfo(String name, String age, String rollNo, String enrollNo, String email, String branch, String year, String phone) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.enrollNo = enrollNo;
        this.email = email;
        this.branch = branch;
        this.year = year;
        this.phone = phone;
    }

    public StudInfo() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEnrollNo() {
        return enrollNo;
    }
    public void setEnrollNo(String enrollNo) {
        this.enrollNo = enrollNo;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
