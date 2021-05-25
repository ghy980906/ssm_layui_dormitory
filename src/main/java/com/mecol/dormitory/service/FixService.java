package com.mecol.dormitory.service;

import com.mecol.dormitory.entity.Fix;
import com.mecol.dormitory.util.ResultUtil;

public interface FixService {
    ResultUtil getFixList(Integer page, Integer limit);

    void insertFix(Fix fix);

    Fix getFixById(int id);

    void updateFix(Fix fix);

    void delFixById(int id);

    ResultUtil getMyFixList(Integer page, Integer limit, Integer student_id);
}
