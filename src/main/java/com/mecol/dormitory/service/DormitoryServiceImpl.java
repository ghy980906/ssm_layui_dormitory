package com.mecol.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mecol.dormitory.dao.DormitoryDao;
import com.mecol.dormitory.entity.Dormitory;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService{

    @Autowired
    private DormitoryDao dormitoryDao;

    @Override
    public List<Dormitory> getAllDormitories() {
        return dormitoryDao.getAllDormitories();
    }


    @Override
    public ResultUtil getDormitoryList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Dormitory> dormitories=dormitoryDao.getDormitoryList();
        PageInfo<Dormitory> dormitoryPageInfo=new PageInfo<>(dormitories);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(dormitoryPageInfo.getTotal());

        resultUtil.setData(dormitoryPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public Dormitory checkDormitoryNumber(String dormitoryNumber) {
        return dormitoryDao.checkDormitoryNumber(dormitoryNumber);
    }

    @Override
    public void insertDormitory(Dormitory dormitory) {
        dormitoryDao.insertDormitory(dormitory);
    }

    @Override
    public void deleteByDormitoryId(int dormitoryId) {
        dormitoryDao.deleteByDormitoryId(dormitoryId);
    }

    @Override
    public Dormitory getDormitoryById(int dormitoryId) {
        return dormitoryDao.getDormitoryById(dormitoryId);
    }
}
