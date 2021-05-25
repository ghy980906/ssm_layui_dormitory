package com.mecol.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mecol.dormitory.dao.FixDao;
import com.mecol.dormitory.entity.Fix;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class FixServiceImpl implements FixService{

    @Autowired
    private FixDao fixDao;

    @Override
    public ResultUtil getFixList(Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<Fix> fixes=fixDao.getFixList();
        PageInfo<Fix> fixPageInfo=new PageInfo<>(fixes);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(fixPageInfo.getTotal());

        resultUtil.setData(fixPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public void insertFix(Fix fix) {
        fixDao.insertFix(fix);
    }

    @Override
    public Fix getFixById(int id) {
        return fixDao.getFixById(id);
    }

    @Override
    public void updateFix(Fix fix) {
        fixDao.updateFix(fix);
    }

    @Override
    public void delFixById(int id) {
        fixDao.delFixById(id);
    }

    @Override
    public ResultUtil getMyFixList(Integer page, Integer limit, Integer student_id) {
        PageHelper.startPage(page,limit);
        List<Fix> fixes=fixDao.getMyFixList(student_id);
        PageInfo<Fix> fixPageInfo=new PageInfo<>(fixes);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(fixPageInfo.getTotal());

        resultUtil.setData(fixPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }


}
