package com.mecol.dormitory.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Pay {
    private Integer payId;


    private Date payTime;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payEndTime;

    private Integer dormitoryId;
    private Integer student_id;

    private Integer payStatus; //0 未交费 1 已缴费
    private Integer payName; // 1水费 2电费
    private Integer payType; //0 微信 1 支付宝 2 现金 3 其他
    private String total;


    private Student student;
    private Dormitory dormitory;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Date getPayStartTime() {
        return payStartTime;
    }

    public void setPayStartTime(Date payStartTime) {
        this.payStartTime = payStartTime;
    }

    public Date getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(Date payEndTime) {
        this.payEndTime = payEndTime;
    }

    public Integer getPayName() {
        return payName;
    }

    public void setPayName(Integer payName) {
        this.payName = payName;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getUser_id() {
        return student_id;
    }

    public void setUser_id(Integer student_id) {
        this.student_id = student_id;
    }




    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

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


}
