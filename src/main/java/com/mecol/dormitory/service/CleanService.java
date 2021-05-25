package com.mecol.dormitory.service;

import com.mecol.dormitory.entity.Clean;
import com.mecol.dormitory.util.ResultUtil;

import java.util.List;

public interface CleanService {
    ResultUtil getClassList(Integer page, Integer limit);

    void insertClean(Clean clean);

    void updateClean(Clean clean);

    Clean getCleanById(Integer id);

    void delCleanById(int id);


    List<Clean> getCleanList();
}
