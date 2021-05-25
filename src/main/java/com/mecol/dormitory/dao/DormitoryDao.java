package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.Dormitory;

import java.util.List;

public interface DormitoryDao {
    List<Dormitory> getAllDormitories();


    List<Dormitory> getDormitoryList();

    Dormitory checkDormitoryNumber(String dormitoryNumber);

    void insertDormitory(Dormitory dormitory);

    void deleteByDormitoryId(int dormitoryId);

    Dormitory getDormitoryById(int dormitoryId);
}
