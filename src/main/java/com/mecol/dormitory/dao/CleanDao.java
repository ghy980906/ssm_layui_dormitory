package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.Clean;

import java.util.List;

public interface CleanDao {
    List<Clean> getCleanList();

    void insertClean(Clean clean);

    void updateClean(Clean clean);

    Clean getCleanById(Integer id);

    void delCleanById(int id);


}
