package com.mecol.dormitory.service;

import com.mecol.dormitory.entity.Dormitory;
import com.mecol.dormitory.util.ResultUtil;

import java.util.List;

public interface DormitoryService {
    List<Dormitory> getAllDormitories();

    ResultUtil getDormitoryList(Integer page, Integer limit);

    Dormitory checkDormitoryNumber(String dormitoryNumber);

    void insertDormitory(Dormitory dormitory);

    void deleteByDormitoryId(int dormitoryId);

    Dormitory getDormitoryById(int dormitoryId);
}
