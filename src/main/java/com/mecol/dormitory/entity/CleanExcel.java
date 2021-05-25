package com.mecol.dormitory.entity;

import java.util.Date;

public class CleanExcel {
    private Integer id;
    private Date cleanTime;
    private String dormitoryNumber;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCleanTime() {
        return cleanTime;
    }

    public void setCleanTime(Date cleanTime) {
        this.cleanTime = cleanTime;
    }

    public String getDormitoryNumber() {
        return dormitoryNumber;
    }

    public void setDormitoryNumber(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CleanExcel{" +
                "id=" + id +
                ", cleanTime=" + cleanTime +
                ", dormitoryNumber='" + dormitoryNumber + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
