package com.mecol.dormitory.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Clean {
    private Integer id;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date cleanTime;
    private Integer dormitoryId;
    private Integer studentId;
    private Integer cleanLevel;  //清理结果 0 优秀 1 良好  2 不及格

    //记录和学生 宿舍都是多对一管理
    private Student student;
    private Dormitory dormitory;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

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

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCleanLevel() {
        return cleanLevel;
    }

    public void setCleanLevel(Integer cleanLevel) {
        this.cleanLevel = cleanLevel;
    }

    @Override
    public String toString() {
        return "Clean{" +
                "id=" + id +
                ", cleanTime=" + cleanTime +
                ", dormitoryId=" + dormitoryId +
                ", studentId=" + studentId +
                ", cleanLevel=" + cleanLevel +
                ", student=" + student +
                ", dormitory=" + dormitory +
                '}';
    }
}


