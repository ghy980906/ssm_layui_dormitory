package com.mecol.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mecol.dormitory.dao.CleanDao;
import com.mecol.dormitory.entity.Clean;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanServiceImpl implements CleanService{

    @Autowired
    private CleanDao cleanDao;

    @Override
    public ResultUtil getClassList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Clean> cleans=cleanDao.getCleanList();
        PageInfo<Clean> cleanPageInfo=new PageInfo<>(cleans);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(cleanPageInfo.getTotal());

        resultUtil.setData(cleanPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public void insertClean(Clean clean) {
        cleanDao.insertClean(clean);
    }

    @Override
    public void updateClean(Clean clean) {
        cleanDao.updateClean(clean);
    }

    @Override
    public Clean getCleanById(Integer id) {
        return cleanDao.getCleanById(id);
    }

    @Override
    public void delCleanById(int id) {
        cleanDao.delCleanById(id);
    }

    @Override
    public List<Clean> getCleanList() {
        return cleanDao.getCleanList();
    }


}
