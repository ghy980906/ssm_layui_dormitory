package com.mecol.dormitory.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String address;
    private String note;
    private String className; //班级信息
    private Integer dormitoryId; //所属宿舍
    private Integer level; //职位 1 舍长 0 舍员
    private Integer sex; //0 女 1 男 2 保密


    private Integer roleId;

    private String password;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;



    private Dormitory dormitory; //学生对宿舍 多对一关系

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }


}
