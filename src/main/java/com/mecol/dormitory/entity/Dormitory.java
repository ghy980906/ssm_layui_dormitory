package com.mecol.dormitory.entity;

import java.io.Serializable;
import java.util.List;

public class Dormitory implements Serializable {
    private  Integer dormitoryId;
    private String dormitoryNumber;
    private String dormitoryPhoto; //存放宿舍照片
    private String dormitoryPhotoDetail;//宿舍详细照片 多张照片



    //宿舍 学生 一对多关系
    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


    public String getDormitoryPhotoDetail() {
        return dormitoryPhotoDetail;
    }

    public void setDormitoryPhotoDetail(String dormitoryPhotoDetail) {
        this.dormitoryPhotoDetail = dormitoryPhotoDetail;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getDormitoryNumber() {
        return dormitoryNumber;
    }

    public void setDormitoryNumber(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    public String getDormitoryPhoto() {
        return dormitoryPhoto;
    }

    public void setDormitoryPhoto(String dormitoryPhoto) {
        this.dormitoryPhoto = dormitoryPhoto;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "dormitoryId=" + dormitoryId +
                ", dormitoryNumber='" + dormitoryNumber + '\'' +
                ", dormitoryPhoto='" + dormitoryPhoto + '\'' +
                ", dormitoryPhotoDetail='" + dormitoryPhotoDetail + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
