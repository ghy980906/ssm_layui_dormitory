package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.Fix;

import java.util.List;

public interface FixDao {
    List<Fix> getFixList();

    void insertFix(Fix fix);

    Fix getFixById(int id);

    void updateFix(Fix fix);

    void delFixById(int id);

    List<Fix> getMyFixList(Integer student_id);
}
